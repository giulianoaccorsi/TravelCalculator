package com.giuliano.travelcalculator

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.giuliano.travelcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var builder1 = AlertDialog.Builder(this)
        val button = binding.button
        val textKilometer = binding.editTextNumberDecimal
        val textCar = binding.editTextNumberDecimal2
        val gasoline = binding.editTextNumberDecimal3

        button.setOnClickListener {
            val valorKilometer = textKilometer.text.toString().toBigDecimalOrNull()
            val valorCar = textCar.text.toString().toBigDecimalOrNull()
            val valorGasoline = gasoline.text.toString().toBigDecimalOrNull()

            if(valorKilometer != null && valorCar != null && valorGasoline != null) {
                val calculo = valorKilometer/valorCar * valorGasoline

                builder1.setTitle("Valor da Viagem")
                builder1.setMessage("R$ $calculo")
                builder1.show()
            }else {
                builder1.setTitle("Preenchimento Incorreto")
                builder1.setMessage("Preencher todos os texts!")
                builder1.show()
            }
        }
    }
}