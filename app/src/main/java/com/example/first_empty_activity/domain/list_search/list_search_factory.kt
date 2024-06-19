package com.example.first_empty_activity.domain.list_search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.first_empty_activity.domain.repositories.list_search.ListSearchRepo

class ListSearchViewModelFactory(private val repository: ListSearchRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListSearchViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListSearchViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}