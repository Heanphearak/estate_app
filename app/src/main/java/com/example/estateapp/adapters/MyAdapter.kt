package com.example.estateapp.adapters

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.estateapp.fragments.AboutUsFragment
import com.example.estateapp.fragments.HistoryFragment
import com.example.estateapp.fragments.HomeFragment
import com.example.estateapp.fragments.RegisterFragment

class MyAdapter(private val myContext: Context, fm: FragmentManager,internal var totalTabs: Int) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                //val homeFragment: HomeFragment = HomeFragment()
                Log.i("fragment0","hello")

                return HomeFragment()
            }
            1 -> {
                Log.i("fragment1","hello1")
                return RegisterFragment()
            }
            2 -> {
                // val movieFragment = MovieFragment()
                Log.i("fragment2","hello2")
                return HistoryFragment()
            }
            else ->{
                Log.i("fragment3","hello3")
                return AboutUsFragment()
            }
           // else -> return null
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}