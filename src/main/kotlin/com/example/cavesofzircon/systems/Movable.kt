package com.example.cavesofzircon.systems

import com.example.cavesofzircon.attributes.Player
import com.example.cavesofzircon.extensions.position
import com.example.cavesofzircon.extensions.tryActionsOn
import com.example.cavesofzircon.messages.MoveCamera
import com.example.cavesofzircon.messages.MoveTo
import com.example.cavesofzircon.world.GameContext
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.MessageResponse
import org.hexworks.amethyst.api.Pass
import org.hexworks.amethyst.api.Response
import org.hexworks.amethyst.api.base.BaseFacet



object Movable : BaseFacet<GameContext, MoveTo>(MoveTo::class) { // 1

    override suspend fun receive(message: MoveTo): Response {
        val (context, entity, position) = message
        val world = context.world
        val previousPosition = entity.position               // 1
        var result: Response = Pass
        world.fetchBlockAtOrNull(position)?.let { block ->                  // 1
            if (block.isOccupied) {
                result = entity.tryActionsOn(context, block.occupier.get()) // 2
            } else {
                if (world.moveEntity(entity, position)) {                   // 3
                    result = Consumed
                    if (entity.type == Player) {
                        result = MessageResponse(MoveCamera(
                            context = context,
                            source = entity,
                            previousPosition = previousPosition
                        ))
                    }
                }
            }
        }
        return result
    }
}