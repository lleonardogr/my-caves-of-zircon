package com.example.cavesofzircon.views;

import com.example.cavesofzircon.GameConfig
import com.example.cavesofzircon.GameConfig.LOG_AREA_HEIGHT
import com.example.cavesofzircon.GameConfig.SIDEBAR_WIDTH
import com.example.cavesofzircon.GameConfig.WINDOW_WIDTH
import com.example.cavesofzircon.builders.Game
import com.example.cavesofzircon.builders.GameBuilder
import com.example.cavesofzircon.builders.repositories.GameTileRepository
import org.hexworks.cobalt.databinding.api.extension.toProperty
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.ComponentDecorations.box
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ColorTheme
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.game.ProjectionMode
import org.hexworks.zircon.api.grid.TileGrid
import org.hexworks.zircon.api.uievent.KeyboardEventType
import org.hexworks.zircon.api.uievent.Processed
import org.hexworks.zircon.api.view.base.BaseView
import org.hexworks.zircon.internal.game.impl.GameAreaComponentRenderer

class PlayView(
    private val grid: TileGrid,
    private val game: Game = GameBuilder.create(),
    theme: ColorTheme = GameConfig.THEME
) : BaseView(grid, theme) {
    init{
        val sidebar = Components.panel()
            .withSize(GameConfig.SIDEBAR_WIDTH, GameConfig.WINDOW_HEIGHT)
            .withDecorations(box())
            .build()

        val logArea = Components.logArea()
            .withDecorations(box(title = "Log"))            // 1
            .withSize(WINDOW_WIDTH - SIDEBAR_WIDTH, LOG_AREA_HEIGHT)
            .withAlignmentWithin(screen, ComponentAlignment.BOTTOM_RIGHT)      // 2
            .build()

        val gameComponent = Components.panel()
            .withSize(game.world.visibleSize.to2DSize())    // 1
            .withComponentRenderer(
                GameAreaComponentRenderer(                  // 2
                    gameArea = game.world,
                    projectionMode = ProjectionMode.TOP_DOWN.toProperty(), // 3
                    fillerTile = GameTileRepository.FLOOR   // 4
                )
            )
            .withAlignmentWithin(screen, ComponentAlignment.TOP_RIGHT)
            .build()

        screen.addComponents(sidebar, logArea, gameComponent)

        // Add this to init in PlayView.kt
        screen.handleKeyboardEvents(KeyboardEventType.KEY_PRESSED) { event, _ ->
            game.world.update(screen, event, game)
            Processed
        }
    }
}
