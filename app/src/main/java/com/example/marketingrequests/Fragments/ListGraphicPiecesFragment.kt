package com.example.marketingrequests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class ListGraphicPiecesFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val args = arguments //receives a Bundle

        Toast.makeText(context, "Title: ${args!!.getString("typeGraphicSelected")}", Toast.LENGTH_LONG).show()

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}

