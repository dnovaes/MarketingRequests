package com.example.marketingrequests.ui.Activities

import android.animation.LayoutTransition
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.marketingrequests.R
import com.example.marketingrequests.databinding.ActivityGraphicpieceBinding
import com.google.android.material.bottomappbar.BottomAppBar

class GraphicPieceActivity: AppCompatActivity(){
    private lateinit var binding :ActivityGraphicpieceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.abc_alert_dialog_material)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        binding = DataBindingUtil.setContentView<ActivityGraphicpieceBinding>(this,
            R.layout.activity_graphicpiece)
        setSupportActionBar(binding.toolBarGraphicPieces)

        binding.coordinatorLayout.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        supportActionBar?.title = null

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //val inflater = menuInflater
        //inflater.inflate(R.menu.bottomappbar_menu, menu)
        binding.bottomAppBarGraphicPieces.inflateMenu(R.menu.bottomappbar_menu)
        return true
    }

    override fun onResume() {
        super.onResume()
    }
}
