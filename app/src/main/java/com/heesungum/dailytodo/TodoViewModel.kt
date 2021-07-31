package com.heesungum.dailytodo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel (application: Application): AndroidViewModel(application) {
    private val _today: MutableLiveData<String> = MutableLiveData()
    val today: LiveData<String>
        get() = _today

    private val repository: TodoRepository = TodoRepository(application)
    val todos: LiveData<List<Todo>> = repository.getTodos()


    fun insertTodo(title: String, dialog: AddDialogFragment) = viewModelScope.launch(Dispatchers.IO) {
        if (title != ""){
            repository.insert(Todo(title = title))
            dialog.dismiss()
        }
    }
    fun deleteTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(todo)
    }

    fun setToday(today: LiveData<String>){
        _today.value = today.value
    }
}

