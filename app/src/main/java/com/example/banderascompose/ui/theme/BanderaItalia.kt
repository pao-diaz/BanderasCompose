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

@Composable
fun BanderaItaliaC(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (verde, blanco, rojo) = createRefs()
        val lineaIzq = createGuidelineFromStart(0.333f)
        val lineaDer = createGuidelineFromStart(0.666f)

        Box(
            modifier = Modifier
                .background(VerdeItalia)
                .constrainAs(verde) {
                    start.linkTo(parent.start)
                    end.linkTo(lineaIzq)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(Color.White)
                .constrainAs(blanco) {
                    start.linkTo(lineaIzq)
                    end.linkTo(lineaDer)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(RojoItalia)
                .constrainAs(rojo) {
                    start.linkTo(lineaDer)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BanderaItaliaPreview() {
    BanderasComposeTheme {
        BanderaItaliaC()
    }
}