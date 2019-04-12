package com.example.marketingrequests

import android.os.Bundle
import android.transition.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.marketingrequests.databinding.FragmentTypegraphicpieceBinding

class GraphicPieceFragment: Fragment(){

    //private var scene1: Scene? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val binding: FragmentTypegraphicpieceBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_typegraphicpiece, container, false)

        binding.btDigitalPiece.setOnClickListener(
           //v.findNavController().navigate(R.id.action_graphicPieceFragment_to_listGraphicPiecesFragment)
            Navigation.createNavigateOnClickListener(R.id.action_graphicPieceFragment_to_listGraphicPiecesFragment)
        )

        binding.btPrintedPiece.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_graphicPieceFragment_to_listGraphicPiecesFragment)
        )
        return binding.root
    }

    override fun onResume() {
        super.onResume()

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

