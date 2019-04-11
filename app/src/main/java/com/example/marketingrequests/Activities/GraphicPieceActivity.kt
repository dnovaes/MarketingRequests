package com.example.marketingrequests.Activities

import android.os.Bundle
import android.transition.Scene
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.marketingrequests.R
import com.example.marketingrequests.databinding.GraphicpiecelayoutBinding

class GraphicPieceActivity: AppCompatActivity(){
    private lateinit var binding :GraphicpiecelayoutBinding
    var scene1:Scene? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.abc_alert_dialog_material)

        binding = DataBindingUtil.setContentView<GraphicpiecelayoutBinding>(this,
            R.layout.graphicpiecelayout)
    }
}