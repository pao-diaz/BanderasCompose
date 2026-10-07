package com.example.banderascompose.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BanderaNepalConstraint(modifier: Modifier = Modifier) {
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
                height = Dimension.ratio("4:5")
            }
        ) {
            val azul = Color(0xFF002B66)
            val carmin = Color(0xFFDC143C)
            val blanco = Color(0xFFFFFFFF)

            val w = size.width
            val h = size.height

            val grosorBorde = w * 0.05f

            val pathCarmin = Path().apply {
                moveTo(0f, 0f)
                lineTo(w * 0.85f, h * 0.40f)
                lineTo(w * 0.10f, h * 0.40f)
                lineTo(w * 0.75f, h * 0.85f)
                lineTo(0f, h * 0.85f)
                close()
            }

            drawPath(path = pathCarmin, color = carmin)
            drawPath(
                path = pathCarmin,
                color = azul,
                style = Stroke(
                    width = grosorBorde,
                    cap = StrokeCap.Square,
                    join = StrokeJoin.Miter
                )
            )

            val centroLuna = Offset(w * 0.28f, h * 0.22f)
            val radioLuna = h * 0.07f

            val lunaPath = Path().apply {
                addOval(
                    Rect(
                        left = centroLuna.x - radioLuna,
                        top = centroLuna.y - radioLuna,
                        right = centroLuna.x + radioLuna,
                        bottom = centroLuna.y + radioLuna
                    )
                )
            }
            val corteLuna = Path().apply {
                val rCorte = radioLuna * 0.82f
                val cyCorte = centroLuna.y - radioLuna * 0.35f
                addOval(
                    Rect(
                        left = centroLuna.x - rCorte,
                        top = cyCorte - rCorte,
                        right = centroLuna.x + rCorte,
                        bottom = cyCorte + rCorte
                    )
                )
            }

            drawPath(
                path = Path().apply {
                    op(lunaPath, corteLuna, androidx.compose.ui.graphics.PathOperation.Difference)
                },
                color = blanco
            )

            val puntosLuna = listOf(
                Offset(centroLuna.x, centroLuna.y - radioLuna * 1.15f),
                Offset(centroLuna.x + radioLuna * 0.80f, centroLuna.y - radioLuna * 0.80f),
                Offset(centroLuna.x + radioLuna * 1.15f, centroLuna.y - radioLuna * 0.10f),
                Offset(centroLuna.x + radioLuna * 0.80f, centroLuna.y + radioLuna * 0.60f),
                Offset(centroLuna.x, centroLuna.y + radioLuna * 0.85f),
                Offset(centroLuna.x - radioLuna * 0.80f, centroLuna.y + radioLuna * 0.60f),
                Offset(centroLuna.x - radioLuna * 1.15f, centroLuna.y - radioLuna * 0.10f),
                Offset(centroLuna.x - radioLuna * 0.80f, centroLuna.y - radioLuna * 0.80f)
            )

            puntosLuna.forEach { punto ->
                drawCircle(color = blanco, radius = h * 0.012f, center = punto)
            }

            val centroSol = Offset(w * 0.28f, h * 0.62f)
            val rSolExt = h * 0.08f
            val rSolInt = rSolExt * 0.55f

            val solPath = Path().apply {
                for (i in 0 until 12) {
                    val aExt = Math.toRadians((i * 30 - 90).toDouble())
                    val aInt = Math.toRadians((i * 30 - 75).toDouble())
                    val xE = centroSol.x + (rSolExt * cos(aExt)).toFloat()
                    val yE = centroSol.y + (rSolExt * sin(aExt)).toFloat()
                    val xI = centroSol.x + (rSolInt * cos(aInt)).toFloat()
                    val yI = centroSol.y + (rSolInt * sin(aInt)).toFloat()
                    if (i == 0) moveTo(xE, yE) else lineTo(xE, yE)
                    lineTo(xI, yI)
                }
                close()
            }
            drawPath(path = solPath, color = blanco)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaNepalConstraintPreview() {
    Surface {
        BanderaNepalConstraint()
    }
}