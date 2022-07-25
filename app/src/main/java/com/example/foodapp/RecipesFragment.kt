package com.example.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.navigation.navOptions

class RecipesFragment : Fragment() {

    private val args: RecipesFragmentArgs by navArgs()
    private val options = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }

    private var columnCount = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.recipe_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                if (args.cuisineId == "African") {
                    adapter = RecipesRecyclerViewAdapter(AfricanRecipes.recipeList, ::onRecipeClick)
                } else if (args.cuisineId == "American") {
                    adapter =
                        RecipesRecyclerViewAdapter(AmericanRecipes.recipeList, ::onRecipeClick)
                }

            }
        }
        return view
    }

    private fun onRecipeClick(id: Int) {

        val action = RecipesFragmentDirections.actionRecipesFragmentToRecipeDetail(id)
        view?.let { Navigation.findNavController(it).navigate(action, options) }

    }

}