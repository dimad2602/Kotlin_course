package com.example.first_empty_activity.domain.repositories.list_search

import com.example.first_empty_activity.data.models.itemModel.ItemModel

class ListSearchRepo() : Ilist_search {
    override fun getItems(): List<ItemModel> {
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
        return listOf(
            ItemModel(
                name = "second item",
                weight = "first",
                cost = "123345",
                description = "123"
            )
        )
    }
}