package com.example.banderascompose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HelloKittyPixelArt() {

    val negro = Color(0xFF1B1B1B)
    val rosa = Color(0xFFF06292)
    val amarillo = Color(0xFFFFD54F)
    val blanco = Color.White
    val grisGrid = Color(0xFFCCCCCC)

    val pixelMap = arrayOf(

        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,1,0,0,1,1,1,0,0,0,1,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,1,2,2,2,1,1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,1,0,1,1,1,1,2,2,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,1,2,2,2,1,1,1,2,1,2,2,2,1,0,0,0,0,0,0,1,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,1,2,2,2,2,2,1,2,2,1,2,2,2,1,0,0,0,0,0,0,0,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,1,2,2,2,2,2,1,2,2,1,1,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,1,2,2,2,2,2,2,1,1,1,0,0,0,0,4,4,4,4,4,4,4,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,1,2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,1,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,1,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,4,4,4,1,1,1,0,0,0,0,0,0,1,1,1,0,0,1,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,1,1,1,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,1,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,1,1,1,0,0,1,1,1,0,0,3,3,0,0,1,1,1,0,0,1,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,3,3,3,3,0,0,0,0,0,0,1,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,3,3,3,3,0,0,0,0,0,0,1,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,3,3,0,0,0,0,0,0,1,1,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,1,1,0,2,2,2,2,2,2,2,2,2,0,1,1,1,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,1,1,1,2,2,2,2,2,2,2,2,2,1,1,1,1,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,1,1,1,1,1,2,2,2,2,2,2,2,1,1,1,1,1,1,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,0,0,0,1,1,2,2,2,2,2,2,1,1,0,0,0,1,1,0,0,0,1,0),//AQUI ES DEL LADO DEL PIE
        intArrayOf(0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,2,2,2,2,1,1,0,0,0,0,0,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,2,2,2,2,1,1,0,0,0,0,0,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,2,2,2,2,1,1,0,0,0,0,0,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,2,2,2,2,1,1,0,0,0,0,1,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,1,1,0,0,0,1,1,2,2,2,2,1,1,0,0,0,1,1,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0),

        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            for (row in pixelMap) {
                Row {
                    for (pixel in row) {

                        val colorToUse = when (pixel) {
                            1 -> negro
                            2 -> rosa
                            3 -> amarillo
                            4 -> blanco
                            else -> Color.Transparent
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .background(colorToUse)
                                .border(0.2.dp, grisGrid)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KittyPreview() {
    BanderasComposeTheme {
        HelloKittyPixelArt()
    }
}