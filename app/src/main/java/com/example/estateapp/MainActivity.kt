package com.example.estateapp


import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.estateapp.fragments.AboutUsFragment
import com.example.estateapp.fragments.HistoryFragment
import com.example.estateapp.fragments.HomeFragment
import com.example.estateapp.fragments.RegisterFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val dropDownHouse = findViewById<Button>(R.id.dpdHouse)

//        dropDownHouse.setOnClickListener {
//            showPopUp()
//        }


        dropDownHouse.setOnClickListener {

            val popupMenu: PopupMenu = PopupMenu(this,dropDownHouse)

            popupMenu.menuInflater.inflate(R.menu.pop_up_menu,popupMenu.menu)

            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.action_rent ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_sale ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_show_all ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                }
                true
            })

            popupMenu.show()

        }


        val dropDownVilla = findViewById<Button>(R.id.dpdVilla)
        dropDownVilla.setOnClickListener {

            val popupMenu: PopupMenu = PopupMenu(this,dropDownVilla)

            popupMenu.menuInflater.inflate(R.menu.pop_up_menu,popupMenu.menu)

            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.action_rent ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_sale ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_show_all ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                }
                true
            })


            popupMenu.show()

        }


        val dropDownLand = findViewById<Button>(R.id.dpdLand)
        dropDownLand.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(this,dropDownLand)

            popupMenu.menuInflater.inflate(R.menu.pop_up_menu,popupMenu.menu)

            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.action_rent ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_sale ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_show_all ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                }
                true
            })


            popupMenu.show()
        }


        val dropDownCondo = findViewById<Button>(R.id.dpdCondo)
        dropDownLand.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(this,dropDownCondo)

            popupMenu.menuInflater.inflate(R.menu.pop_up_menu,popupMenu.menu)

            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.action_rent ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_sale ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_show_all ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                }
                true
            })


            popupMenu.show()
        }


        val dropDownBuilding = findViewById<Button>(R.id.dpdBuilding)
        dropDownLand.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(this,dropDownBuilding)

            popupMenu.menuInflater.inflate(R.menu.pop_up_menu,popupMenu.menu)

            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.action_rent ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_sale ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_show_all ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                }
                true
            })

            popupMenu.show()
        }



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
                    val postFragment = RegisterFragment()
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


    private fun showPopUp(){

        val myDialog = Dialog(this)

        myDialog.setContentView(R.layout.custom_popup_menu)


        val window = myDialog.window
        val wlp = window!!.attributes
        window.setGravity(Gravity.LEFT)


        myDialog.show()
    }



    private fun loadFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}
