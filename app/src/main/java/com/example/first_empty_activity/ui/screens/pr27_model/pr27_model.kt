package com.example.first_empty_activity.ui.screens.pr27_model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.first_empty_activity.ui.components.appbar.MyAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.first_empty_activity.data.mapper.toDTO
import com.example.first_empty_activity.data.mapper.toPerson
import com.example.first_empty_activity.data.models.person.PersonModel

@Composable
fun Pr27Model(navController: NavController) {
    Scaffold(topBar = {
        MyAppBar(
            title = "PersonModel",
            backArrow = true,
            onNavigateUp = { navController.navigateUp() })
    }) {

            innerPadding ->
        val person = PersonModel(firstName = "John", lastName = "Doe", age = 30)
        val personDTO = person.toDTO()

        println(personDTO) // Вывод: PersonDTO(firstName=John, lastName=Doe)

        val newPerson = personDTO.toPerson()
        val copyPerson = personDTO.copy(age = 35).toPerson()
        println(newPerson) // Вывод: Person(firstName=John, lastName=Doe, age=35)
        Column {
            Text(text = "text", modifier = Modifier.padding(innerPadding))
            Text(text = person.toString(), modifier = Modifier.padding(innerPadding))
            Text(text = personDTO.toString(), modifier = Modifier.padding(innerPadding))
            Text(text = newPerson.toString(), modifier = Modifier.padding(innerPadding))
            Text(text = copyPerson.toString(), modifier = Modifier.padding(innerPadding))
        }
    }
}

@Preview
@Composable
fun Pr27ModelPreview(){
    val navController = rememberNavController()
    Pr27Model(navController)
}