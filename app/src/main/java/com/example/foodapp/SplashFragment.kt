package com.example.foodapp

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation

class SplashFragment : Fragment() {

    var timer : CountDownTimer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_splash, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        splashTimer()
    }

    fun splashTimer() {
        timer = object : CountDownTimer(7000, 1000) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {

                view?.let { Navigation.findNavController(it).navigate(R.id.cuisinesFragment) }

                }
            }.start()

        }
    }



