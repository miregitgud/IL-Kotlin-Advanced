package com.example.kotlinadvanced.tablayoutadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlinadvanced.navfragments.AlarmFragment
import com.example.kotlinadvanced.navfragments.RecycleViewFragment
import com.example.kotlinadvanced.navfragments.ViewModelFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> RecycleViewFragment()
            1 -> AlarmFragment()
            2 -> ViewModelFragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}
