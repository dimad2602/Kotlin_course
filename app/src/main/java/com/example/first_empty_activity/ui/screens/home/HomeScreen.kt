package com.example.first_empty_activity.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.first_empty_activity.ui.components.appbar.MyAppBar

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        containerColor = Color.LightGray,
        topBar = { MyAppBar(title = "NewHome", backArrow = false, onNavigateUp = { /*TODO*/ }) },
        content = { innerPadding ->
            Surface(
                modifier = Modifier.padding(innerPadding),
                color = MaterialTheme.colorScheme.background,
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 4.dp
            ) {
                Column(modifier = Modifier.padding(innerPadding)) {
                    Text("Home")
                    Button(onClick = { navController.navigate("Detail") }) {
                        Text("Go to Detail Screen")
                    }
                    Button(onClick = { navController.navigate("Pr20") }) {
                        Text("Pr20 Row Column")
                    }
                    Button(onClick = { navController.navigate("Pr21") }) {
                        Text("Pr21 ListView")
                    }
                }
            }
//            Surface(modifier = Modifier.padding(innerPadding)) {
//                Text("Home")
//                Button(onClick = { navController.navigate("detail") }) {
//                    Text("Go to Detail Screen")
//                }
//            }
        }
    )
}
//    AppScaffold(
//        title = "Home",
//        backArrow = false,
//        onNavigateUp = { navController.navigateUp() }
//    ) {
//        Button(onClick = { navController.navigate("detail") }) {
//            Text("Go to Detail Screen")
//        }
//    }
