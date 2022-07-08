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
