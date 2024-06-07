package com.example.cavesofzircon.extensions

import com.example.cavesofzircon.attributes.EntityActions
import com.example.cavesofzircon.attributes.flags.BlockOccupier
import com.example.cavesofzircon.world.GameContext
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.Pass
import org.hexworks.amethyst.api.Response

val AnyGameEntity.occupiesBlock: Boolean
    get() = findAttribute(BlockOccupier::class).isPresent

suspend fun AnyGameEntity.tryActionsOn(context: GameContext, target: AnyGameEntity): Response { // 1
    var result: Response = Pass
    findAttributeOrNull(EntityActions::class)?.let {                    // 2
        it.createActionsFor(context, this, target).forEach { action ->  // 3
            if (target.receiveMessage(action) is Consumed) {            // 4
                result = Consumed
                return@forEach                                          // 5
            }
        }
    }
    return result
}