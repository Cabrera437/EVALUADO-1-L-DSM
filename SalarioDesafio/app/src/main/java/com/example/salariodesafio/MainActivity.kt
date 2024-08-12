package com.example.salariodesafio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa la clase Calculos
        val calculos = Calculos()

        // Obtiene referencias a los elementos de la interfaz
        val etNombre: EditText = findViewById(R.id.etNombre)
        val etSalarioBase: EditText = findViewById(R.id.etSalarioBase)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val btnLimpiar: Button = findViewById(R.id.btnLimpiar)
        val tvResultados: TextView = findViewById(R.id.tvResultados)

        // Configura el botón para calcular los descuentos
        btnCalcular.setOnClickListener {
            val nombre = etNombre.text.toString()
            val salarioBaseStr = etSalarioBase.text.toString()

            if (nombre.isNotBlank() && salarioBaseStr.isNotBlank()) {
                val salarioBase = salarioBaseStr.toDouble()

                // Realiza los cálculos
                val renta = calculos.calcularRenta(salarioBase)
                val afp = calculos.calcularAFP(salarioBase)
                val isss = calculos.calcularISSS(salarioBase)
                val salarioNeto = calculos.calcularSalarioNeto(salarioBase)

                // Muestra los resultados en el TextView
                val resultados = """
                    Nombre: $nombre
                    Salario Base: $salarioBase
                    Descuento de Renta: $renta
                    Descuento de AFP: $afp
                    Descuento de ISSS: $isss
                    Salario Neto: $salarioNeto
                """.trimIndent()

                tvResultados.text = resultados
            } else {
                // Muestra un mensaje de error si los campos están vacíos
                tvResultados.text = "Por favor, complete todos los campos."
            }
        }

        // Configura el botón para limpiar los campos
        btnLimpiar.setOnClickListener {
            // Limpia los campos de entrada y el TextView de resultados
            etNombre.text.clear()
            etSalarioBase.text.clear()
            tvResultados.text = "Resultados"
        }
    }
}
