package com.example.banderascompose.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.banderascompose.R
import com.example.banderascompose.ui.theme.BanderaPreview

@Composable
fun BanderaTurquia(modifier: Modifier = Modifier)
{
    val colorRojo = colorResource(id = R.color.rojo_turquia)
    Box(modifier = Modifier
        .background(colorRojo)
    )
    {
        Canvas(modifier = modifier.fillMaxSize())
        {
            drawRect(color = colorRojo)
            val cy = size.height / 2f
            val radio = size.height * 0.30f
            drawCircle(
                color = Color.White, radius = radio,
                center = Offset(size.width * 0.38f, cy)
            )
            drawCircle(
                color = colorRojo, radius = size.height * 0.24f,
                center = Offset(size.width * 0.38f + size.height * 0.09f, cy)
            )
        }

        Image(
            painter = painterResource(R.drawable.star_24px),
            contentDescription = "Estrella",
            modifier = Modifier
                .size(120.dp).rotate(45f)
                .align(BiasAlignment(horizontalBias = 0.1f, verticalBias = 0f))
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BanderaPrevi() {
    BanderasComposeTheme(){
        BanderaTurquia()
    }
}