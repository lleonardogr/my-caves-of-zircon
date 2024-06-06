package com.example.cavesofzircon.views;

import org.hexworks.zircon.api.ColorThemes;
import org.hexworks.zircon.api.ComponentDecorations.box
import org.hexworks.zircon.api.ComponentDecorations.shadow
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.grid.TileGrid;
import org.hexworks.zircon.api.view.base.BaseView;


class StartView(
        private val grid: TileGrid
) : BaseView(grid, ColorThemes.arc()){
    init{
        val msg = "Welcome to Caves of Zircon."

        val header = Components.textBox(contentWidth = msg.length) // 1 - create a header
            .addHeader(msg) // 2 - add a header text
            .addNewLine() // 3 - add an empty line
            .withAlignmentWithin(screen, ComponentAlignment.CENTER) // 4 - center the header
            .build() // 5 - build the component

        val startButton = Components.button() // 1 - create a button
            .withText("Start!") // 2 - set its text
            .withAlignmentAround(header, ComponentAlignment.BOTTOM_CENTER) // 3 - align it under the header
            .withDecorations(box(), shadow()) // 4 - decorate it
            .build() // 5 - build it

        startButton.onActivated { // 1 - when the button is activated
            replaceWith(PlayView(grid)) // 2 - replace the current view with a new one
        }

        screen.addComponents(header, startButton) // 6 - add both components to the screen

    }
}
