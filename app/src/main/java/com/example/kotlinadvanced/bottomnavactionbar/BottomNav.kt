package com.example.kotlinadvanced.bottomnavactionbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.content.Intent
import android.view.Menu
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlinadvanced.R
import com.example.kotlinadvanced.databinding.ActivityBottomNavBinding
import com.example.kotlinadvanced.navfragments.AlarmFragment
import com.example.kotlinadvanced.navfragments.MiddleButtonActivity
import com.example.kotlinadvanced.navfragments.RecycleViewFragment
import com.example.kotlinadvanced.navfragments.ViewModelFragment
import com.example.kotlinadvanced.navfragments.fragment4
import com.example.kotlinadvanced.tablayoutadapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class BottomNav : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(RecycleViewFragment())

        setSupportActionBar(binding.actionbar2)
        supportActionBar?.title = ""

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        bottomNavigationView.background = null

        bottomNavigationView.menu.getItem(2).isEnabled = false

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.fragment1 -> replaceFragment(RecycleViewFragment())
                R.id.fragment2 -> replaceFragment(AlarmFragment())
                R.id.fragment3 -> replaceFragment(ViewModelFragment())
                R.id.fragment4 -> replaceFragment(fragment4())
                else -> {

                }
            }
            true
        }
        binding.fab.setOnClickListener{
            startActivity(Intent(this, MiddleButtonActivity::class.java))
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}