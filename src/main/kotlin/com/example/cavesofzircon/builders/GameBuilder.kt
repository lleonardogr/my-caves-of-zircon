package com.example.cavesofzircon.builders

import com.example.cavesofzircon.GameConfig
import com.example.cavesofzircon.GameConfig.FUNGI_PER_LEVEL
import com.example.cavesofzircon.GameConfig.LOG_AREA_HEIGHT
import com.example.cavesofzircon.GameConfig.SIDEBAR_WIDTH
import com.example.cavesofzircon.GameConfig.WINDOW_HEIGHT
import com.example.cavesofzircon.GameConfig.WINDOW_WIDTH
import com.example.cavesofzircon.GameConfig.WORLD_SIZE
import com.example.cavesofzircon.attributes.Player
import com.example.cavesofzircon.extensions.GameEntity
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.zircon.api.data.Position3D
import org.hexworks.zircon.api.data.Size
import org.hexworks.zircon.api.data.Size3D

class GameBuilder(val worldSize: Size3D) {          // 1

    private val visibleSize = Size3D.create(        // 2
        xLength = WINDOW_WIDTH - SIDEBAR_WIDTH,
        yLength = WINDOW_HEIGHT - LOG_AREA_HEIGHT,
        zLength = 1
    )

    val world = WorldBuilder(worldSize)             // 3
        .makeCaves()
        .build(visibleSize = visibleSize)


    private fun prepareWorld() = also {             // 4
        world.scrollUpBy(world.actualSize.zLength)
    }

    private fun addPlayer(): GameEntity<Player> {
        return EntityFactory.newPlayer().addToWorld(
            atLevel = GameConfig.DUNGEON_LEVELS - 1,
            atArea = world.visibleSize.to2DSize())
    }

    private fun <T : EntityType> GameEntity<T>.addToWorld(             // 1
        atLevel: Int,                                                  // 2
        atArea: Size = world.actualSize.to2DSize()): GameEntity<T> {   // 3
        world.addAtEmptyPosition(
            this,
            offset = Position3D.defaultPosition().withZ(atLevel),      // 4
            size = Size3D.from2DSize(atArea)
        )                          // 5
        return this
    }

    private fun addFungi() = also {
        repeat(world.actualSize.zLength) { level ->
            repeat(FUNGI_PER_LEVEL) {
                EntityFactory.newFungus().addToWorld(level)
            }
        }
    }

    fun buildGame(): Game {
        prepareWorld()

        val player = addPlayer()
        addFungi()

        return Game.create(
            player = player,
            world = world
        )
    }

    companion object {

        fun create() = GameBuilder(
            worldSize = WORLD_SIZE
        ).buildGame()
    }


}