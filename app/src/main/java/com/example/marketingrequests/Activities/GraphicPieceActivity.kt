package com.example.marketingrequests.Activities

import android.os.Bundle
import android.transition.Scene
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.marketingrequests.R
import com.example.marketingrequests.databinding.ActivityGraphicpieceBinding

class GraphicPieceActivity: AppCompatActivity(){
    private lateinit var binding :ActivityGraphicpieceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.abc_alert_dialog_material)

        binding = DataBindingUtil.setContentView<ActivityGraphicpieceBinding>(this,
            R.layout.activity_graphicpiece)
        setSupportActionBar(findViewById(R.id.toolBarGraphicPieces))
        supportActionBar?.title = null;
    }

    override fun onResume() {
        super.onResume()
    }
}