package com.example.spacechallenge_kotlin

import java.util.*

class U1 : Rocket() {

    init {
        cost = 100
        weight = 10000
        weightInclCargo = weight
        maxWeight = 18000
        chanceOfLaunchExplosion = 0.0
        chanceOfLandingCrash = 0.0
    }

    override fun launch(): Boolean {
        chanceOfLaunchExplosion = 5.0 * (weightInclCargo - weight) / (maxWeight - weight)
        return chanceOfLaunchExplosion <= Random().nextInt(100) + 1
    }

    override fun land(): Boolean {
        chanceOfLandingCrash = 1.0 * (weightInclCargo - weight) / (maxWeight - weight)
        return chanceOfLandingCrash <= Random().nextInt(100) + 1
    }
}
