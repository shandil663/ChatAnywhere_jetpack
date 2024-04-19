package com.example.chatanywhere.data

object Validator {

    fun validateFirstName(fName :String): ValidationResult{
return ValidationResult(!fName.isNullOrEmpty()&&fName.length>=3)
    }
    fun validateLasttName(lName :String):ValidationResult{
        return ValidationResult(!lName.isNullOrEmpty()&&lName.length>=3)
    }

    fun validateEmail(email :String):ValidationResult{
        return ValidationResult(!email.isNullOrEmpty())
    }

    fun validatePassword(password :String):ValidationResult{

        return ValidationResult(!password.isNullOrEmpty()&&password.length>=6)
    }

data class ValidationResult(
    val status:Boolean=false
)

}
