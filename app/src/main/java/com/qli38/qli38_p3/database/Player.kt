package com.qli38.qli38_p3.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_table")
data class Player (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "player_id")
    var id: Long = 0L,

    @ColumnInfo(name = "first_name")
    var firstName: String = "",

    @ColumnInfo(name = "last_name")
    var lastName: String = "",

    @ColumnInfo(name = "nickname")
    var nickName: String = "",

    @ColumnInfo(name = "comment")
    var comment: String = "",

)