package com.example.first_empty_activity.domain.list_search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.first_empty_activity.data.models.itemModel.ItemModel
import com.example.first_empty_activity.domain.repositories.list_search.ListSearchRepo
import kotlinx.coroutines.launch

class ListSearchViewModel(private val repository: ListSearchRepo) : ViewModel() {
    private val _items = MutableLiveData<List<ItemModel>>()
    val items: LiveData<List<ItemModel>> = _items

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    init {
        fetchItems()
    }

    fun fetchItems() {
        viewModelScope.launch {
            _loading.value = true
            try {
                _items.value = repository.getItems()
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }

    fun searchItems(query: String) {
        viewModelScope.launch {
            _loading.value = true
            try {
                _items.value = repository.searchItems(query)
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }
}