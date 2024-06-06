package com.example.cavesofzircon.views;

import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.ComponentDecorations.box
import org.hexworks.zircon.api.ComponentDecorations.shadow
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.grid.TileGrid
import org.hexworks.zircon.api.view.base.BaseView

class PlayView(
        private val grid: TileGrid
) : BaseView(grid, ColorThemes.arc()
) {
    init{
        val loseButton = Components.button()
            .withText("You lost! Play again?")
            .withAlignmentWithin(screen, ComponentAlignment.LEFT_CENTER)
            .withDecorations(box(), shadow())
            .build()

        val winButton = Components.button()
            .withText("You won! Play again?")
            .withAlignmentWithin(screen, ComponentAlignment.RIGHT_CENTER)
            .withDecorations(box(), shadow())
            .build()

        loseButton.onActivated {
            replaceWith(LoseView(grid))
        }

        winButton.onActivated {
            replaceWith(WinView(grid))
        }

        screen.addComponents(loseButton, winButton)
    }
}
