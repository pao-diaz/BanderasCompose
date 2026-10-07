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
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BanderaCubaConstraint(modifier: Modifier = Modifier) {
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
            val azulCuba = Color(0xFF002E6E)
            val blanco = Color(0xFFFFFFFF)
            val rojoCuba = Color(0xFFCB1428)

            val altoFranja = size.height / 5f

            drawRect(color = azulCuba, topLeft = Offset(0f, 0f), size = Size(size.width, altoFranja))
            drawRect(color = blanco, topLeft = Offset(0f, altoFranja), size = Size(size.width, altoFranja))
            drawRect(color = azulCuba, topLeft = Offset(0f, altoFranja * 2f), size = Size(size.width, altoFranja))
            drawRect(color = blanco, topLeft = Offset(0f, altoFranja * 3f), size = Size(size.width, altoFranja))
            drawRect(color = azulCuba, topLeft = Offset(0f, altoFranja * 4f), size = Size(size.width, altoFranja))

            val baseTriangulo = size.height * (kotlin.math.sqrt(3f) / 2f)
            val trianguloPath = Path().apply {
                moveTo(0f, 0f)
                lineTo(baseTriangulo, size.height / 2f)
                lineTo(0f, size.height)
                close()
            }
            drawPath(path = trianguloPath, color = rojoCuba)

            val centroEstrellaX = baseTriangulo / 3f
            val centroEstrellaY = size.height / 2f
            val radioExterior = size.height * 0.15f
            val radioInterior = radioExterior * 0.382f

            val estrellaPath = crearEstrellaCubaConstraintPath(
                cx = centroEstrellaX,
                cy = centroEstrellaY,
                puntas = 5,
                radioExterior = radioExterior,
                radioInterior = radioInterior
            )
            drawPath(path = estrellaPath, color = blanco)
        }
    }
}

fun crearEstrellaCubaConstraintPath(
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
fun BanderaCubaConstraintPreview() {
    Surface {
        BanderaCubaConstraint()
    }
}