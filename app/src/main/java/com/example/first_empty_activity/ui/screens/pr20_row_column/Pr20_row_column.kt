package com.example.first_empty_activity.ui.screens.pr20_row_column

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.first_empty_activity.ui.components.appbar.MyAppBar

@Composable
fun Pr20RowColumnScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MyAppBar(
                title = "Pr20",
                backArrow = true,
                onNavigateUp = { navController.navigateUp() })
        },
        content = { innerPadding ->
//
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                CircularProgressIndicator()
//                Text("dfg", Modifier.padding(innerPadding))
//            }

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                Text("PR20", modifier = Modifier.padding(innerPadding))
                Box(
                    Modifier
                        .size(width = 300.dp, height = 80.dp)
                        .border(1.dp, color = Color.LightGray)
                        .padding(16.dp)
                ) {
                    Row {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                //.background(color = Color.LightGray)
                                .background(color = Color.Gray.copy(alpha = 0.5f))
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(modifier = Modifier.align(alignment = Alignment.CenterVertically)) {
                            Row {
                                Text(
                                    "Имя",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "Фамилия",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                            Text("Должность", style = TextStyle(fontSize = 15.sp))
                        }
                    }
                }
                CircularProgressIndicator()
            }
        }
    )
}