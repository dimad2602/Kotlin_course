package com.example.first_empty_activity.ui.screens.pr29_sealed

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.first_empty_activity.data.sealed.EmailValidation
import com.example.first_empty_activity.ui.components.appbar.MyAppBar

@Composable
fun Pr29Sealed(navController: NavController) {
    Scaffold(topBar = {
        MyAppBar(
            title = "Pr29 Sealed EvailValid",
            backArrow = true,
            onNavigateUp = { navController.navigateUp() })
    }) { innerPadding ->
        val emailState: EmailValidation = EmailValidation.Success
        when (emailState) {
            is EmailValidation.Success -> {
                println("Email is valid")
                Text(text = "Email is valid", Modifier.padding(innerPadding))
            }
            is EmailValidation.EmptyString -> {
                println("Email is empty")
                Text(text = "Email is empty", Modifier.padding(innerPadding))
            }
            is EmailValidation.InvalidEmail -> {
                println("Email is invalid")
                Text(text = "Email is invalid", Modifier.padding(innerPadding))
            }
            is EmailValidation.EmailExists -> {
                println("Email already exists")
                Text(text = "Email already exists", Modifier.padding(innerPadding))
            }
        }
    }
}

@Preview
@Composable
fun Pr29SealedPreview() {
    val navController = rememberNavController()
    Pr29Sealed(navController = navController)
}