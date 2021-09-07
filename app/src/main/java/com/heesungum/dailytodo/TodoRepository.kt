package com.heesungum.dailytodo

import android.app.Application
import androidx.lifecycle.LiveData

class TodoRepository(application: Application) {

    private val todoDatabase: TodoDatabase = TodoDatabase.getInstance(application)
    private val todoDAO = todoDatabase.todoDao()
    private val todos: LiveData<List<Todo>> = todoDAO.getTodoList()

    suspend fun insert(todo:Todo){
        todoDAO.insertTodo(todo)
    }
    suspend fun delete(todo:Todo){
        todoDAO.delete(todo)
    }
    suspend fun updateAllFalse(){
        todoDAO.updateTodoAllFalse()
    }

    fun getTodos(): LiveData<List<Todo>> = todos

}