package com.example.banderascompose.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BanderaIsrael(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {
        val (canvas) = createRefs()

        Canvas(
            modifier = Modifier.constrainAs(canvas) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.ratio("11:8")
            }
        ) {
            val azulIsrael = Color(0xFF0038B8)
            val blanco = Color(0xFFFFFFFF)

            drawRect(color = blanco)

            val grosorFranja = size.height * 0.15f
            drawRect(
                color = azulIsrael,
                topLeft = Offset(0f, grosorFranja),
                size = Size(size.width, grosorFranja)
            )
            drawRect(
                color = azulIsrael,
                topLeft = Offset(0f, size.height - (grosorFranja * 2f)),
                size = Size(size.width, grosorFranja)
            )

            val centroX = size.width / 2f
            val centroY = size.height / 2f
            val radio = size.height * 0.20f
            val grosorLinea = size.height * 0.03f

            val triArriba = crearTrianguloIsraelPath(centroX, centroY, radio, -90f)
            val triAbajo = crearTrianguloIsraelPath(centroX, centroY, radio, 90f)

            drawPath(
                path = triArriba,
                color = azulIsrael,
                style = Stroke(width = grosorLinea)
            )
            drawPath(
                path = triAbajo,
                color = azulIsrael,
                style = Stroke(width = grosorLinea)
            )
        }
    }
}

fun crearTrianguloIsraelPath(cx: Float, cy: Float, r: Float, anguloRotacionDeg: Float): Path {
    val path = Path()
    for (i in 0..2) {
        val anguloRad = Math.toRadians((anguloRotacionDeg + (i * 120)).toDouble())
        val x = cx + r * cos(anguloRad).toFloat()
        val y = cy + r * sin(anguloRad).toFloat()

        if (i == 0) {
            path.moveTo(x, y)
        } else {
            path.lineTo(x, y)
        }
    }
    path.close()
    return path
}

@Preview(showBackground = true)
@Composable
fun BanderaIsraelPreview() {
    Surface {
        BanderaIsrael()
    }
}