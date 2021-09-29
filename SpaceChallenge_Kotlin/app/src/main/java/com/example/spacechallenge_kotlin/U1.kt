package com.example.spacechallenge_kotlin

import java.util.*

class U1(cost: Int = 100, weight: Int = 10000, weightInclCargo: Int = weight, maxWeight: Int = 18000,
         chanceOfLaunchExplosion: Double = 0.0, chanceOfLandingCrash: Double = 0.0) : Rocket(cost,
         weight, weightInclCargo, maxWeight, chanceOfLaunchExplosion, chanceOfLandingCrash) {

    override fun launch(): Boolean {
        chanceOfLaunchExplosion = 5.0 * (weightInclCargo - weight) / (maxWeight - weight)
        return chanceOfLaunchExplosion <= Random().nextInt(100) + 1
    }

    override fun land(): Boolean {
        chanceOfLandingCrash = 1.0 * (weightInclCargo - weight) / (maxWeight - weight)
        return chanceOfLandingCrash <= Random().nextInt(100) + 1
    }
}
