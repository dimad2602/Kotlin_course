package com.example.first_empty_activity.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.first_empty_activity.ui.screens.detail.DetailScreen
import com.example.first_empty_activity.ui.screens.home.HomeScreen
import com.example.first_empty_activity.ui.screens.pr20_row_column.Pr20RowColumnScreen


@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("Home") { HomeScreen(navController) }
        composable("Detail") { DetailScreen(navController) }
        composable("Pr20") { Pr20RowColumnScreen(navController) }
    }
}