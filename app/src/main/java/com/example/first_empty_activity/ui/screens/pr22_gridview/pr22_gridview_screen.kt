package com.example.first_empty_activity.ui.screens.pr22_gridview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.first_empty_activity.ui.components.appbar.MyAppBar

@Composable
fun Pr22GridViewScreen(navController: NavController) {
    val itemCount = 3 * 6
    Scaffold(
        topBar = {
            MyAppBar(
                title = "Pr22 GridView",
                backArrow = true,
                onNavigateUp = { navController.navigate("Home") })
        },
        content = { innerPadding ->
            Column {
                Text(text = "PR22", modifier = Modifier.padding(innerPadding))
                LazyVerticalGrid(
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    columns = GridCells.Fixed(3), modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(itemCount) { index ->
                        val row = 1 + index / 3
                        val col = index % 3
                        val number = row + col
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("$number", style = TextStyle(fontSize = 20.sp))
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun Pr22GridViewScreenPreview() {
    val navController = rememberNavController()
    Pr22GridViewScreen(navController)
}