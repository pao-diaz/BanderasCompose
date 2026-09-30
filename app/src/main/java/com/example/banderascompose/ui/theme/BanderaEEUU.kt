package com.example.banderascompose.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderascompose.R
import com.example.banderascompose.ui.theme.BanderaPreview


@Composable
fun C1(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            items(5) {
                Image(
                    painter = painterResource(id = R.drawable.star_24px),
                    contentDescription = "Estrella",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
fun C2(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            items(4) {
                Image(
                    painter = painterResource(id = R.drawable.star_24px),
                    contentDescription = "Estrella",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}


@Composable
fun BanderaEstadosUnidosC(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = Modifier.fillMaxSize())
    {
        val (franjas, cuadroAzul) = createRefs()
        val lineAzulAltura = createGuidelineFromTop(7f / 13f)
        val lineAzulAncho = createGuidelineFromStart(0.4f)

        Column(
            modifier = Modifier.constrainAs(franjas) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        ) {
            repeat(13) { index ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .background(
                            if (index % 2 == 0) colorResource(id = R.color.rojo_EUA) else Color.White
                        )
                )
            }
        }

        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.azul_EUA))
                .constrainAs(cuadroAzul) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(lineAzulAltura)     // Anclado a la guía del 53.8%
                    end.linkTo(lineAzulAncho)        // Anclado a la guía del 40%

                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                repeat(11) { index ->
                    if (index % 2 == 0)
                        C1(modifier = Modifier.weight(1f))
                    else
                        C2(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BanderaPrevie() {
    BanderasComposeTheme() {
        BanderaEstadosUnidosC()
    }
}

