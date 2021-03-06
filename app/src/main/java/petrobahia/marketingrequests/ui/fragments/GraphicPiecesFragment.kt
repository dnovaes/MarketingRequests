package petrobahia.marketingrequests.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import petrobahia.marketingrequests.R
import petrobahia.marketingrequests.viewmodel.GraphicPiecesViewModel
import petrobahia.marketingrequests.databinding.FragmentTypegraphicpieceBinding
import petrobahia.marketingrequests.ui.fragments.GraphicPiecesFragmentDirections

class GraphicPiecesFragment: Fragment(){

    private lateinit var vmodel: GraphicPiecesViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val binding: FragmentTypegraphicpieceBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_typegraphicpiece, container, false)

        vmodel = ViewModelProviders.of(this.activity as FragmentActivity).get(GraphicPiecesViewModel::class.java)
        vmodel.setToolbarTitle(getString(R.string.do_requests))

        //reset values of vmodel to default
        vmodel.setDefaultValues()

        binding.btFragmentttypepieceDigitalpiece.setOnClickListener {
            val action =
                GraphicPiecesFragmentDirections.actionGraphicPieceFragmentToListGraphicPiecesFragment(
                    getString(R.string.digital_piece)
                )
            Navigation.findNavController(it).navigate(action)
            //Navigation.createNavigateOnClickListener(R.id.action_graphicPieceFragment_to_listGraphicPiecesFragment)
            //Navigation.createNavigateOnClickListener(GraphicPieceFragmentDirections.actionGraphicPieceFragmentToListGraphicPiecesFragment("Peças Digitais"))
        }

        binding.btFragmenttypepiecePrintedpiece.setOnClickListener {
            val action =
                GraphicPiecesFragmentDirections.actionGraphicPieceFragmentToListGraphicPiecesFragment(
                    getString(R.string.printed_piece)
                )
            Navigation.findNavController(it).navigate(action)
        }
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

