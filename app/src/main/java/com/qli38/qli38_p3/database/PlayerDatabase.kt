package com.qli38.qli38_p3.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Player::class], version = 1, exportSchema = true)
abstract class PlayerDatabase: RoomDatabase(){
    abstract fun playerDao(): PlayerDao
}