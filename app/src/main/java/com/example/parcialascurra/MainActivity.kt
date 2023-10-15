package com.example.parcialascurra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTkambio: Button = findViewById(R.id.btnTkambio)
        val btnEdad: Button = findViewById(R.id.btnEdad)
        val btnContacto: Button = findViewById(R.id.btnContactos)

        btnTkambio.setOnClickListener {
            val intent = Intent(this, TKambioActivity::class.java)
            startActivity(intent)
        }

        btnEdad.setOnClickListener {
            val intent = Intent(this, EdadendiasActivity::class.java)
            startActivity(intent)
        }

        btnContacto.setOnClickListener {
            val intent = Intent(this, ContactosActivity::class.java)
            startActivity(intent)
        }

    }
}