package com.example.banderascompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BanderaBase(modifier: Modifier = Modifier) {
}

@Preview(showBackground = true)
@Composable
fun BanderaBasePreview() {
    Surface {
        BanderaBase(modifier = Modifier.fillMaxSize())
    }
}