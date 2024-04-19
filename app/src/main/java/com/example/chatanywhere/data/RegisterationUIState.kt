package com.example.chatanywhere.data

 data class RegisterationUIState (
     var firstName: String="",
     var lastName: String="",
     var email: String="",
     var password: String="",

     var ferror:Boolean=false,
     var lerror:Boolean=false,
     var emailerror:Boolean=false,
     var passworderror:Boolean=false

 )
