package com.heesungum.dailytodo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel (application: Application): AndroidViewModel(application) {
    private val repository: TodoRepository = TodoRepository(application)
    private val todos: LiveData<List<Todo>> = repository.getTodos()
    private val today: MutableLiveData<String> = repository.getToday()

    fun insert(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(todo)
    }

    fun getTodos(): LiveData<List<Todo>> = todos

    fun getToday(): MutableLiveData<String> = today

    fun setToday(today: MutableLiveData<String>) {
        repository.setToday(today)
    }
}

