package com.example.first_empty_activity.ui.widgets.pr23

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PointCardWidget() {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 16.dp)) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .size(16.dp)
                .clip(CircleShape)
                .background(color = Color.LightGray)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Lorem ipsum dolor sit amet consectetur.",
            maxLines = 2,
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(fontSize = 20.sp)
        )
    }
}