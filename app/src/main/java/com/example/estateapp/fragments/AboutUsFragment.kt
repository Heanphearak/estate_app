package com.example.estateapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.estateapp.R


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
