package com.bahraoui.convertisseurunits

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Spinner
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val monnaie_from=findViewById<Spinner>(R.id.monnaie_from)
        val monnaie_to=findViewById<Spinner>(R.id.monnaie_to)
        val result=findViewById<TextView>(R.id.result)
        val convertBTN=findViewById<Button>(R.id.convertBTN)



        convertBTN.setOnClickListener{
            val M_from = monnaie_from.selectedItem.toString()
            val T_from = monnaie_to.selectedItem.toString()
            val currencyInputStr = findViewById<EditText>(R.id.currencyInput).text.toString()
            val currencyInput = currencyInputStr.toDoubleOrNull()

            if (currencyInput == null) {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

           val convertedCurrency=when(M_from to T_from){
               "MAD" to "Euro" ->  currencyInput*10.8097
               "MAD" to "US Dollar" -> currencyInput*9.68187
               "MAD" to "Rouble" -> currencyInput*0.104340
               "Euro" to "MAD" -> currencyInput*0.0925134
               "Euro" to "US Dollar" -> currencyInput* 0.895732
               "Euro" to "Rouble" -> currencyInput*0.00965476
               "US Dollar" to "MAD" -> currencyInput*0.103279
               "US Dollar" to "Euro" -> currencyInput*1.11631
               "US Dollar" to "Rouble" -> currencyInput*0.0107773
               "Rouble" to "MAD" -> currencyInput*0.104362
               "Rouble" to "Euro" -> currencyInput*0.00965563
               "Rouble" to "US Dollar" -> currencyInput*0.0107779

               else -> {Toast.makeText(this,"Please choose a currency!",Toast.LENGTH_LONG).show()}
           }

        result.text="Result: $convertedCurrency"

        }







    }
}