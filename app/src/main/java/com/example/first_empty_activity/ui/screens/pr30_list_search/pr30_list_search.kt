package com.example.first_empty_activity.ui.screens.pr30_list_search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.first_empty_activity.domain.list_search.ListSearchViewModel
import com.example.first_empty_activity.ui.components.appbar.MyAppBar
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Pr30ListSearchScreen(
    viewModel: ListSearchViewModel = viewModel(),
    navController: NavController
) {
    val items by viewModel.items.observeAsState(emptyList())
    val loading by viewModel.loading.observeAsState(false)
    val error by viewModel.error.observeAsState(null)

    Scaffold(topBar = {
        MyAppBar(
            title = "List Search",
            backArrow = true,
            onNavigateUp = { navController.navigate("home") })
    }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            TextField(
                value = "",
                onValueChange = { query ->
                    viewModel.searchItems(query)
                },
                label = { Text("Search") }
            )
            Spacer(Modifier.height(12.dp))
            Button(onClick = { viewModel.fetchItems() }) {
                Text("back")
            }
            Spacer(Modifier.height(12.dp))
            when {
                loading -> CircularProgressIndicator()
                error != null -> Text("Error: $error")
                else -> LazyColumn {
                    items(items.size) { index ->
                        Text(text = items[index].toString())
                    }
                }
            }
        }
    }
}

