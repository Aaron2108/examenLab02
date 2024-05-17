package com.mendez.oliver.usolayoutsv4
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class Ejercicio01 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio01)

        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val btnOcultar = findViewById<Button>(R.id.btnOcultar)
        val cuadroVerde = findViewById<View>(R.id.cuadroVerde)


        btnMostrar.setOnClickListener {
            cuadroVerde.visibility = View.VISIBLE
        }


        btnOcultar.setOnClickListener {
            cuadroVerde.visibility = View.GONE
        }
    }
}
