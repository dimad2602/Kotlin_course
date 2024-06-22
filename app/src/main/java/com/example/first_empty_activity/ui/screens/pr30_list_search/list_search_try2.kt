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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.first_empty_activity.ui.components.appbar.MyAppBar
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ListSearchTryTwoScreen(
    navController: NavController,
    repo: ListSearchRepoTwo
) {
    val viewModel: ListSearchViewModelTwo = viewModel(
        factory = ListSearchViewModelFactoryTwo(repo)
    )

    LaunchedEffect(Unit) {
        viewModel.getItems()
    }

    val list by viewModel.list.observeAsState(listOf())
    val loading by viewModel.loading.observeAsState(true)

    Scaffold(topBar = {
        MyAppBar(
            title = "List Search",
            backArrow = true,
            onNavigateUp = { navController.navigate("home") })
    }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
//            TextField(
//                value = "",
//                onValueChange = { query ->
//                    viewModel.searchItems(query)
//                },
//                label = { Text("Search") }
//            )
            Spacer(Modifier.height(12.dp))
            Button(onClick = { viewModel.getItems() }) {
                Text("back")
            }
            Spacer(Modifier.height(12.dp))
            when {
                loading -> CircularProgressIndicator()//Text(text = "Загрузка")//
                //error != null -> Text("Error: $error")
                else -> LazyColumn {
                    items(list.size) { index ->
                        Text(text = list[index].toString())
                    }
                }
            }

        }
    }
}