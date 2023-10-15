package com.example.parcialascurra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btnSignIn: Button = findViewById(R.id.btnSignIn)

        btnSignIn.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (isValidCredentials(email, password)) {
                // Credenciales válidas, iniciar MainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Credenciales inválidas, mostrar mensaje
                Snackbar.make(it, "Credenciales inválidas", Snackbar.LENGTH_SHORT).show()
            }
        }

    }
    private fun isValidCredentials(email: String, password: String): Boolean {
        // Verificar si las credenciales son válidas
        return email == "admin@multiapp.com" && password == "multiapp123"
    }


}