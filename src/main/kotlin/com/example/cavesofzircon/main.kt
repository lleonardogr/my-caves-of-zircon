package com.example.cavesofzircon

import com.example.cavesofzircon.views.StartView
import org.hexworks.zircon.api.CP437TilesetResources
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.SwingApplications
import org.hexworks.zircon.api.application.AppConfig
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.screen.Screen

fun main(args: Array<String>) {

    val grid = SwingApplications.startTileGrid(
        AppConfig.newBuilder() // 1 - We create a new AppConfig
            .withDefaultGraphicalTileset(CP437TilesetResources.rogueYun16x16()) // 2 - We set a tileset
            .build() // 3 - We build the AppConfig

    )

    StartView(grid).dock()
}
