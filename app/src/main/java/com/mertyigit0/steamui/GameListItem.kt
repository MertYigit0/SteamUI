package com.mertyigit0.steamui

data class GameListItem(
    val imageResource: Int,
    val title: String,
    val genre: String,
    val releaseDate: String,
    val discount: String,
    val originalPrice: String,
    val finalPrice: String
) 