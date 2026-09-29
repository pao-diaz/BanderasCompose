package com.example.banderascompose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

val AmarilloColombia = Color(0xFFFCD116)
val AzulColombia = Color(0xFF003893)
val RojoColombia = Color(0xFFCE1126)

@Composable
fun BanderaColombiaC(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (amarillo, azul, rojo) = createRefs()
        val lineaSup = createGuidelineFromBottom(0.5f)
        val lineaInf = createGuidelineFromBottom(0.25f)

        Box(
            modifier = Modifier
                .background(AmarilloColombia)
                .constrainAs(amarillo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(lineaSup)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(AzulColombia)
                .constrainAs(azul) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(lineaSup)
                    bottom.linkTo(lineaInf)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(RojoColombia)
                .constrainAs(rojo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(lineaInf)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BanderaPreview() {
    BanderaColombiaC(modifier = Modifier.fillMaxSize())
}