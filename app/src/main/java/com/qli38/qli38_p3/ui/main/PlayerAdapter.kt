package com.qli38.qli38_p3.ui.main

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qli38.qli38_p3.R
import com.qli38.qli38_p3.database.Player
import com.qli38.qli38_p3.databinding.RecyclerItemBinding

class PlayerAdapter: RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    private var players: List<Player> = emptyList()
    var playerInfo: Player? = null

    class PlayerViewHolder(private val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val wordTextView: TextView = itemView.findViewById(R.id.recycler_textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PlayerViewHolder(
        RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val info = players[position]
        holder.wordTextView.text = "First Name: " + info.firstName + ";\n" + info.comment

        holder.wordTextView.setOnClickListener {
//            Toast.makeText(activity, "You have selected " + friends[position].firstName, Toast.LENGTH_SHORT).show()
            holder.itemView.setBackgroundColor(Color.parseColor("#bf3131"))
//                sharedViewModel.deleteFriend(friend = info)`
            playerInfo = info
            true
        }
    }

    override fun getItemCount(): Int = players.size

    fun updatePlayers(newFriends: List<Player>) {
        this.players = newFriends
        notifyDataSetChanged()
    }

    fun getPlayerAtPosition(position: Int): Player {
        return players[position]
    }
}