package com.example.spacechallenge_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var txtTotalBudgetU1: TextView
    private lateinit var txtTotalBudgetU2: TextView
    private val simulation = Simulation(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtTotalBudgetU1 = findViewById(R.id.txtTotalBudgetU1)
        txtTotalBudgetU2 = findViewById(R.id.txtTotalBudgetU2)
        val button = findViewById<Button>(R.id.btnRunSimulation)
        button.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        try {
            runTheSimulation()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @SuppressLint("SetTextI18n")
    @Throws(Exception::class)
    fun runTheSimulation() {
        var totalBudgetU1 = simulation.runSimulation(simulation.loadU1(simulation.loadItems(getString(R.string.txtphase1))))
        totalBudgetU1 += simulation.runSimulation(simulation.loadU1(simulation.loadItems(getString(R.string.txtphase2))))
        txtTotalBudgetU1.text = "Budget U1: $totalBudgetU1 million$"
        var totalBudgetU2 = simulation.runSimulation(simulation.loadU2(simulation.loadItems(getString(R.string.txtphase1))))
        totalBudgetU2 += simulation.runSimulation(simulation.loadU2(simulation.loadItems(getString(R.string.txtphase2))))
        txtTotalBudgetU2.text = "Budget U2: $totalBudgetU2 million$"
    }
}