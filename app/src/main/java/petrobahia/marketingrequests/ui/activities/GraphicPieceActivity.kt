package petrobahia.marketingrequests.ui.activities

import android.animation.LayoutTransition
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getColor
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import petrobahia.marketingrequests.R
import petrobahia.marketingrequests.databinding.ActivityGraphicpieceBinding
import petrobahia.marketingrequests.viewmodel.GraphicPiecesViewModel
import com.google.android.material.bottomappbar.BottomAppBar

class GraphicPieceActivity: AppCompatActivity(){
    private lateinit var binding : ActivityGraphicpieceBinding
    private lateinit var vmodel: GraphicPiecesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.abc_alert_dialog_material)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        binding = DataBindingUtil.setContentView<ActivityGraphicpieceBinding>(this,
            R.layout.activity_graphicpiece)

        setSupportActionBar(binding.toolBarGraphicPieces)

        vmodel = ViewModelProviders.of(this).get(GraphicPiecesViewModel::class.java)

        binding.coordinatorLayout.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        supportActionBar?.title = null

        // Observers

        vmodel.toolbarTitle.observe(this, Observer { textString ->
            this.findViewById<TextView>(R.id.toolbarTitle).setText(textString)
            when(textString){
               getString(R.string.do_requests) -> {
                   binding.rootConstrLayoutActivityGraphicpiece
                       .setBackgroundColor(getColor(this, R.color.white))
               }
               else -> binding.rootConstrLayoutActivityGraphicpiece
                   .setBackgroundColor(getColor(this, R.color.bgPetrobahia))
            }
        })

        vmodel.fFillBottomBartLayout.observe(this, Observer {bool->
            when(bool){
                true -> {
                    val coordLayout:CoordinatorLayout = this.findViewById<CoordinatorLayout>(R.id.coordinatorLayout)
                    var layoutParams = coordLayout.getLayoutParams()
                    layoutParams.height = 100
                    coordLayout.setLayoutParams(layoutParams)
                }
                false-> {
                    val coordLayout:CoordinatorLayout = this.findViewById<CoordinatorLayout>(R.id.coordinatorLayout)
                    var layoutParams = coordLayout.getLayoutParams()
                    layoutParams.height = 0
                    coordLayout.setLayoutParams(layoutParams)
                }
            }
        })

        vmodel.changeToolbarsColors.observe(this, Observer {bool ->
            if(bool){
                this.findViewById<BottomAppBar>(R.id.bottomAppBar_GraphicPieces)
                    .setBackgroundColor(getColor(this, R.color.colorBottomBarSelected))
                this.findViewById<Toolbar>(R.id.toolBarGraphicPieces)
                    .setBackgroundColor(getColor(this, R.color.colorBottomBarSelected))
            }else{
                this.findViewById<BottomAppBar>(R.id.bottomAppBar_GraphicPieces)
                    .setBackgroundColor(getColor(this, R.color.bgPetrobahia))
                this.findViewById<Toolbar>(R.id.toolBarGraphicPieces)
                    .setBackgroundColor(getColor(this, R.color.bgPetrobahia))
            }
        })

        //Listeners

        binding.bottomAppBarBackBtLayoutGraphicPieces.setOnClickListener({
            //procs observer in fragment to unselect all items selected using adapter
            vmodel.setfClearSelectedItems(true)
        })
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
