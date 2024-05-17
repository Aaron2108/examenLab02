package com.mendez.oliver.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio02Detail : AppCompatActivity() {
     val PARAMETER_EXTRA_CLIENTE = "cliente"
     val PARAMETER_EXTRA_NUMERO_CLIENTE = "numeroCliente"
     val PARAMETER_EXTRA_PRODUCTO = "producto"
     val PARAMETER_EXTRA_UBICACION = "ubicacion"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio02_detail)

        val clienteText = findViewById<TextView>(R.id.cliente)
        val numeroText = findViewById<TextView>(R.id.numeroCliente)
        val productoText = findViewById<TextView>(R.id.productos)
        val ubicacionText = findViewById<TextView>(R.id.ubicacion)
        val extras = this.intent.extras
        extras?.let {


            if (extras.getString(PARAMETER_EXTRA_CLIENTE) != null) {
                clienteText.text = extras.getString(PARAMETER_EXTRA_CLIENTE)
            }


            if (extras.getString(PARAMETER_EXTRA_NUMERO_CLIENTE) != null) {
                numeroText.text = extras.getString(PARAMETER_EXTRA_NUMERO_CLIENTE)
            }


            if (extras.getString(PARAMETER_EXTRA_PRODUCTO) != null) {
                productoText.text = extras.getString(PARAMETER_EXTRA_PRODUCTO)
            }

            if (extras.getString(PARAMETER_EXTRA_UBICACION) != null) {
                ubicacionText.text = extras.getString(PARAMETER_EXTRA_UBICACION)
            }
        }
        val btnWhatsApp = findViewById<Button>(R.id.btnWhatsApp)
        val btnLlamar = findViewById<Button>(R.id.btnLlamar)
        val btnMaps = findViewById<Button>(R.id.btnMaps)

        btnWhatsApp.setOnClickListener {
            val nombreCliente = clienteText.text.toString()
            val productos = productoText.text.toString()
            val direccion = ubicacionText.text.toString()

            val message = "Hola $nombreCliente. Tus productos: $productos están en camino a la dirección: $direccion"
            val uri = Uri.parse("https://api.whatsapp.com/send?text=${Uri.encode(message)}")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnLlamar.setOnClickListener {
            val number = numeroText.text.toString()
            val uri = Uri.parse("tel:$number")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }
        btnMaps.setOnClickListener {
            val direccion = ubicacionText.text.toString()
            val uri = Uri.parse("geo:0,0?q=$direccion")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "No se encontró la aplicación de Google Maps",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}