package com.example.parcialascurra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar

class EdadendiasActivity : AppCompatActivity() {

    private val sdf = SimpleDateFormat("dd/MM/yyyy")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edadendias)

        val etFecha: EditText = findViewById(R.id.etFecha)
        val btnCalcularEdad: Button = findViewById(R.id.btnCalcularEdad)
        val etEdadDias: TextView = findViewById(R.id.etEdadDias)

        btnCalcularEdad.setOnClickListener {
            val fechaIngresada = etFecha.text.toString()

            if (fechaIngresada.isNotEmpty()) {
                val diferenciaDias = calcularDiferenciaDias(fechaIngresada)
                etEdadDias.text = "Diferencia en días: $diferenciaDias"
            } else {
                etEdadDias.text = "Ingrese una fecha válida"
            }
        }
        }
        private fun calcularDiferenciaDias(fechaIngresada: String): Long {
            try {
                val fechaActual = Calendar.getInstance().time
                val fechaIngresadaDate = sdf.parse(fechaIngresada)

                if (fechaIngresadaDate != null) {
                    val diferenciaMillis = fechaIngresadaDate.time - fechaActual.time
                    val diferenciaDias = diferenciaMillis / (24 * 60 * 60 * 1000)

                    return diferenciaDias
                } else {
                    return 0
                }
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            return 0
        }

    }