package com.mendez.oliver.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Ejercicio02 : AppCompatActivity() {
     val PARAMETER_EXTRA_CLIENTE = "cliente"
     val PARAMETER_EXTRA_NUMERO_CLIENTE = "numeroCliente"
     val PARAMETER_EXTRA_PRODUCTO = "producto"
     val PARAMETER_EXTRA_UBICACION = "ubicacion"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio02)

        val clienteInput = findViewById<EditText>(R.id.inputNombreCliente)
        val numeroInput = findViewById<EditText>(R.id.inputNumeroCliente)
        val productosInput = findViewById<EditText>(R.id.inputProductos)
        val ciudadInput = findViewById<EditText>(R.id.inputCiudad)
        val direccionInput = findViewById<EditText>(R.id.inputDireccion)

        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        btnRegistrar.setOnClickListener {
            val clienteText = clienteInput.text.toString()
            val numeroText = numeroInput.text.toString()
            val productosText = productosInput.text.toString()
            val direccionText = direccionInput.text.toString()

            if (clienteText.isNotEmpty() && numeroText.isNotEmpty() && productosText.isNotEmpty() && direccionText.isNotEmpty()) {
                val intent = Intent(this, Ejercicio02Detail::class.java)
                intent.putExtra(PARAMETER_EXTRA_CLIENTE, clienteText)
                intent.putExtra(PARAMETER_EXTRA_NUMERO_CLIENTE, numeroText)
                intent.putExtra(PARAMETER_EXTRA_PRODUCTO, productosText)
                intent.putExtra(PARAMETER_EXTRA_UBICACION, direccionText)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Completar el formulario", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
