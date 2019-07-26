package com.example.estateapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.estateapp.models.EstateData
import com.example.estateapp.R

class Adapter (val estateDataList: ArrayList<EstateData>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_estate,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return estateDataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val estate: EstateData = estateDataList[position]

        holder.price.text = estate.price.toString()
        holder.homeSize.text = estate.homeSize
        holder.bedroom.text = estate.bedroom.toString()
        holder.bathroom.text = estate.bathroom.toString()
        holder.location.text = estate.location
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageHouse = itemView.findViewById(R.id.imageHome) as ImageView
        val price = itemView.findViewById(R.id.price) as TextView
        val homeSize = itemView.findViewById(R.id.sizeHouse) as TextView
        val bedroom = itemView.findViewById(R.id.numberOfBedroom) as  TextView
        val bathroom = itemView.findViewById(R.id.numberOfBathroom) as TextView
        val location = itemView.findViewById(R.id.location) as TextView
    }
}