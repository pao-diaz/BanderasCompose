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
fun BanderaArgentina(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize()
    ) {

        // Franja azul superior
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(AzulArgentina)
        )

        // Franja blanca del centro
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Blanco),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.escudo_argentina),
                contentDescription = "Escudo nacional",
                modifier = Modifier.size(140.dp)
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(AzulArgentina)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BanderaArgentinaPreview() {
    BanderaArgentina()
}