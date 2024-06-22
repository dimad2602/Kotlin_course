package com.example.first_empty_activity.domain.repositories.list_search

import com.example.first_empty_activity.data.models.itemModel.ItemModel
import kotlinx.coroutines.flow.Flow

interface IlistSearch{
    suspend fun getItems(): Flow<List<ItemModel>>

    suspend fun searchItems(query: String): List<ItemModel>
}