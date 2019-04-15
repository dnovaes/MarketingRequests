package com.example.marketingrequests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.marketingrequests.databinding.FragmentListgraphicpiecesBinding

class ListGraphicPiecesFragment: Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentListgraphicpiecesBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_listgraphicpieces, container, false)

        val args = arguments //receives a Bundle

        val toolbarTitle = args!!.getString("typeGraphicSelected")
        Toast.makeText(context, "Title: ${toolbarTitle}", Toast.LENGTH_SHORT).show()

        activity!!.findViewById<TextView>(R.id.toolbarTitle).setText(toolbarTitle)

        //return super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }
}

