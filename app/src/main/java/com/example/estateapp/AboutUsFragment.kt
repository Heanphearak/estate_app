package com.example.estateapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.estateapp.PostMapActivity.Companion.mapFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class AboutUsFragment : Fragment() {
//    override fun onMarkerClick(p0: Marker?): Boolean {
//        return false OnMapReadyCallback ,GoogleMap.OnMarkerClickListener
//    }
//
//    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

//         mapFragment = childFragmentManager
//            .findFragmentById(R.id.map_fragment) as? SupportMapFragment
//        mapFragment?.getMapAsync(this)
//        Log.i("map","Error men")

        return inflater.inflate(R.layout.fragment_about_us, container, false)
    }



//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Phnom Penh"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
//    }
}
