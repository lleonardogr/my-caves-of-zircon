package com.example.cavesofzircon.builders

import com.example.cavesofzircon.blocks.GameBlock
import com.example.cavesofzircon.builders.repositories.GameTileRepository

object GameBlockFactory {

    fun floor() = GameBlock(GameTileRepository.FLOOR)

    fun wall() = GameBlock.createWith(EntityFactory.newWall())

}