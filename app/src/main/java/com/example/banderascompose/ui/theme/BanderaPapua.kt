package com.example.banderascompose.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BanderaPapuaNuevaGuinea(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier.aspectRatio(4f / 3f)
    ) {
        val rojo = Color(0xFFCE1126)
        val negro = Color(0xFF000000)
        val amarillo = Color(0xFFFCD116)
        val blanco = Color(0xFFFFFFFF)

        val w = size.width
        val h = size.height

        val pathRojo = Path().apply {
            moveTo(0f, 0f)
            lineTo(w, 0f)
            lineTo(w, h)
            close()
        }
        drawPath(path = pathRojo, color = rojo)

        val pathNegro = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f, h)
            lineTo(w, h)
            close()
        }
        drawPath(path = pathNegro, color = negro)

        val estrellasPos = listOf(
            Triple(0.20f * w, 0.35f * h, 0.045f * h),
            Triple(0.12f * w, 0.55f * h, 0.045f * h),
            Triple(0.28f * w, 0.60f * h, 0.045f * h),
            Triple(0.20f * w, 0.82f * h, 0.045f * h),
            Triple(0.23f * w, 0.67f * h, 0.028f * h)
        )

        estrellasPos.forEach { (cx, cy, r) ->
            val estrellaPath = crearEstrellaPNGPath(cx, cy, 5, r, r * 0.382f)
            drawPath(path = estrellaPath, color = blanco)
        }

        val avePath = Path().apply {
            val centroX = w * 0.72f
            val centroY = h * 0.42f

            moveTo(centroX - w * 0.12f, centroY + h * 0.08f)
            quadraticTo(centroX - w * 0.02f, centroY, centroX + w * 0.14f, centroY - h * 0.22f)
            quadraticTo(centroX + w * 0.02f, centroY - h * 0.02f, centroX + w * 0.16f, centroY - h * 0.05f)
            quadraticTo(centroX + w * 0.01f, centroY + h * 0.08f, centroX + w * 0.10f, centroY + h * 0.16f)
            quadraticTo(centroX - w * 0.05f, centroY + h * 0.12f, centroX - w * 0.12f, centroY + h * 0.08f)
            close()
        }
        drawPath(path = avePath, color = amarillo)
    }
}

fun crearEstrellaPNGPath(
    cx: Float,
    cy: Float,
    puntas: Int,
    radioExterior: Float,
    radioInterior: Float
): Path {
    val path = Path()
    val totalPuntos = puntas * 2
    val pasoAngulo = PI * 2 / totalPuntos
    val anguloInicialRad = Math.toRadians(-90.0)

    for (i in 0 until totalPuntos) {
        val r = if (i % 2 == 0) radioExterior else radioInterior
        val angulo = anguloInicialRad + i * pasoAngulo
        val x = cx + r * cos(angulo).toFloat()
        val y = cy + r * sin(angulo).toFloat()

        if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
    }
    path.close()
    return path
}

@Preview(showBackground = true)
@Composable
fun BanderaPapuaNuevaGuineaPreview() {
    Surface {
        BanderaPapuaNuevaGuinea(modifier = Modifier.fillMaxWidth())
    }
}