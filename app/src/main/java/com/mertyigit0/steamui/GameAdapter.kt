package com.mertyigit0.steamui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gameImage: ImageView = itemView.findViewById(R.id.ivGameImage)
        val discount: TextView = itemView.findViewById(R.id.tvDiscount)
        val originalPrice: TextView = itemView.findViewById(R.id.tvOriginalPrice)
        val discountedPrice: TextView = itemView.findViewById(R.id.tvDiscountedPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game_card, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        holder.gameImage.setImageResource(game.imageResource)
        holder.discount.text = game.discount
        holder.originalPrice.text = game.originalPrice
        holder.discountedPrice.text = game.discountedPrice
    }

    override fun getItemCount(): Int = games.size
} 