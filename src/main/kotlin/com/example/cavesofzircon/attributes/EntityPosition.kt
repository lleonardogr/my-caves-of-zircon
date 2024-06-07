package com.example.cavesofzircon.attributes

import org.hexworks.amethyst.api.base.BaseAttribute
import org.hexworks.cobalt.databinding.api.extension.toProperty
import org.hexworks.zircon.api.data.Position3D

class EntityPosition(
    initialPosition: Position3D = Position3D.unknown()
) : BaseAttribute() { // 1

    private val positionProperty = initialPosition.toProperty() // 2

    var position: Position3D by positionProperty.asDelegate() // 3


}