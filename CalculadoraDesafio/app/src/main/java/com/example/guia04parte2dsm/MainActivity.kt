package com.example.guia04parte2dsm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var buttonAdd: Button
    private lateinit var buttonSubtract: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDivide: Button
    private lateinit var textViewResult: TextView

    // Instancia de la clase Calculator
    private val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSubtract = findViewById(R.id.buttonSubtract)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonDivide = findViewById(R.id.buttonDivide)
        textViewResult = findViewById(R.id.textViewResult)

        buttonAdd.setOnClickListener { calculate(Operation.ADD) }
        buttonSubtract.setOnClickListener { calculate(Operation.SUBTRACT) }
        buttonMultiply.setOnClickListener { calculate(Operation.MULTIPLY) }
        buttonDivide.setOnClickListener { calculate(Operation.DIVIDE) }
    }

    private fun calculate(operation: Operation) {
        val input1Text = input1.text.toString()
        val input2Text = input2.text.toString()

        if (input1Text.isEmpty() || input2Text.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa ambos números", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = input1Text.toDouble()
        val num2 = input2Text.toDouble()

        try {
            val result = when (operation) {
                Operation.ADD -> calculator.add(num1, num2)
                Operation.SUBTRACT -> calculator.subtract(num1, num2)
                Operation.MULTIPLY -> calculator.multiply(num1, num2)
                Operation.DIVIDE -> calculator.divide(num1, num2)
            }

            textViewResult.text = getString(R.string.result) + result.toString()
        } catch (e: IllegalArgumentException) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }


    enum class Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}

// Encapsula la lógica de las operaciones
class Calculator {
    fun add(num1: Double, num2: Double): Double = num1 + num2
    fun subtract(num1: Double, num2: Double): Double = num1 - num2
    fun multiply(num1: Double, num2: Double): Double = num1 * num2
    fun divide(num1: Double, num2: Double): Double {
        if (num2 == 0.0) {
            throw IllegalArgumentException("No se puede dividir por cero")
        }
        return num1 / num2
    }
}
