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

    val grid = SwingApplications.startTileGrid(GameConfig.buildAppConfig())
    StartView(grid).dock()
}
