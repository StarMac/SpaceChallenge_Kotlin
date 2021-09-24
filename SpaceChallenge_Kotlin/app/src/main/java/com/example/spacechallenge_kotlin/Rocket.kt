package com.example.spacechallenge_kotlin

 open class Rocket : SpaceShip {
    internal var cost : Int = 0
    protected var weight :Int = 0
    protected var weightInclCargo : Int = 0
    protected var maxWeight : Int = 0
    protected var chanceOfLaunchExplosion : Double = 0.0
    protected var chanceOfLandingCrash : Double = 0.0

    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }

    override fun canCarry(item: Item): Boolean {
        return weightInclCargo + item.weight <= maxWeight
    }

    override fun carry(item: Item) {
        weightInclCargo += item.weight
    }

     fun getCost(): Int {
        return cost
    }
}