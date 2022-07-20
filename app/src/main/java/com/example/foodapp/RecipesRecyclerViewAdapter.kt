package com.example.foodapp

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.foodapp.placeholder.PlaceholderContent.PlaceholderItem
import com.example.foodapp.databinding.RecipeItemBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class RecipesRecyclerViewAdapter(
    private val values: List<Recipe>,
    val onItemClick: (id:Int) -> Unit
) : RecyclerView.Adapter<RecipesRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            RecipeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = values[position]
        holder.name.text = recipe.name
        holder.image.setImageResource(recipe.image)
        holder.itemView.setOnClickListener{
            onItemClick(recipe.id)
        }

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: RecipeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val name: TextView = binding.recipeName
        val image: ImageView = binding.recipeImage


    }

}