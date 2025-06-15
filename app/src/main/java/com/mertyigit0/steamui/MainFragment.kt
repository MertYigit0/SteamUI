package com.mertyigit0.steamui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment() {

    private lateinit var gameRecyclerView: RecyclerView
    private lateinit var gameAdapter: GameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupGameRecyclerView(view)
    }

    private fun setupGameRecyclerView(view: View) {
        gameRecyclerView = view.findViewById(R.id.rvGames)
        
        // Oyun listesi oluşturma
        val games = listOf(
            Game(R.drawable.deathstranding, "-60%", "$18.99", "$7.59 USD"),
            Game(R.drawable.pharaoh, "-75%", "$24.99", "$6.24 USD"),
            Game(R.drawable.stardew, "-50%", "$14.99", "$7.49 USD"),
            Game(R.drawable.cyberpunk2077, "-30%", "$59.99", "$41.99 USD"),
            Game(R.drawable.witcher, "-70%", "$39.99", "$11.99 USD"),
            Game(R.drawable.gow, "-40%", "$49.99", "$29.99 USD")
        )
        
        gameAdapter = GameAdapter(games)
        gameRecyclerView.adapter = gameAdapter
        gameRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
}