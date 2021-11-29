package com.qli38.qli38_p3.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.qli38.qli38_p3.database.Player
import com.qli38.qli38_p3.database.PlayerRepository

class PlayerViewModel (app: Application) : AndroidViewModel(app) {

    init {
        PlayerRepository.initialize(app)
    }

    private val playerRepository = PlayerRepository.get()
    val players = playerRepository.getAllPlayers()

    fun insert(player: Player) {
        playerRepository.insert(player)
    }

    fun deleteFriend(player: Player) {
        playerRepository.deletePlayer(player)
    }
}