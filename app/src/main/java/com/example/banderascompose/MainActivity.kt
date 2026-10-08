package com.example.banderascompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.banderascompose.ui.theme.BanderasComposeTheme
import com.example.banderascompose.ui.theme.HelloKittyPixelArt

class MainActivity2: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanderasComposeTheme {
                HelloKittyPixelArt()
            }
        }
    }
}