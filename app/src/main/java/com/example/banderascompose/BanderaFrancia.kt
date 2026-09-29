package com.example.banderascompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderascompose.ui.theme.AzulFrancia
import com.example.banderascompose.ui.theme.BanderasComposeTheme
import com.example.banderascompose.ui.theme.RojoFrancia

@Composable
fun BanderaFranciaC(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (azul, blanco, rojo) = createRefs()
        val lineguia1 = createGuidelineFromStart(0.333f)
        val lineguia2 = createGuidelineFromStart(0.666f)

        Box(
            modifier = Modifier
                .background(AzulFrancia)
                .constrainAs(azul) {
                    start.linkTo(parent.start)
                    end.linkTo(lineguia1)
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
                    start.linkTo(lineguia1)
                    end.linkTo(lineguia2)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                },
            contentAlignment = Alignment.Center
        ) {}

        Box(
            modifier = Modifier
                .background(RojoFrancia)
                .constrainAs(rojo) {
                    start.linkTo(lineguia2)
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
fun BanderaPreview() {
    BanderasComposeTheme {
        BanderaFranciaC()
    }
}