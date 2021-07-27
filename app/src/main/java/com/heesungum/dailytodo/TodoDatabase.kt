package com.heesungum.dailytodo

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDAO

    companion object {
        @Volatile private var INSTANCE: TodoDatabase? = null

        fun getInstance(context: Context): TodoDatabase = INSTANCE?:
            synchronized(this){
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            TodoDatabase::class.java, "Todo.db").build()
    }
}