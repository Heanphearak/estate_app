package com.example.estateapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.estateapp.R
import kotlinx.android.synthetic.main.fragment_login.*




class LoginFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login,container,false)


        back_to_register.setOnClickListener {
            val fragment = RegisterFragment()
            loadFragment(fragment)
        }

        val backToRegister = view.findViewById(R.id.back_to_register) as TextView

        backToRegister.setOnClickListener {

            val fragment = RegisterFragment()
            loadFragment(fragment)
        }


        val btnLogin = view.findViewById(R.id.btn_login) as Button

        btnLogin.setOnClickListener {
            val fragment = PostProductFragment()
            loadFragment(fragment)
        }

        return view
    }




    private fun loadFragment(fragment: Fragment){
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}