package com.bahraoui.convertisseurunits

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Spinner
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import android.widget.EditText
import android.widget.ImageView
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
        val from_flag=findViewById<ImageView>(R.id.from_flag)
        val to_flag=findViewById<ImageView>(R.id.to_flag)


        convertBTN.setOnClickListener{
            val M_from = monnaie_from.selectedItem.toString()
            val T_from = monnaie_to.selectedItem.toString()
            val currencyInputStr = findViewById<EditText>(R.id.currencyInput).text.toString()
            val currencyInput = currencyInputStr.toDoubleOrNull()

            if (currencyInput == null) {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            var resultat=0.0
           val convertedCurrency=when(M_from to T_from){
               "MAD" to "Euro" -> {
                   resultat = currencyInput * 0.0925341
                   from_flag.setImageResource(R.drawable.moroccan_flag)
                   to_flag.setImageResource(R.drawable.eu_icon)
               }
               "MAD" to "US Dollar" -> {
                   resultat = currencyInput*0.103289
                   from_flag.setImageResource(R.drawable.moroccan_flag)
                   to_flag.setImageResource(R.drawable.us_icon)
               }
               "MAD" to "Rouble" -> {
                   resultat = currencyInput*9.55764
                   from_flag.setImageResource(R.drawable.moroccan_flag)
                   to_flag.setImageResource(R.drawable.russia_icon)
               }

               "Euro" to "MAD" -> {
                   resultat = currencyInput*10.8068
                   from_flag.setImageResource(R.drawable.eu_icon)
                   to_flag.setImageResource(R.drawable.moroccan_flag)
               }
               "Euro" to "US Dollar" -> {
                   resultat = currencyInput* 1.11623
                   from_flag.setImageResource(R.drawable.eu_icon)
                   to_flag.setImageResource(R.drawable.us_icon)
               }
               "Euro" to "Rouble" -> {
                   resultat = currencyInput*103.288
                   from_flag.setImageResource(R.drawable.eu_icon)
                   to_flag.setImageResource(R.drawable.russia_icon)
               }
               "US Dollar" to "MAD" -> {
                   resultat = currencyInput*0.103279
                   from_flag.setImageResource(R.drawable.us_icon)
                   to_flag.setImageResource(R.drawable.moroccan_flag)
               }
               "US Dollar" to "Euro" -> {
                   resultat = currencyInput*1.11631
                   from_flag.setImageResource(R.drawable.us_icon)
                   to_flag.setImageResource(R.drawable.eu_icon)
               }
               "US Dollar" to "Rouble" -> {
                   resultat = currencyInput*92.5331
                   from_flag.setImageResource(R.drawable.us_icon)
                   to_flag.setImageResource(R.drawable.russia_icon)
               }
               "Rouble" to "MAD" -> {
                   resultat = currencyInput*0.104628
                   from_flag.setImageResource(R.drawable.russia_icon)
                   to_flag.setImageResource(R.drawable.moroccan_flag)
               }
               "Rouble" to "Euro" -> {
                   resultat = currencyInput*0.00965563
                   from_flag.setImageResource(R.drawable.russia_icon)
                   to_flag.setImageResource(R.drawable.eu_icon)
               }
               "Rouble" to "US Dollar" -> {
                   resultat= currencyInput*0.0107779
                   from_flag.setImageResource(R.drawable.russia_icon)
                   to_flag.setImageResource(R.drawable.us_icon)
               }

               else -> null
           }

            if (convertedCurrency != null) {
                result.text = "Result: $resultat"
            } else {
                Toast.makeText(this, "Please choose a valid currency pair!", Toast.LENGTH_LONG).show()
            }

        }







    }
}