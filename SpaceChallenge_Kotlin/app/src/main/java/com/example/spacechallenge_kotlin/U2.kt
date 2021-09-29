package com.example.spacechallenge_kotlin

import java.util.*

class U2(cost: Int = 120, weight: Int = 18000, weightInclCargo: Int = weight, maxWeight: Int = 29000,
         chanceOfLaunchExplosion: Double = 0.0, chanceOfLandingCrash: Double = 0.0) : Rocket(cost,
         weight, weightInclCargo, maxWeight, chanceOfLaunchExplosion, chanceOfLandingCrash) {

    override fun launch(): Boolean {
        chanceOfLaunchExplosion = 4.0 * (weightInclCargo - weight) / (maxWeight - weight)
        return chanceOfLaunchExplosion <= Random().nextInt(100) + 1
    }

    override fun land(): Boolean {
        chanceOfLandingCrash = 8.0 * (weightInclCargo - weight) / (maxWeight - weight)
        return chanceOfLandingCrash <= Random().nextInt(100) + 1
    }
}