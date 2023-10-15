package com.example.parcialascurra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class TKambioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tkambio)

        val etTipoCambio: EditText = findViewById(R.id.etTipoCambio)
        val etMontoDolares: EditText = findViewById(R.id.etMontoDolares)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val etMontoSoles: TextView = findViewById(R.id.etMontoSoles)
        val etBillete100: TextView = findViewById(R.id.etBillete100)
        val etBillete50: TextView = findViewById(R.id.etBillete50)
        val etBillete20: TextView = findViewById(R.id.etBillete20)

        btnCalcular.setOnClickListener {
            val tipoCambio = etTipoCambio.text.toString().toDoubleOrNull() ?: 0.0
            val montoDolares = etMontoDolares.text.toString().toDoubleOrNull() ?: 0.0

            val montoSoles = tipoCambio * montoDolares
            val billete100 = montoSoles / 100
            val residuo100 = montoSoles % 100
            val billete50 = residuo100 / 50
            val residuo50 = residuo100 % 50
            val billete20 = residuo50 / 20

            etMontoSoles.text = montoSoles.toString()
            etBillete100.text = billete100.toInt().toString()
            etBillete50.text = billete50.toInt().toString()
            etBillete20.text = billete20.toInt().toString()
        }
    }
}