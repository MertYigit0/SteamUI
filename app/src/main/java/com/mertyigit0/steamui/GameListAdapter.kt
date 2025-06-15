package com.mertyigit0.steamui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GameListAdapter(private val games: List<GameListItem>) : RecyclerView.Adapter<GameListAdapter.GameListViewHolder>() {

    class GameListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gameImage: ImageView = itemView.findViewById(R.id.ivGameImage)
        val gameTitle: TextView = itemView.findViewById(R.id.tvGameTitle)
        val gameGenre: TextView = itemView.findViewById(R.id.tvGameGenre)
        val releaseDate: TextView = itemView.findViewById(R.id.tvReleaseDate)
        val discount: TextView = itemView.findViewById(R.id.tvDiscount)
        val originalPrice: TextView = itemView.findViewById(R.id.tvOriginalPrice)
        val finalPrice: TextView = itemView.findViewById(R.id.tvFinalPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game_list, parent, false)
        return GameListViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameListViewHolder, position: Int) {
        val game = games[position]
        holder.gameImage.setImageResource(game.imageResource)
        holder.gameTitle.text = game.title
        holder.gameGenre.text = game.genre
        holder.releaseDate.text = game.releaseDate
        
        if (game.discount.isNotEmpty()) {
            holder.discount.text = game.discount
            holder.discount.visibility = View.VISIBLE
            holder.originalPrice.text = game.originalPrice
            holder.originalPrice.visibility = View.VISIBLE
        } else {
            holder.discount.visibility = View.GONE
            holder.originalPrice.visibility = View.GONE
        }
        
        holder.finalPrice.text = game.finalPrice
    }

    override fun getItemCount(): Int = games.size
} 