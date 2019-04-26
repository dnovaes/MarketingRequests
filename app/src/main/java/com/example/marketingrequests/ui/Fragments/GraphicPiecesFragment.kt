package com.example.marketingrequests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.marketingrequests.viewmodel.GraphicPiecesViewModel
import com.example.marketingrequests.databinding.FragmentTypegraphicpieceBinding
import com.google.android.material.bottomappbar.BottomAppBar

class GraphicPiecesFragment: Fragment(){

    private lateinit var vmodel:GraphicPiecesViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val binding: FragmentTypegraphicpieceBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_typegraphicpiece, container, false)

        vmodel = ViewModelProviders.of(this).get(GraphicPiecesViewModel::class.java)
        vmodel.setToolbarTitle(getString(R.string.do_requests))

        val toolbarObserver = Observer<String>{ textString->
            //activity!!.findViewById<TextView>(R.id.toolbarTitle).setText(model.getToolbarTitle())
            activity!!.findViewById<TextView>(R.id.toolbarTitle).setText(textString)
        }
        vmodel.toolbarTitleText.observe(this, toolbarObserver)
        vmodel.bottombarVisibility.observe(this, Observer {  bool ->
            when(bool){
                true -> activity!!.findViewById<BottomAppBar>(R.id.bottomAppBar_GraphicPieces).visibility = VISIBLE
                false -> activity!!.findViewById<BottomAppBar>(R.id.bottomAppBar_GraphicPieces).visibility = INVISIBLE
            }
        })

        binding.btFragmentttypepieceDigitalpiece.setOnClickListener {
            val action = GraphicPiecesFragmentDirections.actionGraphicPieceFragmentToListGraphicPiecesFragment(getString(R.string.digital_piece))
            Navigation.findNavController(it).navigate(action)
            //Navigation.createNavigateOnClickListener(R.id.action_graphicPieceFragment_to_listGraphicPiecesFragment)
            //Navigation.createNavigateOnClickListener(GraphicPieceFragmentDirections.actionGraphicPieceFragmentToListGraphicPiecesFragment("Peças Digitais"))
        }

        binding.btFragmenttypepiecePrintedpiece.setOnClickListener {
            val action = GraphicPiecesFragmentDirections.actionGraphicPieceFragmentToListGraphicPiecesFragment(getString(R.string.printed_piece))
            Navigation.findNavController(it).navigate(action)
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        vmodel.setBottomBarVisibility(false)

        /*
        val rootGroup:ViewGroup = view!!.findViewById(R.id.graphicPieceNavHostFragment)
        scene1 = Scene.getSceneForLayout(rootGroup , R.layout.fragment_typegraphicpiece, activity)
        //scene1?.enter()

        //https://developer.android.com/training/transitions#kotlin (by Code or Resource file)
        //var fadeTransiction: Transition = Fade()
        var fadeGroupTransiction: Transition = TransitionInflater.from(activity).inflateTransition(R.transition.set_bt_typegraphic)
        TransitionManager.go(scene1, fadeGroupTransiction)
        */

    }
}

