package com.simonsonkein.spaceinvaders.models


sealed interface Entity {
    var hp: Int
    fun damage(amount: Int) {
        if (amount > hp) {
            hp = 0
            return
        }
        hp -= amount
    }
    fun damage(amount: Int, crit: Double) {
        val damage = amount * crit
        if (damage > hp) {
            hp = 0
            return
        }
        hp -= damage.toInt()
    }
}

class Player(
    override var hp: Int
) : Entity {
    override fun damage(amount: Int) {
        hp -= amount
    }
    init {
        require(hp in 0..100) {
            "HP must be between 0 and 100"
        }
    }
}

class Enemy(
    override var hp: Int
) : Entity {
    init {
        require(hp >= 0) {
            "HP must be bigger than 100"
        }
    }
}

