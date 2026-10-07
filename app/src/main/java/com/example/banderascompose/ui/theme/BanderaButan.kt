package com.example.banderascompose.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun BanderaBotanConstraint(modifier: Modifier = Modifier) {
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
                height = Dimension.ratio("3:2")
            }
        ) {
            val amarillo = Color(0xFFFFCC00)
            val naranja = Color(0xFFFF4E00)
            val blanco = Color(0xFFFFFFFF)

            val w = size.width
            val h = size.height

            val pathAmarillo = Path().apply {
                moveTo(0f, 0f)
                lineTo(w, 0f)
                lineTo(0f, h)
                close()
            }
            drawPath(path = pathAmarillo, color = amarillo)

            val pathNaranja = Path().apply {
                moveTo(w, 0f)
                lineTo(w, h)
                lineTo(0f, h)
                close()
            }
            drawPath(path = pathNaranja, color = naranja)

            val dragonZigzag = Path().apply {
                moveTo(w * 0.25f, h * 0.62f)
                lineTo(w * 0.30f, h * 0.48f)
                lineTo(w * 0.38f, h * 0.55f)
                lineTo(w * 0.46f, h * 0.42f)
                lineTo(w * 0.54f, h * 0.52f)
                lineTo(w * 0.62f, h * 0.40f)
                lineTo(w * 0.70f, h * 0.50f)
                lineTo(w * 0.75f, h * 0.38f)
                lineTo(w * 0.72f, h * 0.45f)
                lineTo(w * 0.64f, h * 0.35f)
                lineTo(w * 0.56f, h * 0.46f)
                lineTo(w * 0.48f, h * 0.36f)
                lineTo(w * 0.40f, h * 0.48f)
                lineTo(w * 0.32f, h * 0.40f)
                lineTo(w * 0.25f, h * 0.56f)
                close()
            }
            drawPath(path = dragonZigzag, color = blanco)

            val centrosEstrellas = listOf(
                Offset(w * 0.34f, h * 0.51f),
                Offset(w * 0.44f, h * 0.46f),
                Offset(w * 0.59f, h * 0.44f),
                Offset(w * 0.68f, h * 0.41f)
            )

            centrosEstrellas.forEach { centro ->
                val estrellaPath = Path().apply {
                    val radios = 0.035f * h
                    for (i in 0 until 5) {
                        val anguloExt = Math.toRadians((i * 72 - 90).toDouble())
                        val anguloInt = Math.toRadians((i * 72 - 54).toDouble())
                        val xExt = centro.x + (radios * kotlin.math.cos(anguloExt)).toFloat()
                        val yExt = centro.y + (radios * kotlin.math.sin(anguloExt)).toFloat()
                        val xInt = centro.x + (radios * 0.45f * kotlin.math.cos(anguloInt)).toFloat()
                        val yInt = centro.y + (radios * 0.45f * kotlin.math.sin(anguloInt)).toFloat()

                        if (i == 0) moveTo(xExt, yExt) else lineTo(xExt, yExt)
                        lineTo(xInt, yInt)
                    }
                    close()
                }
                drawPath(path = estrellaPath, color = amarillo)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaBotanConstraintPreview() {
    Surface {
        BanderaBotanConstraint()
    }
}