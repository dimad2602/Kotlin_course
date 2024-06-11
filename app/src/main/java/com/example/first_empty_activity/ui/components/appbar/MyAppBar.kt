package com.example.first_empty_activity.ui.components.appbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.first_empty_activity.ui.theme.PurpleGrey80
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
    title: String,
    backArrow: Boolean,
    onNavigateUp: () -> Unit,
    color: Color = PurpleGrey80
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (backArrow) {
                IconButton(onClick = onNavigateUp) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            } else {
                null
            }
        },
        //colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
        colors = TopAppBarDefaults.topAppBarColors(containerColor = color)
    )
}