package com.example.first_empty_activity.domain.repositories.list_search

import android.util.Log
import com.example.first_empty_activity.data.models.itemModel.ItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class ListSearchRepo : IlistSearch {
    override suspend fun getItems(): Flow<List<ItemModel>> = flow {
        delay(1000) // Задержка для имитации ожидания ответа от сервера
        emit(
            listOf(
                ItemModel(
                    name = "first item",
                    weight = "first",
                    cost = "123345",
                    description = "rtyrn"
                ),
                ItemModel(
                    name = "second item",
                    weight = "two",
                    cost = "231",
                    description = "fgh"
                )
            )
        )
    }

    private suspend fun fetchItems(): List<ItemModel> {
        delay(1000) // Задержка для имитации ожидания ответа от сервера
        return listOf(
            ItemModel(
                name = "first item",
                weight = "first",
                cost = "123345",
                description = "rtyrn"
            ),
            ItemModel(
                name = "second item",
                weight = "two",
                cost = "231",
                description = "fgh"
            )
        )

    }

    override suspend fun searchItems(query: String): List<ItemModel> {
        delay(1000) // Задержка для имитации ожидания ответа от сервера
        val list = fetchItems()
        val searchLower = query.lowercase()
        val filteredList = list.filter {
            it.name.contains(query, ignoreCase = true)
        }
        return filteredList
    }
//    override suspend fun getItems(): List<ItemModel> {
//        delay(1000)
//        val list = listOf(
//            ItemModel(
//                name = "first item",
//                weight = "first",
//                cost = "123345",
//                description = "rtyrn"
//            ),
//            ItemModel(
//                name = "second item",
//                weight = "two",
//                cost = "231",
//                description = "fgh"
//            )
//        )
//        return list
//        Log.d("MyApp", "message2")
//        return withContext(Dispatchers.IO) {
//            Log.d("MyApp", "message3")
//            delay(2000) // Задержка на 2 секунды
//            Log.d("MyApp", "message4")
//            listOf(
//                ItemModel(
//                    name = "first item",
//                    weight = "first",
//                    cost = "123345",
//                    description = "rtyrn"
//                ),
//                ItemModel(
//                    name = "second item",
//                    weight = "two",
//                    cost = "231",
//                    description = "fgh"
//                )
//            )
//        }
    //   }

}