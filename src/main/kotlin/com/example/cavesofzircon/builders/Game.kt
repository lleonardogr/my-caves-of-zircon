package com.example.cavesofzircon.builders

import com.example.cavesofzircon.GameConfig.GAME_AREA_SIZE
import com.example.cavesofzircon.GameConfig.WORLD_SIZE
import com.example.cavesofzircon.attributes.Player
import com.example.cavesofzircon.builders.WorldBuilder
import com.example.cavesofzircon.extensions.GameEntity
import com.example.cavesofzircon.world.World
import org.hexworks.zircon.api.data.Size3D

class Game(
    val world: World,
    val player: GameEntity<Player>
) {

    companion object {

        fun create(
            player: GameEntity<Player>,
            world: World
        ) = Game(
            world = world,
            player = player
        )
    }
}
