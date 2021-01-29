package com.example.simplepostapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment1 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.fragment1, container, false)
        return rootView
    }
}