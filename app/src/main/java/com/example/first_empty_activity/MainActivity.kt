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

//import androidx.compose.foundation.layout.Column
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.OutlinedButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.unit.sp
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            var progress by remember { mutableStateOf(0.0f) }
//            val scope = rememberCoroutineScope()
//
//            Column{
//                Text("Статус: $progress", fontSize = 28.sp)
//                OutlinedButton(
//                    onClick = {
//                        if(progress >=1f) progress=0f
//                        scope.launch {
//                            while (progress < 1f) {
//                                progress += 0.1f
//                                delay(1000L)
//                            }
//                        }
//                    }
//                ) { Text("Запустить", fontSize = 22.sp) }
//                CircularProgressIndicator()
//            }
//        }
//    }
//}