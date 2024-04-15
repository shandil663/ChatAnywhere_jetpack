package com.example.chatanywhere.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.chatanywhere.Components.Buttons
import com.example.chatanywhere.Components.ClickableTextComp2
import com.example.chatanywhere.Components.Dividercomp
import com.example.chatanywhere.Components.HeadingTextComponent
import com.example.chatanywhere.Components.MyTextField
import com.example.chatanywhere.Components.NormalTextComponent
import com.example.chatanywhere.Components.PasswordTextField
import com.example.chatanywhere.Components.Wholetextclickable
import com.example.chatanywhere.R

@Composable

fun LoginScreen(onclick: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column {
            NormalTextComponent(value = "Hello,")

            HeadingTextComponent(value = "Welcome Back")
            Spacer(modifier = Modifier.height(28.dp))

            MyTextField(
                labelval = "Email",
                painterResource = painterResource(id = R.drawable.email),

                onTextSelected = {

                }
            )
            PasswordTextField(
                labelval = "Password",
                painterResource = painterResource(id = R.drawable.password)
                ,
                onTextSelected = {

                }
            )
            Spacer(modifier = Modifier.height(28.dp))
            Wholetextclickable(onclick)

            Spacer(modifier = Modifier.height(100.dp))

            Buttons(color = colorResource(id = R.color.purple_500), text = "Login", onButtonClicked = {

            })
            Spacer(modifier = Modifier.height(30.dp))
            Dividercomp()
            Spacer(modifier = Modifier.height(30.dp))

            ClickableTextComp2(value = "",onclick)

        }


    }
}