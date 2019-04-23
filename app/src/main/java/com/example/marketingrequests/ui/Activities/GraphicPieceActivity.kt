package com.example.marketingrequests.ui.Activities

import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.marketingrequests.R
import com.example.marketingrequests.viewmodel.GraphicPiecesViewModel
import com.example.marketingrequests.databinding.ActivityGraphicpieceBinding
import com.google.android.material.bottomappbar.BottomAppBar
import kotlinx.android.synthetic.main.activity_graphicpiece.*

class GraphicPieceActivity: AppCompatActivity(){
    private lateinit var binding :ActivityGraphicpieceBinding
    private lateinit var vmodel: GraphicPiecesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.abc_alert_dialog_material)

        binding = DataBindingUtil.setContentView<ActivityGraphicpieceBinding>(this,
            R.layout.activity_graphicpiece)
        setSupportActionBar(toolBarGraphicPieces)

        vmodel = ViewModelProviders.of(this).get(GraphicPiecesViewModel::class.java)
        vmodel.setToolbarTitle(getString(R.string.graphical_pieces))
        vmodel.setBottomBarVisibility(false)

        vmodel.bottombarVisibility.observe(this, Observer { bool ->
            when(bool){
                true -> this.findViewById<BottomAppBar>(R.id.bottomAppBar_GraphicPieces).visibility = VISIBLE
                false -> this.findViewById<BottomAppBar>(R.id.bottomAppBar_GraphicPieces).visibility = INVISIBLE
            }
        })
        supportActionBar?.title = null;

    }

    override fun onResume() {
        super.onResume()
    }
}
