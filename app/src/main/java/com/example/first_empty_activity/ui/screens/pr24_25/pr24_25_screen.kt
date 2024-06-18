package com.example.first_empty_activity.ui.screens.pr24_25

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.first_empty_activity.R
import com.example.first_empty_activity.ui.components.appbar.MyAppBar
import com.example.first_empty_activity.ui.components.text_field.MyTextField
import com.example.first_empty_activity.ui.theme.Purple40
import com.example.first_empty_activity.ui.theme.Purple80

@Composable
fun Pr2425Screen(navController: NavController) {
    val EmailTextField = remember { mutableStateOf("") }
    val PasswordTextField = remember { mutableStateOf("") }

    Scaffold(topBar = {
        MyAppBar(title = "Pr24_25 Screen",
            backArrow = true,
            onNavigateUp = { navController.navigate("Home") })
    }, content = { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "You typed: ${EmailTextField.value}", //если =
                //text = "You typed: ${text}", // если by
                modifier = Modifier
                    .padding(innerPadding)
                    .align(Alignment.Start)
            )
            MyTextField(
                text = EmailTextField, labelText = "E-mail",
                leftIcon =
                Icons.Default.MailOutline,
                supportingText = "Введите свой e-mail",
            )
            Spacer(Modifier.height(12.dp))
            MyTextField(
                text = PasswordTextField,
                labelText = "Пароль",
                hiddenText = true,
            )
            Spacer(Modifier.height(6.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Purple40),
            ) {
                Text(text = "Вход")
            }
            Spacer(Modifier.height(12.dp))
            Text(text = "Зарегистрироваться", color = colorResource(R.color.purple_200))
        }
    })
}

@Preview(showBackground = true)
@Composable
fun Pr2425ScreenPreview() {
    val navController = rememberNavController()
    Pr2425Screen(navController = navController)
}