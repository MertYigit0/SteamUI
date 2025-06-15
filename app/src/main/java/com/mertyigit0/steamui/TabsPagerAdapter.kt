package com.mertyigit0.steamui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabsPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val tabTitles = listOf(
        "Yeni Popüler",
        "Çok Satanlar", 
        "Popüler ve Yakında",
        "Özel Fırsatlar",
        "Popüler ve Ücretsiz"
    )

    override fun getItemCount(): Int = tabTitles.size

    override fun createFragment(position: Int): Fragment {
        return GameListFragment.newInstance(tabTitles[position])
    }

    fun getTabTitle(position: Int): String {
        return tabTitles[position]
    }
} 