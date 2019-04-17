package com.example.marketingrequests.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.marketingrequests.R
import com.example.marketingrequests.ViewModel.GraphicPiecesViewModel
import com.example.marketingrequests.databinding.ActivityGraphicpieceBinding
import kotlinx.android.synthetic.main.activity_graphicpiece.*

class GraphicPieceActivity: AppCompatActivity(){
    private lateinit var binding :ActivityGraphicpieceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.abc_alert_dialog_material)

        binding = DataBindingUtil.setContentView<ActivityGraphicpieceBinding>(this,
            R.layout.activity_graphicpiece)
        setSupportActionBar(toolBarGraphicPieces)

        var model = ViewModelProviders.of(this).get(GraphicPiecesViewModel::class.java)
        model.setToolbarTitle(getString(R.string.graphical_pieces))
        supportActionBar?.title = null;
    }

    override fun onResume() {
        super.onResume()
    }
}