package com.example.promedionotas01

class CalcularPromedio(
    var calificacion1: Float,
    var calificacion2: Float,
    var calificacion3: Float,
    var calificacion4: Float,
    var calificacion5: Float
) {

    fun calcularPromedio(): Float {

        val promedio = (calificacion1 * 0.15 + calificacion2 * 0.15 + calificacion3 * 0.20 + calificacion4 * 0.25 + calificacion5 * 0.25)
        return promedio.toFloat().toFloat()
    }

    fun determinarEstado(promedio: Float, estudiante: String): String {
        if (promedio >= 6.0) {
            return "El Estudiante $estudiante aprobó con un promedio final de $promedio"
        } else {
            return "El Estudiante $estudiante reprobó con un promedio final de $promedio"
        }
    }
}
