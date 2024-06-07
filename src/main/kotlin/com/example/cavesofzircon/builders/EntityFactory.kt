package com.example.cavesofzircon.builders

import com.example.cavesofzircon.attributes.EntityPosition
import com.example.cavesofzircon.attributes.EntityTile
import com.example.cavesofzircon.attributes.Player
import com.example.cavesofzircon.builders.repositories.GameTileRepository
import com.example.cavesofzircon.builders.repositories.GameTileRepository.PLAYER
import com.example.cavesofzircon.systems.CameraMover
import com.example.cavesofzircon.world.GameContext
import org.hexworks.amethyst.api.builder.EntityBuilder
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.amethyst.api.newEntityOfType
import com.example.cavesofzircon.systems.InputReceiver
import com.example.cavesofzircon.systems.Movable

fun <T : EntityType> newGameEntityOfType(
    type: T,
    init: EntityBuilder<T, GameContext>.() -> Unit
) = newEntityOfType(type, init)                          // 1

object EntityFactory {                                   // 2

    fun newPlayer() = newGameEntityOfType(Player) {
        attributes(EntityPosition(), EntityTile(GameTileRepository.PLAYER))
        behaviors(InputReceiver)
        facets(Movable, CameraMover)
    }
}