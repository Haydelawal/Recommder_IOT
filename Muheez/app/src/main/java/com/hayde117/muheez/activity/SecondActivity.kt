package com.hayde117.muheez.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.hayde117.muheez.FragmentAdaptor
import com.hayde117.muheez.R
import com.hayde117.muheez.databinding.ActivitySecondBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SecondActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adaptor: FragmentAdaptor

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager2 = findViewById(R.id.viewPager)
        adaptor = FragmentAdaptor(supportFragmentManager, lifecycle)
        viewPager2.adapter = adaptor


        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Home"
                    tab.icon = getDrawable(R.drawable.icon_house)
                }
                1 -> {
                    tab.text = "Devices"
                    tab.icon = getDrawable(R.drawable.icon_devices)

                }
                2 -> {
                    tab.text = "Recommend"
                    tab.icon = getDrawable(R.drawable.ic_psychology)

                }
            }
        }.attach()
    }
}