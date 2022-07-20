package com.example.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.foodapp.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class RecipesFragment : Fragment() {

    val args: RecipesFragmentArgs by navArgs()

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

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
                if(args.cuisineId == "African"){
                adapter = RecipesRecyclerViewAdapter(AfricanRecipes.recipeList,::onRecipeClick)
                }else if(args.cuisineId == "American"){
                    adapter = RecipesRecyclerViewAdapter(AmericanRecipes.recipeList, ::onRecipeClick)
                }

            }
        }
        return view
    }

    private fun onRecipeClick(id:Int){

        val action = RecipesFragmentDirections.actionRecipesFragmentToRecipeDetail(id.toString())
        view?.let{ Navigation.findNavController(it).navigate(action)}


    }


    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            RecipesFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}