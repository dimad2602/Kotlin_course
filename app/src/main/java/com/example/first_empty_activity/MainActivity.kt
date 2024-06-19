package com.example.first_empty_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.first_empty_activity.ui.navigation.AppNavHost
import com.example.first_empty_activity.ui.theme.First_empty_activityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            First_empty_activityTheme {
                AppNavHost()
            }
        }
    }
}
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.first_empty_activity.ui.theme.First_empty_activityTheme
//import com.example.first_empty_activity.ui.theme.Pink80
//import com.example.first_empty_activity.ui.theme.Purple40
//import com.example.first_empty_activity.ui.screens.pr19.SecondActivity
//
//class MainActivity : ComponentActivity() {
//    @OptIn(ExperimentalMaterial3Api::class)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            First_empty_activityTheme {
//                MainScreen(onNavigateToSecondPage = { navigateToSecondPage() })
//            }
//        }
//    }
//
//    private fun navigateToSecondPage() {
//        val intent = Intent(this, SecondActivity::class.java)
//        startActivity(intent)
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MainScreen(onNavigateToSecondPage: () -> Unit) {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("AppBar Title") },
//                colors = topAppBarColors(
//                    Pink80
//                )
//            )
//        },
//        modifier = Modifier.fillMaxSize()
//    ) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .padding(innerPadding)
//                .fillMaxSize()
//                .padding(top = 30.dp)
//        ) {
//            Text(
//                text = "Hello Дмитрий!"
//            )
//            Text(
//                text = "fdgd"
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Box(
//                modifier = Modifier
//                    .size(100.dp)
//                    .background(color = Purple40)
//                    .align(Alignment.CenterHorizontally)
//            ) {
//                Text("Hello", color = Color.White, modifier = Modifier.align(Alignment.Center))
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(
//                onClick = onNavigateToSecondPage,
//                modifier = Modifier.align(Alignment.CenterHorizontally)
//            ) {
//                Text("Go to Second Page")
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun MainScreenPreview() {
//    First_empty_activityTheme {
//        MainScreen(onNavigateToSecondPage = {})
//    }
//}
