package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {


    var tip = 0.00
    var subtotal = 0.00
    var percent = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodCost: EditText = findViewById(R.id.txtCost)
        val percentChoice: Spinner = findViewById(R.id.spnGroup)
        val charges: Button = findViewById(R.id.btnCharge)
        val result: TextView = findViewById(R.id.txtResult)

        charges.setOnClickListener{
            subtotal = foodCost.text.toString().toDouble()
            percent = percentChoice.selectedItem.toString()
            val percentDecimal = percent.toDouble() / 100
            tip = subtotal * percentDecimal
            val currency = DecimalFormat("$###,###.00")
            val subtotalFormatted = currency.format(subtotal)
            val tipFormatted = currency.format(tip)
            result.text = "Tip $tipFormatted for $subtotalFormatted of food"




        }

    }
}