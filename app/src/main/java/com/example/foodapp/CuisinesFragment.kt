package com.example.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions


/**
 * A fragment representing a list of Items.
 */
class CuisinesFragment : Fragment() {

    private var columnCount = 1
    private val options = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.cuisine_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = CuisinesRecyclerViewAdapter(CuisineList.cuisineList, ::onCuisineClick)
            }
        }
        return view
    }

    private fun onCuisineClick(id: String) {

        val action = CuisinesFragmentDirections.actionCuisinesFragmentToRecipesFragment(id)
        findNavController().navigate(action, options)

    }

}