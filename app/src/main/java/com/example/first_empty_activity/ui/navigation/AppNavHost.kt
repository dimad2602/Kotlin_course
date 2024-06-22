package com.example.first_empty_activity.ui.navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.first_empty_activity.domain.list_search.ListSearchViewModel
import com.example.first_empty_activity.domain.list_search.ListSearchViewModelFactory
import com.example.first_empty_activity.domain.repositories.list_search.ListSearchRepo
import com.example.first_empty_activity.ui.screens.async_test.AsyncTestScreen
import com.example.first_empty_activity.ui.screens.async_test.CountRepo
import com.example.first_empty_activity.ui.screens.detail.DetailScreen
import com.example.first_empty_activity.ui.screens.home.HomeScreen
import com.example.first_empty_activity.ui.screens.pr20_row_column.Pr20RowColumnScreen
import com.example.first_empty_activity.ui.screens.pr21_listView.Pr21ListViewScreen
import com.example.first_empty_activity.ui.screens.pr22_gridview.Pr22GridViewScreen
import com.example.first_empty_activity.ui.screens.pr23.Pr23CustomScrollViewScreen
import com.example.first_empty_activity.ui.screens.pr24_25.Pr2425Screen
import com.example.first_empty_activity.ui.screens.pr27_model.Pr27Model
import com.example.first_empty_activity.ui.screens.pr29_sealed.Pr29Sealed
import com.example.first_empty_activity.ui.screens.pr30_list_search.ListSearchRepoTwo
import com.example.first_empty_activity.ui.screens.pr30_list_search.ListSearchTryTwoScreen
import com.example.first_empty_activity.ui.screens.pr30_list_search.Pr30ListSearchScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    val repository = ListSearchRepo()
    val viewModel: ListSearchViewModel = viewModel(factory = ListSearchViewModelFactory(repository))

    //val countRepo: CountRepo = CountRepo()//viewModel(factory = ListSearchViewModelFactory(repository))

    NavHost(navController = navController, startDestination = startDestination) {
        composable("Home") { HomeScreen(navController) }
        composable("Detail") { DetailScreen(navController) }
        composable("Pr20") { Pr20RowColumnScreen(navController) }
        composable("Pr21") { Pr21ListViewScreen(navController) }
        composable("Pr22") { Pr22GridViewScreen(navController) }
        composable("Pr23") { Pr23CustomScrollViewScreen(navController) }
        composable("Pr2425") { Pr2425Screen(navController) }
        composable("Pr27") { Pr27Model(navController) }
        composable("Pr29") { Pr29Sealed(navController) }
        composable("AsyncTest") { AsyncTestScreen(navController, CountRepo()) }
        composable("Pr30") {
            Pr30ListSearchScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable("Pr30Try2") {
            ListSearchTryTwoScreen(
                navController = navController,
                repo = ListSearchRepoTwo()
            )
        }
    }
}