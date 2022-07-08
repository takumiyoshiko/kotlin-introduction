package com.bignerdranch.nyethack

import java.util.Random

interface Fightable {
    var healthPoints: Int
    val diceCount: Int
    val diceSlides: Int
    val damageRoll: Int
        get() = (0 until diceCount).map {
            Random().nextInt(diceSlides + 1)
        }.sum()

    fun attack(opponent: Fightable): Int
}

abstract class Monster(val name: String,
                       val description: String,
                       override var healthPoints: Int): Fightable {
    override fun attack(opponent: Fightable): Int {
        val damageDealt = damageRoll
        opponent.healthPoints -= damageDealt
        return damageDealt
    }
}

class Goblin(name: String = "Goblin",
             description: String = "A nasty-looking goblin",
             override var healthPoints: Int = 30): Monster(name, description, healthPoints) {

    override val diceCount = 2
    override val diceSlides = 8
             }

