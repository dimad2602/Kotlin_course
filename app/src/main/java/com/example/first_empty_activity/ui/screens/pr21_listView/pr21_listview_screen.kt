package com.example.first_empty_activity.ui.screens.pr21_listView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.first_empty_activity.ui.components.appbar.MyAppBar
import com.example.first_empty_activity.ui.widgets.pr21.Pr21Widget


@Composable
fun Pr21ListViewScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MyAppBar(
                title = "Pr21 ListView",
                backArrow = true,
                onNavigateUp = { navController.navigateUp() })
        },
        content = { innerPadding ->
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
                Text("Pr21", modifier = Modifier.padding(innerPadding))
                LazyColumn(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                    items(100){
                        Spacer(modifier = Modifier.height(8.dp))
                        Pr21Widget()
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun Pr21ListViewScreenPreview(){
    val navController = rememberNavController()
    Pr21ListViewScreen(navController)
}