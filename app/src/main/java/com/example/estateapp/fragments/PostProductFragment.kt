package com.example.estateapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.estateapp.R


class PostProductFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_post_product,container,false)


        val dropDownTypeEstate = view.findViewById<Button>(R.id.dpdTypeEstate)
        dropDownTypeEstate.setOnClickListener {

            val popupMenu: PopupMenu = PopupMenu(activity,dropDownTypeEstate)

            popupMenu.menuInflater.inflate(R.menu.pop_up_menu_type_estate,popupMenu.menu)

            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.action_rent ->
                        Toast.makeText(activity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_sale ->
                        Toast.makeText(activity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_show_all ->
                        Toast.makeText(activity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                }
                true
            })

            popupMenu.show()

        }


        return view

    }
}