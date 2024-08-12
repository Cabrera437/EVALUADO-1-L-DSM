package com.example.salariodesafio

class Calculos {
    var AFP = 0.0725
    var ISSS = 0.03

    // Método para calcular la Renta basada en tramos
    fun calcularRenta(salarioBase: Double): Double {
        return when {
            salarioBase <= 472.00 -> 0.0
            salarioBase <= 895.24 -> (salarioBase - 472.00) * 0.10 + 17.67
            salarioBase <= 2038.10 -> (salarioBase - 895.24) * 0.20 + 60.00
            else -> (salarioBase - 2038.10) * 0.30 + 288.57
        }
    }

    // Método para calcular el descuento de AFP
    fun calcularAFP(salarioBase: Double): Double {
        return salarioBase * AFP
    }

    // Método para calcular el descuento de ISSS
    fun calcularISSS(salarioBase: Double): Double {
        return salarioBase * ISSS
    }

    // Método para calcular el salario neto
    fun calcularSalarioNeto(salarioBase: Double): Double {
        val renta = calcularRenta(salarioBase)
        val afp = calcularAFP(salarioBase)
        val isss = calcularISSS(salarioBase)
        return salarioBase - renta - afp - isss
    }

}