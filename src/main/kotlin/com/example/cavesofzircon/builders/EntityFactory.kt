package com.example.cavesofzircon.builders

import com.example.cavesofzircon.attributes.*
import com.example.cavesofzircon.attributes.flags.BlockOccupier
import com.example.cavesofzircon.builders.repositories.GameTileRepository
import com.example.cavesofzircon.extensions.EntityTypes
import com.example.cavesofzircon.messages.Attack
import com.example.cavesofzircon.messages.Dig
import com.example.cavesofzircon.systems.*
import com.example.cavesofzircon.world.GameContext
import org.hexworks.amethyst.api.builder.EntityBuilder
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.amethyst.api.newEntityOfType

fun <T : EntityType> newGameEntityOfType(
    type: T,
    init: EntityBuilder<T, GameContext>.() -> Unit
) = newEntityOfType(type, init)                          // 1

object EntityFactory {                                   // 2

    fun newPlayer() = newGameEntityOfType(Player) {
        attributes(
            EntityPosition(),
            EntityTile(GameTileRepository.PLAYER),
            EntityActions(Dig::class, Attack::class)
        )
        behaviors(InputReceiver)
        facets(Movable, CameraMover)
    }

    fun newWall() = newGameEntityOfType(EntityTypes.Wall) {
        attributes(
            EntityPosition(),
            BlockOccupier,
            EntityTile(GameTileRepository.WALL))
        facets(Diggable)
    }


    fun newFungus(fungusSpread: FungusSpread = FungusSpread()) = newGameEntityOfType(EntityTypes.Fungus) { // 1
        attributes(
            BlockOccupier,
            EntityPosition(),
            EntityTile(GameTileRepository.FUNGUS),
            fungusSpread                                // 2
        )
        facets(Attackable)
        behaviors(FungusGrowth)                         // 3
    }
}