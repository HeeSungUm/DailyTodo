package com.heesungum.dailytodo

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDAO {

    @Query("select * from Todo order by createdDate ASC")
    fun getTodoList(): LiveData<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    @Delete
    suspend fun delete(todo:Todo)

    @Query(
        "select * from Todo" +
                "update Todo set isChecked =:False" +
                "where id =: Todo.id"
    )
    suspend fun updateTodoAllFalse()
}