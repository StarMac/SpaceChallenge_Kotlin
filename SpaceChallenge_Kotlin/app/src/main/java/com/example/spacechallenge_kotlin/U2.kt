package com.example.spacechallenge_kotlin

import java.util.*

class U2 : Rocket() {

    init {
        cost = 120
        weight = 18000
        weightInclCargo = weight
        maxWeight = 29000
        chanceOfLaunchExplosion = 0.0
        chanceOfLandingCrash = 0.0
    }

    override fun launch(): Boolean {
        chanceOfLaunchExplosion = 4.0 * (weightInclCargo - weight) / (maxWeight - weight)
        return chanceOfLaunchExplosion <= Random().nextInt(100) + 1
    }

    override fun land(): Boolean {
        chanceOfLandingCrash = 8.0 * (weightInclCargo - weight) / (maxWeight - weight)
        return chanceOfLandingCrash <= Random().nextInt(100) + 1
    }
}