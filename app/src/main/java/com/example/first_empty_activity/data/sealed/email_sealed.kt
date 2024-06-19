package com.example.first_empty_activity.data.sealed

sealed class EmailValidation{
    object Success: EmailValidation()
    object EmptyString : EmailValidation()
    object InvalidEmail : EmailValidation()
    object EmailExists : EmailValidation()
}