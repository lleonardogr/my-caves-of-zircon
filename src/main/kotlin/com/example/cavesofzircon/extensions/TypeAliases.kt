package com.example.cavesofzircon.extensions

import com.example.cavesofzircon.world.GameContext
import org.hexworks.amethyst.api.entity.Entity
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.amethyst.api.Message

typealias AnyGameEntity = GameEntity<EntityType>

typealias GameEntity<T> = Entity<T, GameContext>

typealias GameMessage = Message<GameContext>

