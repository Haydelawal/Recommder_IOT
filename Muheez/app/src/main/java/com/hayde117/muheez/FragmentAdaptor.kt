package com.hayde117.muheez

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hayde117.muheez.fragment.DevicesFragment
import com.hayde117.muheez.fragment.HomeFragment
import com.hayde117.muheez.fragment.RecFragment

class FragmentAdaptor(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeFragment()

            }
            1 -> {
                DevicesFragment()
            }
            2 -> {
                RecFragment()
            }

            else -> {
                HomeFragment()
            }
        }
    }
    }