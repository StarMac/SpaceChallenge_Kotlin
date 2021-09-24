package com.example.spacechallenge_kotlin

import android.content.Context
import java.io.IOException
import java.util.*

class Simulation(private val context: Context) {
    @Throws(IOException::class)
    fun loadItems(fileName: String?): ArrayList<Item> {
        val allItemsList: ArrayList<Item> = ArrayList<Item>()
        val fileScanner = Scanner(context.assets.open(fileName!!))
        while (fileScanner.hasNextLine()) {
            val tokens = fileScanner.nextLine().split("=").toTypedArray()
            val item = Item(tokens[0], tokens[tokens.size - 1].toInt())
            allItemsList.add(item)
        }
        return allItemsList
    }

    fun loadU1(allItemsList: ArrayList<Item>): ArrayList<Rocket> {
        val rocketsU1List = ArrayList<Rocket>()
        var rocketU1: Rocket = U1()
        for (item in allItemsList) {
            if (!rocketU1.canCarry(item)) {
                rocketsU1List.add(rocketU1)
                rocketU1 = U1()
            }
            rocketU1.carry(item)
        }
        rocketsU1List.add(rocketU1)
        return rocketsU1List
    }

    fun loadU2(allItemsList: ArrayList<Item>): ArrayList<Rocket> {
        val rocketsU2List: ArrayList<Rocket> = ArrayList<Rocket>()
        var rocketU2: Rocket = U2()
        for (item in allItemsList) {
            if (!rocketU2.canCarry(item)) {
                rocketsU2List.add(rocketU2)
                rocketU2 = U1()
            }
            rocketU2.carry(item)
        }
        rocketsU2List.add(rocketU2)
        return rocketsU2List
    }

    fun runSimulation(rockets: ArrayList<Rocket>): Int {
        var totalBudget = 0
        for (rocket in rockets) {
            totalBudget += rocket.getCost()
            while (!rocket.launch() || !rocket.land()) {
                totalBudget += rocket.getCost()
            }
        }
        return totalBudget
    }
}