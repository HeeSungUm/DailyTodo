package com.heesungum.dailytodo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TodoRepository(application: Application) {

    private val todoDatabase: TodoDatabase = TodoDatabase.getInstance(application)
    private val todoDAO = todoDatabase.todoDao()
    private val todos: LiveData<List<Todo>> = todoDAO.getTodoList()
    private var today: MutableLiveData<String> = MutableLiveData()

    suspend fun insert(todo:Todo){
        todoDAO.insertTodo(todo)
    }
    fun getToday(): MutableLiveData<String> = today

    fun setToday(today: MutableLiveData<String>){
        this.today = today
    }

    fun getTodos(): LiveData<List<Todo>> = todos

}