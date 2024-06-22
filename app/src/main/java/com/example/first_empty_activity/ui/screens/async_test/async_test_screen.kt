package com.example.first_empty_activity.ui.screens.async_test

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.first_empty_activity.ui.components.appbar.MyAppBar

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.first_empty_activity.domain.repositories.list_search.ListSearchRepo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//class CounterViewModel(private val repository: CountRepo) : ViewModel() {
//    //val count: MutableLiveData<Int> = MutableLiveData(0)
//
//    private val _count = MutableLiveData<Int>(0)
//    val countState: LiveData<Int> = _count
//
//    data class UiState(
//        val isLoading: Boolean,
//        val count: Int = 0
//    )
//
//    suspend fun increase(
//        //count: Int?
//    )
//    {
//        delay(1000)
//        //_count.value = (count ?: 0) + 1
//        //_count.value = (_count.value ?: 0) + 1
//        _count.postValue((_count.value ?: 0) + 1)
//    }
//
//    fun increaseCount() {
//        viewModelScope.launch {
//            try {
//               // val newCount = increase(_count.value)// repository.increase(_count.value)
//                //_count.postValue(newCount)
//                //increase(_count.value)
//                increase()
//            } catch (e: Exception) {
//                // Обработка ошибок
//            }
//        }
//    }
//}

class CounterViewModelFactory(private val repository: CountRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CounterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CounterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class CountRepo {
//    suspend fun increase(count: Int?): Int {
//        delay(1000)
//        val newCount = (count ?: 0) + 1
//        return newCount
//    }

    suspend fun increaseFromRepo(count: Int?): Int {
        delay(1000) // Задержка 1 секунда
        val newCount = (count ?: 0) + 1
        // _count.postValue((_count.value ?: 0) + 1)
        return newCount
    }
}

class CounterViewModel(private val repository: CountRepo) : ViewModel() {
    //val count: MutableLiveData<Int> = MutableLiveData(0)

    private val _count = MutableLiveData<Int>(0)
    val countState: LiveData<Int> = _count

//    suspend fun increase() {
//        delay(1000) // Задержка 1 секунда
//        _count.value = (_count.value ?: 0) + 1
//        // _count.postValue((_count.value ?: 0) + 1)
//    }

    fun increaseCount() {
        viewModelScope.launch {
            // increase()
            val newCount = repository.increaseFromRepo(_count.value)
            _count.value = newCount
        }
    }
}

@Composable
fun AsyncTestScreen(
    navController: NavController,
    repository: CountRepo
    //viewModel: CounterViewModel = viewModel()
) {
    val viewModel: CounterViewModel = viewModel(
        factory = CounterViewModelFactory(repository)
    )

    val count by viewModel.countState.observeAsState(0)

    Scaffold(
        topBar = {
            MyAppBar(
                title = "AsyncTest",
                backArrow = true,
                onNavigateUp = { navController.navigateUp() })
        }
    ) { innerPadding ->
        Column {
            Text(text = "$count", Modifier.padding(innerPadding))
            Button(onClick = { viewModel.increaseCount() }) {
                Text(text = "plus")
            }
        }
    }
}
