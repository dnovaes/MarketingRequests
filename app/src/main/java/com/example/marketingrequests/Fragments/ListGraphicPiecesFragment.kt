package com.example.marketingrequests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.marketingrequests.ViewModel.GraphicPiecesViewModel
import com.example.marketingrequests.databinding.FragmentListgraphicpiecesBinding
import kotlinx.android.synthetic.main.activity_graphicpiece.*
import kotlinx.android.synthetic.main.activity_graphicpiece.view.*

class ListGraphicPiecesFragment: Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentListgraphicpiecesBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_listgraphicpieces, container, false)

        val args = arguments //receives a Bundle

        var model = ViewModelProviders.of(this).get(GraphicPiecesViewModel::class.java)
        model.setToolbarTitle(args!!.getString("typeGraphicSelected"))

        model.toolbarTitleText.observe(this, Observer { textString ->
            activity!!.findViewById<TextView>(R.id.toolbarTitle).setText(textString)
            Toast.makeText(context, "Title: ${textString}", Toast.LENGTH_SHORT).show()
        })

        //return super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }
}

