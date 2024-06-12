package com.example.first_empty_activity.ui.screens.pr23

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.first_empty_activity.ui.components.appbar.MyAppBar
import com.example.first_empty_activity.ui.widgets.pr23.PointCardWidget
import com.example.first_empty_activity.ui.widgets.pr23.SquareCardWidget
import com.example.first_empty_activity.ui.widgets.pr23.WideCardWidget

@Composable
fun Pr23CustomScrollViewScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MyAppBar(
                title = "CustomScrollView Example",
                backArrow = true,
                onNavigateUp = { navController.navigateUp() })
        },
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                item {
                    WideCardWidget()
                }
                items(20) {
                    PointCardWidget()
                }

                item {
                    Spacer(modifier = Modifier.height(8.dp))
                }

                item {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        contentPadding = PaddingValues(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.height(200.dp)
                    ) {
                        items(20) {
                            SquareCardWidget()
//                            Box(
//                                modifier = Modifier
//                                    .aspectRatio(1f)
//                                    .background(Color.Green),
//                                contentAlignment = Alignment.Center
//                            ) {
//                                Text("Square Card Widget")
//                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun Pr23CustomScrollViewScreenPreview() {
    val navController = rememberNavController()
    Pr23CustomScrollViewScreen(navController)
}