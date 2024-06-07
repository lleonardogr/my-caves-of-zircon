package com.example.cavesofzircon.messages

import org.hexworks.amethyst.api.entity.EntityType
import com.example.cavesofzircon.extensions.GameEntity
import com.example.cavesofzircon.world.GameContext

data class Dig(
    override val context: GameContext,
    override val source: GameEntity<EntityType>,
    override val target: GameEntity<EntityType>
) : EntityAction<EntityType, EntityType>