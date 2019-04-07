package com.example.marketingrequests.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.marketingrequests.R

class MainActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro)

    /*
        EditText outCounter = (EditText)findViewById(R.id.out_counter);
        outCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    */

        val btReqGraphicPiece:Button = findViewById(R.id.reqGraphicPiece);
        btReqGraphicPiece.setOnClickListener{
           val intentReqGraphicPiece = Intent(this, GraphicPieceActivity::class.java)
           startActivity (intentReqGraphicPiece)
        }
    }
}