package com.example.marketingrequests.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.marketingrequests.R
import com.example.marketingrequests.Title
import com.example.marketingrequests.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    private val title: Title = Title("Requisitar Peças Gr\u00E1ficas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.title = title
        /*
            binding.apply{
                binding.names
                binding.invalidateAll()
            }
         */
        binding.btreqGraphicPiece.setOnClickListener{
           val intentReqGraphicPiece = Intent(this, GraphicPieceActivity::class.java)
            startActivity (intentReqGraphicPiece)
        }
    }
}