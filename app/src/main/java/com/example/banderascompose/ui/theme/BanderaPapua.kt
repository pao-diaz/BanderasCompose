package com.example.banderascompose.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BanderaPapuaNuevaGuineaConstraint(modifier: Modifier = Modifier) {
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
                height = Dimension.ratio("4:3")
            }
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
                Triple(0.25f * w, 0.28f * h, 0.05f * h),
                Triple(0.15f * w, 0.48f * h, 0.05f * h),
                Triple(0.25f * w, 0.72f * h, 0.05f * h),
                Triple(0.35f * w, 0.52f * h, 0.05f * h),
                Triple(0.29f * w, 0.58f * h, 0.03f * h)
            )

            estrellasPos.forEach { (cx, cy, r) ->
                val estrellaPath = crearEstrellaPNGConstraintPath(cx, cy, 5, r, r * 0.382f)
                drawPath(path = estrellaPath, color = blanco)
            }

            val avePath = Path().apply {
                moveTo(w * 0.62f, h * 0.48f)
                lineTo(w * 0.72f, h * 0.32f)
                lineTo(w * 0.85f, h * 0.20f)
                quadraticTo(w * 0.76f, h * 0.36f, w * 0.88f, h * 0.38f)
                quadraticTo(w * 0.74f, h * 0.46f, w * 0.82f, h * 0.58f)
                quadraticTo(w * 0.68f, h * 0.52f, w * 0.62f, h * 0.48f)
                close()
            }
            drawPath(path = avePath, color = amarillo)
        }
    }
}

fun crearEstrellaPNGConstraintPath(
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
fun BanderaPapuaNuevaGuineaConstraintPreview() {
    Surface {
        BanderaPapuaNuevaGuineaConstraint()
    }
}