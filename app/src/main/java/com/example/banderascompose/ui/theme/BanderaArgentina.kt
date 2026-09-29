package com.example.banderascompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderascompose.R

@Composable
fun BanderaArgentinaC(modifier: Modifier) {

    ConstraintLayout(
        modifier = modifier
    ) {

        val (azulSup, blanco, azulInf) = createRefs()

        val lineaSup = createGuidelineFromBottom(0.660f)
        val lineaInf = createGuidelineFromBottom(0.33f)

        Box(
            modifier = Modifier
                .background(AzulArgentina)
                .constrainAs(azulSup) {

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
                .background(Blanco)
                .constrainAs(blanco) {

                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(lineaSup)
                    bottom.linkTo(lineaInf)

                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                },
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.escudo_argentina),
                contentDescription = "Escudo nacional",
                modifier = Modifier.size(100.dp)
            )
        }

        Box(
            modifier = Modifier
                .background(AzulArgentina)
                .constrainAs(azulInf) {

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
fun BanderaArgentinaCPreview() {
    BanderaArgentinaC(
        modifier = Modifier.fillMaxSize()
    )
}