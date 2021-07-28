package com.heesungum.dailytodo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDAO {

    @Query("select * from Todo order by createdDate ASC")
    fun getTodoList(): LiveData<List<Todo>>

    @Insert
    suspend fun insertTodo(todo: Todo)
}