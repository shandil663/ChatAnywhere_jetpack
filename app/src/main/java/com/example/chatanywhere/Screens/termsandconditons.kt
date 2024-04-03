package com.example.chatanywhere.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chatanywhere.Components.HeadingTextComponent

@Composable
fun term(nm: String?) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(20.dp)) {
HeadingTextComponent(value = "Welcome to terms and conditions $nm")
    }
}