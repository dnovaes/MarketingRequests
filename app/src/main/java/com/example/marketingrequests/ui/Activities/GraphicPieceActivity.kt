package com.example.marketingrequests.ui.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.marketingrequests.R
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

        supportActionBar?.title = null

    }

    override fun onResume() {
        super.onResume()
    }
}
