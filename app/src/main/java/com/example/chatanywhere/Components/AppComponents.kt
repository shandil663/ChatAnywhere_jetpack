@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.chatanywhere.Components

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatanywhere.R

@Composable

fun NormalTextComponent(value: String) {
    Text(
        text = value, modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal

        ),
        color = Color.Black,
        textAlign = TextAlign.Center


    )


}

@Composable

fun HeadingTextComponent(
    value: String,
    fontsize: Int = 28,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = value, modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = fontsize.sp,
            fontWeight = fontWeight,
            fontStyle = FontStyle.Normal

        ),
        color = Color.Black,
        textAlign = TextAlign.Center


    )


}

@Composable

fun MyTextField(labelval: String, painterResource: Painter) {
    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = null,
                tint = colorResource(id = R.color.purple_500)
            )
        }, modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20),
        label = {
            Text(text = labelval)
        },
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = colorResource(id = R.color.purple_500),
            focusedBorderColor = colorResource(id = R.color.purple_500),
            focusedLabelColor = colorResource(id = R.color.purple_500),
            focusedContainerColor = colorResource(id = R.color.bgforedittext),
            unfocusedContainerColor = colorResource(id = R.color.bgforedittext)
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = { textValue.value = it }
    )
}

@Composable
fun PasswordTextField(labelval: String, painterResource: Painter) {
    val password = remember {
        mutableStateOf("")
    }

    val passwordvisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(

        trailingIcon = {
            val iconimage = if (passwordvisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            var description = if (passwordvisible.value) {
                "Hide password"
            } else {
                "Show password"
            }

            IconButton(onClick = { passwordvisible.value = !passwordvisible.value }) {
                Icon(imageVector = iconimage, contentDescription = description)
            }

        },

        visualTransformation = if (passwordvisible.value)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = null,
                tint = colorResource(id = R.color.purple_500)
            )
        }, modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20),
        label = {
            Text(text = labelval)
        },
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = colorResource(id = R.color.purple_500),
            focusedBorderColor = colorResource(id = R.color.purple_500),
            focusedLabelColor = colorResource(id = R.color.purple_500),
            focusedContainerColor = colorResource(id = R.color.bgforedittext),
            unfocusedContainerColor = colorResource(id = R.color.bgforedittext)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password.value,
        onValueChange = { password.value = it }
    )
}

@Composable
fun CheckBoxhere(value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,

        ) {

        val checkedstate = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkedstate.value, onCheckedChange = {
            checkedstate.value = !checkedstate.value
        }
        )
     ClickableTextComp(value = value)
    }

}

@Composable

fun ClickableTextComp(value: String) {
    val inti = "By continuing you accept our"
    val privacy = " privacy policy"
    val and = " and "
    val term = "term of use"
    val annotatedString = buildAnnotatedString {
        append(inti)
        withStyle(
            style = SpanStyle(
                colorResource(id = R.color.purple_500))){
                pushStringAnnotation(tag = privacy, annotation = privacy)
                append(privacy)
            }
        append(and)
        withStyle(
            style = SpanStyle(
                colorResource(id = R.color.purple_500))){
            pushStringAnnotation(tag = term, annotation = term)
            append(term)
        }


    }
    ClickableText(text =annotatedString, onClick ={
        offset->
        annotatedString.getStringAnnotations(offset,offset).firstOrNull()?.also { span ->

            Log.d("Clicktext","{$span}")
        }
    })
}