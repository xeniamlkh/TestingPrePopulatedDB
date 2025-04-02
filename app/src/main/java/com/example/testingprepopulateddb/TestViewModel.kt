package com.example.testingprepopulateddb

import android.app.ActionBar.Tab
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.testingprepopulateddb.data.Repository
import com.example.testingprepopulateddb.data.Table
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TestViewModel(private val repository: Repository) : ViewModel() {

    private val _state = MutableStateFlow<List<Table>>(emptyList())
    val state: StateFlow<List<Table>> get() = _state

    fun getData() {
        viewModelScope.launch {
            repository.getData().collect { result ->
                _state.value = result
            }
        }
    }
}

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(TestViewModel::class.java)) {
            return TestViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}