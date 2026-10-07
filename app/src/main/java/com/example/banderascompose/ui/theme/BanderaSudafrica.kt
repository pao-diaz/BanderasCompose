package com.example.banderascompose.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BanderaSudafrica(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier.aspectRatio(3f / 2f)
    ) {
        val azul = Color(0xFF001B94)
        val verde = Color(0xFF007A3D)
        val negro = Color(0xFF000000)
        val dorado = Color(0xFFFFB800)
        val blanco = Color(0xFFFFFFFF)

        val w = size.width
        val h = size.height


        drawRect(color = azul, topLeft = Offset(0f, 0f), size = Size(w, h / 2f))
        drawRect(color = dorado, topLeft = Offset(0f, h / 2f), size = Size(w, h / 2f))

        val pathNegro = Path().apply {
            moveTo(0f, 0f)
            lineTo(w * 0.38f, h * 0.5f)
            lineTo(0f, h)
            close()
        }
        drawPath(path = pathNegro, color = negro)

        val pathBlanco = Path().apply { moveTo(0f, 0f)
            lineTo(w * 0.10f, 0f)
            lineTo(w * 0.44f, h * 0.44f)
            lineTo(w, h * 0.15f)
            lineTo(w, h * 0.28f)
            lineTo(w * 0.52f, h * 0.5f)
            lineTo(w, h * 0.72f)
            lineTo(w, h * 0.85f)
            lineTo(w * 0.44f, h * 0.56f)
            lineTo(w * 0.10f, h)
            lineTo(0f, h)
            close()
        }
        drawPath(path = pathBlanco, color = blanco)

        // 4. "Y" Verde principal (Estructura central idéntica a la imagen)[cite: 2]
        val pathVerde = Path().apply {
            moveTo(0f, 0f)
            lineTo(w * 0.06f, 0f)
            lineTo(w * 0.42f, h * 0.46f)
            lineTo(w, h * 0.19f)
            lineTo(w, h * 0.81f)
            lineTo(w * 0.42f, h * 0.54f)
            lineTo(w * 0.06f, h)
            lineTo(0f, h)
            lineTo(w * 0.34f, h * 0.5f)
            close()
        }
        drawPath(path = pathVerde, color = verde)
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSudafricaPreview() {
    Surface {
        BanderaSudafrica(modifier = Modifier.fillMaxWidth())
    }
}