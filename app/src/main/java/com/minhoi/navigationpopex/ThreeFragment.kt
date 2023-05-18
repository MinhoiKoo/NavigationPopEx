package com.minhoi.navigationpopex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class ThreeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_three, container, false)

        val btn = view.findViewById<Button>(R.id.button3)
        btn.setOnClickListener {
            it.findNavController().navigate(R.id.action_threeFragment_to_oneFragment)
        }
        return view
    }

}