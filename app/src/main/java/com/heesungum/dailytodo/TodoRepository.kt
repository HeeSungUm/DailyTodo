package com.heesungum.dailytodo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TodoRepository(application: Application) {

    private val todoDatabase: TodoDatabase = TodoDatabase.getInstance(application)
    private val todoDAO = todoDatabase.todoDao()
    private val todos: LiveData<List<Todo>> = todoDAO.getTodoList()

    suspend fun insert(todo:Todo){
        todoDAO.insertTodo(todo)
    }

    fun getTodos(): LiveData<List<Todo>> = todos

}