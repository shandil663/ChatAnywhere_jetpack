package com.example.chatanywhere.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val TAG = LoginViewModel::class.simpleName
    var registerationUIState = mutableStateOf(RegisterationUIState())

    fun onEvent(event: UIEvent) {
        when (event) {
            is UIEvent.FirstNameChanged -> {
                registerationUIState.value = registerationUIState.value.copy(
                    firstName = event.firstName
                )

                printState()
            }

            is UIEvent.LastNameChanged -> {
                registerationUIState.value = registerationUIState.value.copy(
                    lastName = event.lastName
                )

                printState()
            }

            is UIEvent.EmailChanged -> {
                registerationUIState.value = registerationUIState.value.copy(
                    email = event.email
                )

                printState()
            }

            is UIEvent.PasswordChanged -> {
                registerationUIState.value = registerationUIState.value.copy(
                    password = event.password
                )

                printState()
            }

            is UIEvent.RegisterButton -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        Log.d(TAG, "Button logic")
        printState()
        ValidateData()

    }

    private fun ValidateData() {
        val fnameresult = Validator.validateFirstName(
            fName = registerationUIState.value.firstName
        )
        val lnameresult = Validator.validateLasttName(
            lName = registerationUIState.value.lastName
        )
        val emailresult = Validator.validateEmail(
            email = registerationUIState.value.email
        )
        val passwordresult = Validator.validatePassword(
            password = registerationUIState.value.password
        )

        registerationUIState.value = registerationUIState.value.copy(
            ferror = fnameresult.status,
            lerror = lnameresult.status,
            emailerror = emailresult.status,
            passworderror = passwordresult.status
        )
    }

    private fun printState() {
        Log.d(TAG, "Inside Printemp")
        Log.d(TAG, registerationUIState.value.toString())
    }
}