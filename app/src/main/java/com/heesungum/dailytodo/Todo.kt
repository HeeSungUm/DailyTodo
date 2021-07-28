package com.heesungum.dailytodo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Todo")
data class Todo (
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "createdDate")
    var createdDate:Long,

    @ColumnInfo(name = "times")
    var times:Long,

    @ColumnInfo(name = "isChecked")
    var isChecked:Boolean

){
    constructor(): this(null, "", "", -1, 0, false)
}