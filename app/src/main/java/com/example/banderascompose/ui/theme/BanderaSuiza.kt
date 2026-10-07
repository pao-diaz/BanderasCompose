package com.example.banderascompose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun BanderaSuiza(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD52B1E))
    ) {
        val (barraVertical, barraHorizontal) = createRefs()

        Box(
            modifier = Modifier
                .background(Color.White)
                .constrainAs(barraVertical) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.percent(0.20f)
                    height = Dimension.percent(0.62f)
                }
        )

        Box(
            modifier = Modifier
                .background(Color.White)
                .constrainAs(barraHorizontal) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.percent(0.62f)
                    height = Dimension.percent(0.20f)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSuizaPreview() {
    Surface { BanderaSuiza() }
}