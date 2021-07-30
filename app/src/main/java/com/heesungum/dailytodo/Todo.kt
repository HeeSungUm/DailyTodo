package com.heesungum.dailytodo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Todo")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "createdDate", defaultValue = "CURRENT_TIMESTAMP")
    var createdDate: Long,

    @ColumnInfo(name = "Date", defaultValue = "")
    var Date: String,

    @ColumnInfo(name = "times", defaultValue = "0")
    var times: Long,

    @ColumnInfo(name = "isChecked", defaultValue = "false")
    var isChecked: Boolean

) {
    constructor() : this(null, "", "", -1, "",0, false)
    constructor(title: String) : this(null, title, "", -1, "",0, false)
}