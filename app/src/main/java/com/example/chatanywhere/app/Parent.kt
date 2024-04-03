package com.example.chatanywhere.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.chatanywhere.Screens.SignUp

@Composable

fun loginpage(){
    Surface(
        modifier=Modifier.fillMaxSize(),
        color= Color.White
    ){

        SignUp()
    }

}