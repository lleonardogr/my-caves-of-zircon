package com.example.cavesofzircon.views;

import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.ComponentDecorations.box
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.grid.TileGrid
import org.hexworks.zircon.api.view.base.BaseView
import kotlin.system.exitProcess

class WinView (
        private val grid: TileGrid
) : BaseView(grid, ColorThemes.arc()
){

    init {
        val header = Components.header()
            .withText("You won!")
            .withAlignmentWithin(screen, ComponentAlignment.CENTER)
            .build()

        val restartButton = Components.button()
            .withText("Restart")
            .withAlignmentAround(header, ComponentAlignment.BOTTOM_LEFT)
            .withDecorations(box())
            .build()

        val exitButton = Components.button()
            .withText("Quit")
            .withAlignmentAround(header, ComponentAlignment.BOTTOM_RIGHT)
            .withDecorations(box())
            .build()

        restartButton.onActivated {
            replaceWith(PlayView(grid))
        }

        exitButton.onActivated {
            exitProcess(0)
        }

        screen.addComponents(header, restartButton, exitButton)
    }
}
