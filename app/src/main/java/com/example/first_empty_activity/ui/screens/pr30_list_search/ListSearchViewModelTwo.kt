package com.example.first_empty_activity.ui.screens.pr30_list_search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.first_empty_activity.data.models.itemModel.ItemModel
import com.example.first_empty_activity.domain.list_search.ListSearchViewModel
import com.example.first_empty_activity.domain.repositories.list_search.ListSearchRepo
import com.example.first_empty_activity.ui.screens.async_test.CountRepo
import com.example.first_empty_activity.ui.screens.async_test.CounterViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ListSearchRepoTwo {
    suspend fun getListItems(): List<ItemModel> {
        delay(1500) // Задержка 1 секунда
        val list = listOf(
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
        return list
    }
}

class ListSearchViewModelFactoryTwo(private val repository: ListSearchRepoTwo) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListSearchViewModelTwo::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListSearchViewModelTwo(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class ListSearchViewModelTwo(private val repository: ListSearchRepoTwo) : ViewModel() {
    private val _list = MutableLiveData<List<ItemModel>>(listOf())
    val list: LiveData<List<ItemModel>> = _list

    private val _loading = MutableLiveData<Boolean>(true)
    val loading: LiveData<Boolean> = _loading

    fun getItems() {
        viewModelScope.launch {
            _loading.value = true
            try {
                val newCount = repository.getListItems()
                _list.value = newCount
//                repository.getItems()
//                    .catch { e -> _error.value = e.message }
//                    .collect { itemList ->
//                        _items.value = itemList
//                        _error.value = null
//                    }
            } catch (e: Exception) {
                //_error.value = e.message
            }
            finally {
                _loading.value = false
            }
        }
    }
}