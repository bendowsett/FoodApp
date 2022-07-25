package com.example.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.foodapp.databinding.FragmentRecipeDetailBinding


class RecipeDetail : Fragment() {

    private val args: RecipeDetailArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)

        val recipe = AllRecipeDetails.allRecipeDetails.find { it.id == args.recipeId }
        binding.recipeIngredients.text = recipe?.ingredients ?: ""
        binding.recipeName.text = recipe?.name ?: ""
        if (recipe != null) {
            binding.recipeImage.setImageResource(recipe.image)
        }
        binding.recipeInstructions.text = recipe?.instructions ?: ""

        return binding.root

    }


}