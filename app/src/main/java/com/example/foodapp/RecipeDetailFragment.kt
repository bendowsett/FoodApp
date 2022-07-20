package com.example.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.foodapp.databinding.FragmentRecipeDetailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



class RecipeDetail : Fragment() {

    val args: RecipeDetailArgs by navArgs()
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_recipe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        var recipe = AllRecipeDetails.allRecipeDetails[args.recipeId.toInt()-1]

        //Toast.makeText(context, "${recipe}", Toast.LENGTH_LONG ).show()

        var ingredients = view?.findViewById<TextView>(R.id.recipeIngredients)
        ingredients?.text = recipe.ingredients

        var recipeName = view?.findViewById<TextView>(R.id.recipeName)
        recipeName?.text = recipe.name

        var recipeImage = view?.findViewById<ImageView>(R.id.recipeImage)
        recipeImage?.setImageResource(recipe.image)

        var recipeInstructions = view?.findViewById<TextView>(R.id.recipeInstructions)
        recipeInstructions?.text = recipe.instructions

    }


}