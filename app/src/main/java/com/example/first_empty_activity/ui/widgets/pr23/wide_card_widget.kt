package com.example.first_empty_activity.ui.widgets.pr23

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WideCardWidget() {
    Box(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .graphicsLayer {
                shadowElevation = 8.dp.toPx()
                shape = RoundedCornerShape(16.dp)
                clip = true
            }
            .background(color = Color.White)
            .padding(15.dp)
    ) {
        Text(
            text = "Lorem ipsum dolor sit amet consectetur.",
            maxLines = 2,
            style = TextStyle(fontSize = 20.sp)
        )
    }
}