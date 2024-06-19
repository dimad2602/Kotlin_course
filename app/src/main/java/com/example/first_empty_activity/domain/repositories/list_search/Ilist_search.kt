package com.example.first_empty_activity.domain.repositories.list_search

import com.example.first_empty_activity.data.models.itemModel.ItemModel

interface Ilist_search{
    fun getItems(): List<ItemModel>

    suspend fun searchItems(query: String): List<ItemModel>
}