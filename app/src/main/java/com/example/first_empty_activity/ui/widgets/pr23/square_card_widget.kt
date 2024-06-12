package com.example.first_empty_activity.ui.widgets.pr23

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun SquareCardWidget() {
    Box(modifier = Modifier.size(100.dp) //или .aspectRatio(1f)
        .fillMaxWidth()
        .graphicsLayer {
            shadowElevation = 18.dp.toPx()
            shape = RoundedCornerShape(16.dp)
            clip = true
        }
        .background(Color.White))
}