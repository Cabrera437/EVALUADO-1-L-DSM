package com.example.promedionotas01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nombreEstudiante = findViewById<EditText>(R.id.idEstudiante)
        var nota1 = findViewById<EditText>(R.id.idCalificacion1)
        var nota2 = findViewById<EditText>(R.id.idCalificacion2)
        var nota3 = findViewById<EditText>(R.id.idCalificacion3)
        var nota4 = findViewById<EditText>(R.id.idCalificacion4)
        var nota5 = findViewById<EditText>(R.id.idCalificacion5)
        var btnCalcular = findViewById<Button>(R.id.btnCalcular)
        var resultado = findViewById<TextView>(R.id.idPromedioFinal)

        btnCalcular.setOnClickListener {
            var estudiante = nombreEstudiante.text.toString()
            var calificacion1 = nota1.text.toString().toFloatOrNull()
            var calificacion2 = nota2.text.toString().toFloatOrNull()
            var calificacion3 = nota3.text.toString().toFloatOrNull()
            var calificacion4 = nota4.text.toString().toFloatOrNull()
            var calificacion5 = nota5.text.toString().toFloatOrNull()

            if (estudiante.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa el nombre del estudiante.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (calificacion1 == null) {
                Toast.makeText(this, "Por favor, ingresa la calificación 1.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (calificacion1 < 0) {
                Toast.makeText(this, "La calificación 1 debe ser al menos 0.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (calificacion1 > 10) {
                Toast.makeText(this, "La calificación 1 debe estar en el rango de 0 a 10.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (calificacion2 == null) {
                Toast.makeText(this, "Por favor, ingresa la calificación 2.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (calificacion2 < 0) {
                Toast.makeText(this, "La calificación 2 debe ser al menos 0.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (calificacion2 > 10) {
                Toast.makeText(this, "La calificación 2 debe estar en el rango de 0 a 10.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (calificacion3 == null) {
                Toast.makeText(this, "Por favor, ingresa la calificación 3.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (calificacion3 < 0) {
                Toast.makeText(this, "La calificación 3 debe ser al menos 0.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (calificacion3 > 10) {
                Toast.makeText(this, "La calificación 3 debe estar en el rango de 0 a 10.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (calificacion4 == null) {
                Toast.makeText(this, "Por favor, ingresa la calificación 4.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (calificacion4 < 0) {
                Toast.makeText(this, "La calificación 4 debe ser al menos 0.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (calificacion4 > 10) {
                Toast.makeText(this, "La calificación 4 debe estar en el rango de 0 a 10.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (calificacion5 == null) {
                Toast.makeText(this, "Por favor, ingresa la calificación 5.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (calificacion5 < 0) {
                Toast.makeText(this, "La calificación 5 debe ser al menos 0.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (calificacion5 > 10) {
                Toast.makeText(this, "La calificación 5 debe estar en el rango de 0 a 10.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            // Creamos la instancia a la clase CalcularPromedio
            var calculo = CalcularPromedio(calificacion1, calificacion2, calificacion3, calificacion4, calificacion5)
            var promedio = calculo.calcularPromedio()
            var estado = calculo.determinarEstado(promedio, estudiante)

            resultado.text = estado
        }
    }
}
