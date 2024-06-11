package com.example.first_empty_activity.ui.screens.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.first_empty_activity.ui.components.AppScaffold

@Composable
fun DetailScreen(navController: NavController) {
    AppScaffold(
        title = "Detail",
        backArrow = true,
        onNavigateUp ={navController.navigate("Home")} //{ navController.navigateUp() }
    ) {
        Text("Detail Screen")
    }
}