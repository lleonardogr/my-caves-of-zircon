package com.example.cavesofzircon.blocks

import com.example.cavesofzircon.builders.repositories.GameTileRepository.EMPTY
import com.example.cavesofzircon.builders.repositories.GameTileRepository.FLOOR
import com.example.cavesofzircon.builders.repositories.GameTileRepository.WALL
import kotlinx.collections.immutable.persistentMapOf
import org.hexworks.zircon.api.data.BlockTileType
import org.hexworks.zircon.api.data.Tile
import org.hexworks.zircon.api.data.base.BaseBlock

class GameBlock(content: Tile = FLOOR) : BaseBlock<Tile>(       // 1 // 2
    emptyTile = EMPTY,
    tiles = persistentMapOf(BlockTileType.CONTENT to content)   // 3
) {

    val isFloor: Boolean                                        // 4
        get() = content == FLOOR

    val isWall: Boolean
        get() = content == WALL

}