package petrobahia.marketingrequests.ui.activities

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import petrobahia.marketingrequests.R
import petrobahia.marketingrequests.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btreqGraphicPiece.setOnClickListener{
           val intentReqGraphicPiece = Intent(this, GraphicPieceActivity::class.java)
            startActivity (intentReqGraphicPiece)
        }
    }
}