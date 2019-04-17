package com.example.marketingrequests.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.marketingrequests.R
import com.example.marketingrequests.ViewModel.GraphicPiecesViewModel
import com.example.marketingrequests.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(GraphicPiecesViewModel::class.java)

        binding.title = model.getTitle()

        binding.btreqGraphicPiece.setOnClickListener{
           val intentReqGraphicPiece = Intent(this, GraphicPieceActivity::class.java)
            startActivity (intentReqGraphicPiece)
        }
    }
}