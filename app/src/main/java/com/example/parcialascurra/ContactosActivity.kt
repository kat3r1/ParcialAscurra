package com.example.parcialascurra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Locale

class ContactosActivity : AppCompatActivity() {

    private val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewContactos)

        // Crea una lista de contactos (debes reemplazar esto con tus propios datos)
        val listaContactos = listOf(
            Contacto(R.drawable.ic_launcher_foreground, "Nombre1", "123456789", "01/01/2023"),
            Contacto(R.drawable.ic_launcher_foreground, "Nombre2", "987654321", "02/01/2023"),
            // Agrega más contactos según sea necesario
        )

        // Calcular la diferencia en días y actualizar el campo diferenciaDias para cada contacto
        listaContactos.forEach {
            it.diferenciaDias = calcularDiferenciaDias(it.fechaCreacion)
        }

        // Configura el RecyclerView y el adaptador
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ContactosAdapter(listaContactos)
    }

    private fun calcularDiferenciaDias(fechaIngresada: String): Long {
        try {
            val fechaActual = Calendar.getInstance().time
            val fechaIngresadaDate = sdf.parse(fechaIngresada)

            if (fechaIngresadaDate != null) {
                val diferenciaMillis = fechaIngresadaDate.time - fechaActual.time
                // Ajuste para redondear hacia arriba en lugar de hacia abajo
                val diferenciaDias = Math.ceil(diferenciaMillis / (24 * 60 * 60 * 1000.0)).toLong()

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

class ContactosAdapter(listaContactos: Any) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

}
