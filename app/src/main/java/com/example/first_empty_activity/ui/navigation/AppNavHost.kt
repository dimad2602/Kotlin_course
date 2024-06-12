package com.example.first_empty_activity.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.first_empty_activity.ui.screens.detail.DetailScreen
import com.example.first_empty_activity.ui.screens.home.HomeScreen
import com.example.first_empty_activity.ui.screens.pr20_row_column.Pr20RowColumnScreen
import com.example.first_empty_activity.ui.screens.pr21_listView.Pr21ListViewScreen
import com.example.first_empty_activity.ui.screens.pr22_gridview.Pr22GridViewScreen
import com.example.first_empty_activity.ui.screens.pr23.Pr23CustomScrollViewScreen
import com.example.first_empty_activity.ui.screens.pr23.Pr23CustomScrollViewScreenPreview


@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("Home") { HomeScreen(navController) }
        composable("Detail") { DetailScreen(navController) }
        composable("Pr20") { Pr20RowColumnScreen(navController) }
        composable("Pr21") { Pr21ListViewScreen(navController) }
        composable("Pr22") { Pr22GridViewScreen(navController) }
        composable("Pr23") { Pr23CustomScrollViewScreen(navController) }
    }
}