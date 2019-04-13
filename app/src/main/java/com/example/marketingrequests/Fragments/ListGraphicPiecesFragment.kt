package com.example.marketingrequests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class ListGraphicPiecesFragment: Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val args = arguments //receives a Bundle

        val toolbarTitle = args!!.getString("typeGraphicSelected")

        Toast.makeText(context, "Title: ${toolbarTitle}", Toast.LENGTH_LONG).show()

        activity!!.findViewById<TextView>(R.id.toolbarTitle).setText(toolbarTitle)

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}

