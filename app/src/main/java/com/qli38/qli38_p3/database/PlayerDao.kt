package com.qli38.qli38_p3.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(player: Player)

    @Query("DELETE FROM player_table")
    fun deleteAll()

    @Delete
    fun deletePlayer(player: Player)

    @Query("SELECT * FROM player_table LIMIT 1")
    fun getAnyPlayer(): Array<Player>

    @Query("SELECT * FROM player_table ORDER BY player_id DESC")
    fun getAllPlayers(): LiveData<List<Player>>
}