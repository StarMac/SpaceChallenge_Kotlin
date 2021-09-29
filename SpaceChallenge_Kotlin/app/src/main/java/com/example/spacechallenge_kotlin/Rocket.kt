package com.example.spacechallenge_kotlin

 open class Rocket (internal val cost: Int, protected val weight: Int, protected var weightInclCargo: Int,
                    protected val maxWeight: Int, protected var chanceOfLaunchExplosion: Double,
                    protected var chanceOfLandingCrash: Double) : SpaceShip {

    override fun launch(): Boolean = true

    override fun land(): Boolean = true

    override fun canCarry(item: Item): Boolean = weightInclCargo + item.weight <= maxWeight

    override fun carry(item: Item){
        weightInclCargo += item.weight
    }

     fun getCost(): Int = cost
}