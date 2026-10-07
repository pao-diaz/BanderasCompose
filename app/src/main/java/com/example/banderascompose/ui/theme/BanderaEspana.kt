package com.example.banderascompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderascompose.R

@Composable
fun BanderaEspanaC(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (rojoSup, amarillo, rojoInf, escudo) = createRefs()

        val lineaSup = createGuidelineFromTop(0.25f)
        val lineaInf = createGuidelineFromTop(0.75f)
        val lineaEscudo = createGuidelineFromStart(0.33f)

        Box(
            modifier = Modifier
                .background(RojoEspana)
                .constrainAs(rojoSup) {
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
                .background(AmarilloEspana)
                .constrainAs(amarillo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(lineaSup)
                    bottom.linkTo(lineaInf)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )

        Image(
            painter = painterResource(id = R.drawable.escudo_espana),
            contentDescription = "Escudo nacional",
            modifier = Modifier
                .size(140.dp)
                .constrainAs(escudo) {
                    start.linkTo(lineaEscudo)
                    end.linkTo(lineaEscudo)
                    top.linkTo(lineaSup)
                    bottom.linkTo(lineaInf)
                }
        )

        Box(
            modifier = Modifier
                .background(RojoEspana)
                .constrainAs(rojoInf) {
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
fun BanderaEspanaCPreview() {
    BanderasComposeTheme {
        BanderaEspanaC()
    }
}