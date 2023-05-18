package com.minhoi.navigationpopex

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController

class OneFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_one, container, false)

        val btn = view.findViewById<Button>(R.id.btn1)
        btn.setOnClickListener {
            it.findNavController().navigate(R.id.action_oneFragment_to_twoFragment)
        }

        return view

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        var firstBackPressedTime : Long = 0
        var SecondBackPressedTime : Long = 0
        var FINISH_INTERVAL_TIME : Long = 3000
        val callback : OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                SecondBackPressedTime = System.currentTimeMillis()
                var intervalTime : Long = SecondBackPressedTime - firstBackPressedTime
                if(0<=intervalTime && intervalTime <= FINISH_INTERVAL_TIME) {
                    activity?.finish()
                } else {
                    Toast.makeText(context, "뒤로가기 버튼을 한번 더 누르면 종료됩니다." , Toast.LENGTH_LONG).show()
                    firstBackPressedTime = SecondBackPressedTime
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(
            this, callback);
        // onAttach 안에 코드를 작성하였기 때문에 this 사용 가능.
    }

}