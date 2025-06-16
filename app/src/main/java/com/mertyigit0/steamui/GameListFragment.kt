package com.mertyigit0.steamui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GameListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var gameListAdapter: GameListAdapter
    private var tabType: String? = null

    companion object {
        private const val ARG_TAB_TYPE = "tab_type"

        fun newInstance(tabType: String): GameListFragment {
            val fragment = GameListFragment()
            val args = Bundle()
            args.putString(ARG_TAB_TYPE, tabType)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tabType = it.getString(ARG_TAB_TYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(view)
    }

    private fun setupRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.rvGameList)
        val games = getGamesForTab(tabType ?: "")
        
        gameListAdapter = GameListAdapter(games)
        recyclerView.adapter = gameListAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun getGamesForTab(tabType: String): List<GameListItem> {
        return when (tabType) {
            "Yeni Popüler" -> listOf(
                GameListItem(R.drawable.stardew, "Stardew Valley", "Çiftçilik, Simülasyon", "12 Oca 2025", "-50%", "$14.99", "$7.49"),
                GameListItem(R.drawable.cyberpunk2077, "Cyberpunk 2077", "RPG, Aksiyon", "15 Oca 2025", "-30%", "$59.99", "$41.99"),
                GameListItem(R.drawable.deathstranding, "Death Stranding", "Aksiyon, Macera", "10 Oca 2025", "-60%", "$18.99", "$7.59"),
                GameListItem(R.drawable.gow, "God of War", "Aksiyon, Macera", "20 Oca 2025", "-40%", "$49.99", "$29.99"),
                GameListItem(R.drawable.witcher, "The Witcher 3", "RPG, Açık Dünya", "18 Oca 2025", "-70%", "$39.99", "$11.99"),
                GameListItem(R.drawable.alters, "The Alters", "Hayatta Kalma", "13 Haz 2025", "-10%", "$17.99", "$16.19"),
                GameListItem(R.drawable.stellarblade, "Stellar Blade™", "Aksiyon, Souls-like", "2 Haz 2025", "", "$59.99", "$59.99"),
                GameListItem(R.drawable.pharaoh, "Pharaoh", "Strateji, Şehir Kurma", "25 Oca 2025", "-75%", "$24.99", "$6.24"),
                GameListItem(R.drawable.deathstranding, "Death Stranding 2", "Aksiyon, Macera", "30 Oca 2025", "-20%", "$69.99", "$55.99"),
                GameListItem(R.drawable.cyberpunk2077, "Cyberpunk Expansion", "RPG, DLC", "5 Şub 2025", "-25%", "$29.99", "$22.49"),

            )
            "Çok Satanlar" -> listOf(

                GameListItem(R.drawable.cyberpunk2077, "Cyberpunk 2077", "RPG, Aksiyon", "15 Oca 2025", "-30%", "$59.99", "$41.99"),
                GameListItem(R.drawable.gow, "God of War", "Aksiyon, Macera", "20 Oca 2025", "-40%", "$49.99", "$29.99"),
                GameListItem(R.drawable.witcher, "The Witcher 3", "RPG, Açık Dünya", "18 Oca 2025", "-70%", "$39.99", "$11.99"),
                GameListItem(R.drawable.stardew, "Stardew Valley", "Çiftçilik, Simülasyon", "12 Oca 2025", "-50%", "$14.99", "$7.49"),
                GameListItem(R.drawable.deathstranding, "Death Stranding", "Aksiyon, Macera", "10 Oca 2025", "-60%", "$18.99", "$7.59"),
                GameListItem(R.drawable.stellarblade, "Stellar Blade™", "Aksiyon, Souls-like", "2 Haz 2025", "", "$59.99", "$59.99"),
                GameListItem(R.drawable.pharaoh, "Pharaoh", "Strateji, Şehir Kurma", "25 Oca 2025", "-75%", "$24.99", "$6.24"),
                GameListItem(R.drawable.alters, "The Alters", "Hayatta Kalma", "13 Haz 2025", "-10%", "$17.99", "$16.19"),
                GameListItem(R.drawable.cyberpunk2077, "Cyberpunk DLC", "RPG, Eklenti", "1 Şub 2025", "-15%", "$19.99", "$16.99"),
                GameListItem(R.drawable.gow, "God of War Ragnarök", "Aksiyon, Macera", "28 Oca 2025", "-35%", "$59.99", "$38.99")
            )
            "Popüler ve Yakında" -> listOf(
                GameListItem(R.drawable.alters, "The Alters", "Hayatta Kalma", "13 Haz 2025", "-10%", "$17.99", "$16.19"),
                GameListItem(R.drawable.stellarblade, "Stellar Blade™", "Aksiyon, Souls-like", "2 Haz 2025", "", "$59.99", "$59.99"),
                GameListItem(R.drawable.deathstranding, "Death Stranding 2", "Aksiyon, Macera", "30 Oca 2025", "-20%", "$69.99", "$55.99"),
                GameListItem(R.drawable.cyberpunk2077, "Cyberpunk Sequel", "RPG, Aksiyon", "15 Mar 2025", "", "$69.99", "$69.99"),
                GameListItem(R.drawable.witcher, "The Witcher 4", "RPG, Açık Dünya", "20 Haz 2025", "", "$79.99", "$79.99"),
                GameListItem(R.drawable.gow, "God of War Collection", "Aksiyon, Koleksiyon", "10 Şub 2025", "-20%", "$99.99", "$79.99"),
                GameListItem(R.drawable.stardew, "Stardew Valley 2", "Çiftçilik, Simülasyon", "25 Mar 2025", "", "$19.99", "$19.99"),
                GameListItem(R.drawable.pharaoh, "Pharaoh Reborn", "Strateji, Şehir Kurma", "5 Nis 2025", "", "$34.99", "$34.99"),
                GameListItem(R.drawable.deathstranding, "Death Stranding VR", "VR, Macera", "15 Haz 2025", "", "$89.99", "$89.99"),
                GameListItem(R.drawable.cyberpunk2077, "Night City Stories", "RPG, Spin-off", "30 Nis 2025", "", "$39.99", "$39.99")
            )
            "Özel Fırsatlar" -> listOf(
                GameListItem(R.drawable.tlou2, "The Last of Us Part II", "Aksiyon, Macera", "30 Nis 2025", "-90%", "$49.99", "$4.99"),
                GameListItem(R.drawable.witcher, "The Witcher 3", "RPG, Açık Dünya", "18 Oca 2025", "-70%", "$39.99", "$11.99"),
                GameListItem(R.drawable.pharaoh, "Pharaoh", "Strateji, Şehir Kurma", "25 Oca 2025", "-75%", "$24.99", "$6.24"),
                GameListItem(R.drawable.deathstranding, "Death Stranding", "Aksiyon, Macera", "10 Oca 2025", "-60%", "$18.99", "$7.59"),
                GameListItem(R.drawable.stardew, "Stardew Valley", "Çiftçilik, Simülasyon", "12 Oca 2025", "-50%", "$14.99", "$7.49"),
                GameListItem(R.drawable.gow, "God of War", "Aksiyon, Macera", "20 Oca 2025", "-40%", "$49.99", "$29.99"),
                GameListItem(R.drawable.cyberpunk2077, "Cyberpunk 2077", "RPG, Aksiyon", "15 Oca 2025", "-30%", "$59.99", "$41.99"),
                GameListItem(R.drawable.alters, "The Alters", "Hayatta Kalma", "13 Haz 2025", "-10%", "$17.99", "$16.19"),
                GameListItem(R.drawable.cyberpunk2077, "Cyberpunk Bundle", "RPG, Paket", "1 Şub 2025", "-45%", "$89.99", "$49.49"),
                GameListItem(R.drawable.gow, "God of War Bundle", "Aksiyon, Paket", "28 Oca 2025", "-55%", "$129.99", "$58.49"),
                GameListItem(R.drawable.witcher, "Witcher Complete", "RPG, Koleksiyon", "18 Oca 2025", "-80%", "$199.99", "$39.99")
            )
            "Popüler ve Ücretsiz" -> listOf(
                GameListItem(R.drawable.stardew, "Stardew Valley Demo", "Çiftçilik, Demo", "Şimdi", "", "Ücretsiz", "Ücretsiz"),
                GameListItem(R.drawable.cyberpunk2077, "Cyberpunk Trial", "RPG, Deneme", "Şimdi", "", "Ücretsiz", "Ücretsiz"),
                GameListItem(R.drawable.deathstranding, "Death Stranding Prologue", "Aksiyon, Prologue", "Şimdi", "", "Ücretsiz", "Ücretsiz"),
                GameListItem(R.drawable.gow, "God of War Beta", "Aksiyon, Beta", "Şimdi", "", "Ücretsiz", "Ücretsiz"),
                GameListItem(R.drawable.witcher, "Witcher Mini Game", "RPG, Mini Oyun", "Şimdi", "", "Ücretsiz", "Ücretsiz"),
                GameListItem(R.drawable.pharaoh, "Pharaoh Tutorial", "Strateji, Eğitim", "Şimdi", "", "Ücretsiz", "Ücretsiz"),
                GameListItem(R.drawable.alters, "The Alters Preview", "Hayatta Kalma, Önizleme", "Şimdi", "", "Ücretsiz", "Ücretsiz"),
                GameListItem(R.drawable.stellarblade, "Stellar Blade Demo", "Aksiyon, Demo", "Şimdi", "", "Ücretsiz", "Ücretsiz"),
                GameListItem(R.drawable.cyberpunk2077, "Night City Explorer", "Açık Dünya, Ücretsiz", "Şimdi", "", "Ücretsiz", "Ücretsiz"),
                GameListItem(R.drawable.stardew, "Farm Simulator Free", "Simülasyon, Ücretsiz", "Şimdi", "", "Ücretsiz", "Ücretsiz")
            )
            else -> emptyList()
        }
    }
} 