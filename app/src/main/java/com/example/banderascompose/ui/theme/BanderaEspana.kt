package com.example.banderascompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.banderascompose.R

@Composable
fun BanderaEspana(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(RojoEspana)
        )
        Box(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .background(AmarilloEspana),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.escudo_espana),
                contentDescription = "Escudo de España",
                modifier = Modifier.size(150.dp)
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(RojoEspana)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BanderaEspanaPreview() {
    BanderasComposeTheme {
        BanderaEspana()
    }
}