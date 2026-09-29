package com.example.banderascompose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BanderaJapon(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Blanco)
    ) {

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .size(200.dp)
                .clip(CircleShape)
                .background(Rojo)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BanderaJaponPreview() {
    BanderaJapon()
}