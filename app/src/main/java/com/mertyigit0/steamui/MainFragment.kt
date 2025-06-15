package com.mertyigit0.steamui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    private lateinit var gameRecyclerView: RecyclerView
    private lateinit var gameAdapter: GameAdapter
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var leftArrow: ImageView
    private lateinit var rightArrow: ImageView
    private lateinit var tabsPagerAdapter: TabsPagerAdapter

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
        setupTabLayoutWithViewPager(view)
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

    private fun setupTabLayoutWithViewPager(view: View) {
        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager = view.findViewById(R.id.viewPager)
        leftArrow = view.findViewById(R.id.ivLeftArrow)
        rightArrow = view.findViewById(R.id.ivRightArrow)

        // ViewPager2 adapter setup
        tabsPagerAdapter = TabsPagerAdapter(requireActivity())
        viewPager.adapter = tabsPagerAdapter

        // TabLayout ile ViewPager2'yi bağla
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabsPagerAdapter.getTabTitle(position)
        }.attach()

        // Ok butonları click listeners
        leftArrow.setOnClickListener {
            tabLayout.setScrollPosition(0, 0f, true)
            updateArrowVisibility()
        }

        rightArrow.setOnClickListener {
            val lastTabIndex = tabLayout.tabCount - 1
            tabLayout.setScrollPosition(lastTabIndex, 0f, true)
            updateArrowVisibility()
        }

        // TabLayout scroll değişikliklerini dinle
        tabLayout.addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
            updateArrowVisibility()
        }

        // İlk durumda ok görünürlüğünü ayarla
        view.post {
            updateArrowVisibility()
        }
    }

    private fun updateArrowVisibility() {
        val canScrollHorizontally = tabLayout.canScrollHorizontally(1) || tabLayout.canScrollHorizontally(-1)
        
        if (canScrollHorizontally) {
            // Sola kaydırılabilir mi kontrol et
            val canScrollLeft = tabLayout.canScrollHorizontally(-1)
            leftArrow.visibility = if (canScrollLeft) View.VISIBLE else View.GONE
            
            // Sağa kaydırılabilir mi kontrol et  
            val canScrollRight = tabLayout.canScrollHorizontally(1)
            rightArrow.visibility = if (canScrollRight) View.VISIBLE else View.GONE
        } else {
            // Kaydırma gerekmiyorsa her iki oku da gizle
            leftArrow.visibility = View.GONE
            rightArrow.visibility = View.GONE
        }
    }
}