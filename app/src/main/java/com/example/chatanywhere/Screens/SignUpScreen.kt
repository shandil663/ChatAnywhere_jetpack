package com.example.chatanywhere.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.chatanywhere.Components.Buttons
import com.example.chatanywhere.Components.CheckBoxhere
import com.example.chatanywhere.Components.ClickableTextComp
import com.example.chatanywhere.Components.ClickableTextComp1
import com.example.chatanywhere.Components.Dividercomp
import com.example.chatanywhere.Components.HeadingTextComponent
import com.example.chatanywhere.Components.MyTextField
import com.example.chatanywhere.Components.NormalTextComponent
import com.example.chatanywhere.Components.PasswordTextField
import com.example.chatanywhere.R

@Composable
fun SignUp(onClick: (Name: String) -> Unit, function: () -> Unit) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
Column (modifier=Modifier.fillMaxSize()){
    NormalTextComponent(value = stringResource(id = R.string.weltext))
    HeadingTextComponent(value = stringResource(id = R.string.Askdetails), fontsize = 30, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(20.dp))
    MyTextField(labelval ="First name", painterResource = painterResource(id = R.drawable.user))
    MyTextField(labelval ="Last name", painterResource = painterResource(id = R.drawable.last) )
    MyTextField(labelval ="Email", painterResource = painterResource(id = R.drawable.email) )
    PasswordTextField(labelval ="Password", painterResource = painterResource(id = R.drawable.password) )
    CheckBoxhere("By continuing you accept our privacy policy and term of use",onClick)
    Spacer(modifier = Modifier.height(35.dp))
    Buttons(colorResource(id = R.color.purple_500),"SignUp")
    Spacer(modifier = Modifier.height(35.dp))
    Dividercomp()
    Spacer(modifier = Modifier.height(35.dp))
    ClickableTextComp1("hello",function)


}
    }
}

