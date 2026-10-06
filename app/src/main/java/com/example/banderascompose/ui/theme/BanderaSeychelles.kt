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

@Composable
fun BanderaSeychelles(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier.aspectRatio(2f / 1f)
    ) {
        val azul = Color(0xFF003D88)
        val amarillo = Color(0xFFFCD116)
        val rojo = Color(0xFFD21034)
        val blanco = Color(0xFFFFFFFF)
        val verde = Color(0xFF007A3D)

        val w = size.width
        val h = size.height
        val origen = Offset(0f, h)

        val pathAzul = Path().apply {
            moveTo(origen.x, origen.y)
            lineTo(0f, 0f)
            lineTo(w / 3f, 0f)
            close()
        }
        drawPath(path = pathAzul, color = azul)

        val pathAmarillo = Path().apply {
            moveTo(origen.x, origen.y)
            lineTo(w / 3f, 0f)
            lineTo(w * (2f / 3f), 0f)
            close()
        }
        drawPath(path = pathAmarillo, color = amarillo)

        val pathRojo = Path().apply {
            moveTo(origen.x, origen.y)
            lineTo(w * (2f / 3f), 0f)
            lineTo(w, 0f)
            lineTo(w, h / 3f)
            close()
        }
        drawPath(path = pathRojo, color = rojo)

        val pathBlanco = Path().apply {
            moveTo(origen.x, origen.y)
            lineTo(w, h / 3f)
            lineTo(w, h * (2f / 3f))
            close()
        }
        drawPath(path = pathBlanco, color = blanco)

        val pathVerde = Path().apply {
            moveTo(origen.x, origen.y)
            lineTo(w, h * (2f / 3f))
            lineTo(w, h)
            close()
        }
        drawPath(path = pathVerde, color = verde)
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSeychellesPreview() {
    Surface {
        BanderaSeychelles(modifier = Modifier.fillMaxWidth())
    }
}