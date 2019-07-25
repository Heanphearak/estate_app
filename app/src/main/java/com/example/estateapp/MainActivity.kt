package com.example.estateapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.nav_home -> {
                    println("home pressed")

                    val homeFragment = HomeFragment()// initialize fragment
                    loadFragment(homeFragment) // load fragment when user click on navigation home

                    return@OnNavigationItemSelectedListener true
                }

                R.id.nav_post -> {
                    println("post pressed")
                    val postFragment = PostRegisterFragment()
                    loadFragment(postFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.nav_history -> {
                    println("history pressed")
                    val historyFragment = HistoryFragment()
                    loadFragment(historyFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.nav_about_us -> {
                    println("about us pressed")
                    val aboutUsFragment = AboutUsFragment()
                    loadFragment(aboutUsFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false

        }


        bottom_nav_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }



    private fun loadFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}
