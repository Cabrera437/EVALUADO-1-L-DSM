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
            var Estudiante = nombreEstudiante.text.toString()
            var calificacion1 = nota1.text.toString().toFloatOrNull()
            var calificacion2 = nota2.text.toString().toFloatOrNull()
            var calificacion3 = nota3.text.toString().toFloatOrNull()
            var calificacion4 = nota4.text.toString().toFloatOrNull()
            var calificacion5 = nota5.text.toString().toFloatOrNull()

            if (Estudiante.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa el nombre del estudiante.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (calificacion1 == null) {
                Toast.makeText(this, "Por favor, ingresa la calificación 1.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (calificacion1 < 0) {
                Toast.makeText(this, "La calificación 1 debe ser al menos 0.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (calificacion1 > 10) {
                Toast.makeText(this, "La calificación 1 no puede ser mayor a 10.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (calificacion2 == null) {
                Toast.makeText(this, "Por favor, ingresa la calificación 2.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (calificacion2 < 0) {
                Toast.makeText(this, "La calificación 2 debe ser al menos 0.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (calificacion2 > 10) {
                Toast.makeText(this, "La calificación 2 no puede ser mayor a 10.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (calificacion3 == null) {
                Toast.makeText(this, "Por favor, ingresa la calificación 3.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (calificacion3 < 0) {
                Toast.makeText(this, "La calificación 3 debe ser al menos 0.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (calificacion3 > 10) {
                Toast.makeText(this, "La calificación 3 no puede ser mayor a 10.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (calificacion4 == null) {
                Toast.makeText(this, "Por favor, ingresa la calificación 4.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (calificacion4 < 0) {
                Toast.makeText(this, "La calificación 4 debe ser al menos 0.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (calificacion4 > 10) {
                Toast.makeText(this, "La calificación 4 no puede ser mayor a 10.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (calificacion5 == null) {
                Toast.makeText(this, "Por favor, ingresa la calificación 5.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (calificacion5 < 0) {
                Toast.makeText(this, "La calificación 5 debe ser al menos 0.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (calificacion5 > 10) {
                Toast.makeText(this, "La calificación 5 no puede ser mayor a 10.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var promedio = (calificacion1 * 0.15) + (calificacion2 * 0.15) + (calificacion3 * 0.20) + (calificacion4 * 0.25) + (calificacion5 * 0.25)

            if (promedio >= 6.0) {
                resultado.text = "El Estudiante $Estudiante  aprobó  con un promedio final de $promedio"
            } else {
                resultado.text = "El Estudiante $Estudiante  reprobó con un promedio final de $promedio"
            }
        }
    }
}
