package com.example.cavesofzircon.builders.repositories

import com.example.cavesofzircon.builders.GameColors
import com.example.cavesofzircon.builders.GameColors.ACCENT_COLOR
import com.example.cavesofzircon.builders.GameColors.FLOOR_BACKGROUND
import com.example.cavesofzircon.builders.GameColors.FLOOR_FOREGROUND
import com.example.cavesofzircon.builders.GameColors.WALL_BACKGROUND
import com.example.cavesofzircon.builders.GameColors.WALL_FOREGROUND
import org.hexworks.zircon.api.data.CharacterTile
import org.hexworks.zircon.api.data.Tile
import org.hexworks.zircon.api.graphics.Symbols

object GameTileRepository {

    val EMPTY: CharacterTile = Tile.empty()

    val FLOOR: CharacterTile = Tile.newBuilder()
        .withCharacter(Symbols.INTERPUNCT)                  // 1
        .withForegroundColor(FLOOR_FOREGROUND)              // 2
        .withBackgroundColor(FLOOR_BACKGROUND)              // 3
        .buildCharacterTile()                               // 4

    val WALL: CharacterTile = Tile.newBuilder()
        .withCharacter('#')
        .withForegroundColor(WALL_FOREGROUND)
        .withBackgroundColor(WALL_BACKGROUND)
        .buildCharacterTile()

    val PLAYER = Tile.newBuilder()
        .withCharacter('@')
        .withBackgroundColor(FLOOR_BACKGROUND)
        .withForegroundColor(ACCENT_COLOR)
        .buildCharacterTile()

    val FUNGUS = Tile.newBuilder()
        .withCharacter('f')
        .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
        .withForegroundColor(GameColors.FUNGUS_COLOR)
        .buildCharacterTile()

}