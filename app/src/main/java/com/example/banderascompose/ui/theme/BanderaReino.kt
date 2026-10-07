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

@Composable
fun BanderaReinoUnidoConstraint(modifier: Modifier = Modifier) {
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
                height = Dimension.ratio("2:1")
            }
        ) {
            val azulUK = Color(0xFF00247D)
            val rojoUK = Color(0xFFCC0000)
            val blanco = Color(0xFFFFFFFF)

            val w = size.width
            val h = size.height
            drawRect(color = azulUK)
            val anchoDiagonalBlanca = h * 0.20f
            drawLine(
                color = blanco,
                start = Offset(0f, 0f),
                end = Offset(w, h),
                strokeWidth = anchoDiagonalBlanca
            )
            drawLine(
                color = blanco,
                start = Offset(0f, h),
                end = Offset(w, 0f),
                strokeWidth = anchoDiagonalBlanca
            )
            val anchoDiagonalRoja = h * 0.067f

            val pathRojaTL = Path().apply {
                moveTo(0f, 0f)
                lineTo(w / 2f, h / 2f)
            }
            drawPath(path = pathRojaTL, color = rojoUK, style = Stroke(width = anchoDiagonalRoja))

            val pathRojaTR = Path().apply {
                moveTo(w, 0f)
                lineTo(w / 2f, h / 2f)
            }
            drawPath(path = pathRojaTR, color = rojoUK, style = Stroke(width = anchoDiagonalRoja))

            val pathRojaBL = Path().apply {
                moveTo(0f, h)
                lineTo(w / 2f, h / 2f)
            }
            drawPath(path = pathRojaBL, color = rojoUK, style = Stroke(width = anchoDiagonalRoja))

            val pathRojaBR = Path().apply {
                moveTo(w, h)
                lineTo(w / 2f, h / 2f)
            }
            drawPath(path = pathRojaBR, color = rojoUK, style = Stroke(width = anchoDiagonalRoja))
            val anchoCruzBlanca = h * 0.333f
            drawRect(
                color = blanco,
                topLeft = Offset((w - anchoCruzBlanca) / 2f, 0f),
                size = Size(anchoCruzBlanca, h)
            )
            drawRect(
                color = blanco,
                topLeft = Offset(0f, (h - anchoCruzBlanca) / 2f),
                size = Size(w, anchoCruzBlanca)
            )
            val anchoCruzRoja = h * 0.20f
            drawRect(
                color = rojoUK,
                topLeft = Offset((w - anchoCruzRoja) / 2f, 0f),
                size = Size(anchoCruzRoja, h)
            )
            drawRect(
                color = rojoUK,
                topLeft = Offset(0f, (h - anchoCruzRoja) / 2f),
                size = Size(w, anchoCruzRoja)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaReinoUnidoConstraintPreview() {
    Surface {
        BanderaReinoUnidoConstraint()
    }
}