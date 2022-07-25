package com.example.foodapp

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView


import com.example.foodapp.databinding.CuisineItemBinding
import com.example.foodapp.models.Cuisine

class CuisinesRecyclerViewAdapter(
    private val values: List<Cuisine>,
    val onItemClick: (id: String) -> Unit
) : RecyclerView.Adapter<CuisinesRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            CuisineItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.name
        holder.idView.setOnClickListener {
            onItemClick(item.name)
        }

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: CuisineItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber


    }

}