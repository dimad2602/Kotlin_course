package com.example.first_empty_activity.domain.list_search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.first_empty_activity.data.models.itemModel.ItemModel
import com.example.first_empty_activity.domain.repositories.list_search.ListSearchRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListSearchViewModel(private val repository: ListSearchRepo) : ViewModel() {
    private val _items = MutableLiveData<List<ItemModel>>()
    val items: LiveData<List<ItemModel>> = _items

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

//    init {
//        fetchItems()
//    }

    //    fun fetchItems() {
//        Log.d("MyApp", "1")
//        viewModelScope.launch {
//            _loading.value = true
//            Log.d("MyApp", "2")
//            try {
//                Log.d("MyApp", "Fetching items started")
//                val response = repository.getItems()
//                Log.d("MyApp", "Items fetched successfully: ${response.size}")
//                _items.value = response
//                _error.value = null
//            } catch (e: Exception) {
//                Log.e("MyApp", "Error fetching items: ${e.message}")
//                _error.value = e.message
//            } finally {
//                _loading.value = false
//                Log.d("MyApp", "Fetching items finished")
//            }
//        }
//    }
    fun fetchItems() {
        viewModelScope.launch {
            _loading.value = true
            try {
                repository.getItems()
                    .catch { e -> _error.value = e.message }
                    .collect { itemList ->
                        _items.value = itemList
                        _error.value = null
                    }
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }

//    fun fetchItems() {
//        Log.d("MyApp", "message1")

//        viewModelScope.launch {
//            _loading.value = true
//            try {
//                Log.d("MyApp", "message2")
//                _items.value = repository.getItems()
//                _error.value = null
//            } catch (e: Exception) {
//                _error.value = e.message
//            } finally {
//                _loading.value = false
//            }
//        }
//        viewModelScope.launch {
//            _loading.value = true
//            try {
//                Log.d("MyApp", "message2")
//                val response = viewModelScope.async{ repository.getItems() }
//                _items.value = response.await()
//                _error.value = null
//            } catch (e: Exception) {
//                _error.value = e.message
//            } finally {
//                _loading.value = false
//            }
//        }

//        lifecycleScope.launch {
//            try {
//                val result = lifecycleScope.async { getMoreUsers() }
//                val user = result.await()
//            } catch (exception: Exception) {
//                Timber.d("$exception handled !")
//            }
//        }
//    }

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