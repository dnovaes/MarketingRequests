package com.example.marketingrequests.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat.getColor
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marketingrequests.R
import com.example.marketingrequests.viewmodel.GraphicPiecesViewModel
import com.example.marketingrequests.databinding.FragmentListgraphicpiecesBinding
import com.example.marketingrequests.ui.adapters.ListGraphicPiecesAdapter
import com.example.marketingrequests.ui.adapters.onGraphicPieceListener
import com.google.android.material.bottomappbar.BottomAppBar
import kotlinx.android.synthetic.main.recyclerview_listgraphicpieces_item.view.*


class ListGraphicPiecesFragment: Fragment(), onGraphicPieceListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var arrayItems:Array<String> = arrayOf("Email Marketing",
        "Imagem Whatsapp", "Apresentaçao PPT", "Avatar Whatsapp", "Video Comemorativo", "Test1", "Test2", "Test3", "Test4", "Test5", "Test6", "Test7")
    private lateinit var vmodel: GraphicPiecesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentListgraphicpiecesBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_listgraphicpieces, container, false)

        vmodel = ViewModelProviders.of(this).get(GraphicPiecesViewModel::class.java)

        viewManager = LinearLayoutManager(this.activity)
        viewAdapter = ListGraphicPiecesAdapter(arrayItems, this)

        recyclerView = binding.recyclerViewListGraphicPieces.apply{
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }

        //observing Livedata toolbartitle
        val args = arguments //receives a Bundle

        vmodel.setToolbarTitle(args?.getString("typeGraphicSelected") as String)

        vmodel.toolbarTitleText.observe(this, Observer { textString ->
            activity!!.findViewById<TextView>(R.id.toolbarTitle).setText(textString)
        })

        vmodel.fFillBottomBartLayout.observe(this, Observer {bool->
            when(bool){
                true -> {
                    val coordLayout:CoordinatorLayout = activity!!.findViewById<CoordinatorLayout>(R.id.coordinatorLayout)
                    var layoutParams = coordLayout.getLayoutParams()
                    layoutParams.height = 100
                    coordLayout.setLayoutParams(layoutParams)
                }
                false-> {
                    val coordLayout:CoordinatorLayout = activity!!.findViewById<CoordinatorLayout>(R.id.coordinatorLayout)
                    coordLayout.layoutParams.height = 0
                }
            }
        })

        vmodel.selecedtItemList.observe(this, Observer{
            //mark item as selected and checkbox checked
            it.item_checkbox_listgraphicpieces.isChecked = !it.item_checkbox_listgraphicpieces.isChecked
            it.item_recyclerView_listgraphicpieces.isSelected = !it.item_recyclerView_listgraphicpieces.isSelected
            //update number in bottomAppBar
            var num = vmodel.getNumberItemsSelected()
            activity!!.findViewById<TextView>(R.id.bottomAppBar_numberSelected_GraphicPieces).text = num.toString()
        })

        vmodel.changeToolbarsColors.observe(this, Observer {bool ->
            if(bool){
                activity!!.findViewById<BottomAppBar>(R.id.bottomAppBar_GraphicPieces)
                    .setBackgroundColor(getColor(this.context as Context, R.color.colorBottomBarSelected))
                activity!!.findViewById<Toolbar>(R.id.toolBarGraphicPieces)
                    .setBackgroundColor(getColor(this.context as Context, R.color.colorBottomBarSelected))
            }else{
                activity!!.findViewById<BottomAppBar>(R.id.bottomAppBar_GraphicPieces)
                    .setBackgroundColor(getColor(this.context as Context, R.color.bgPetrobahia))
                activity!!.findViewById<Toolbar>(R.id.toolBarGraphicPieces)
                    .setBackgroundColor(getColor(this.context as Context, R.color.bgPetrobahia))
            }
        })

        //return super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onClickItemList(layout:ConstraintLayout) {
        //var view:View = viewManager.findViewByPosition(pos) as View
        //var color:String = String.format("%06x", ContextCompat.getColor(activity!!, R.color.colorSelectedItem) and 0xffffff)
        //var colorInt: Int = color.toInt(16)
        //Log.v("colortest", "pos $pos | $colorInt "+0x425363)
        //view.isSelected = !view.isSelected

        var numberSelectedItems = vmodel.getNumberItemsSelected() as Int
        if(layout.item_recyclerView_listgraphicpieces.isSelected){
            vmodel.setNumberItemsSelected(numberSelectedItems-1)
        }else{
            vmodel.setNumberItemsSelected(numberSelectedItems+1)
        }

        if(vmodel.getNumberItemsSelected() as Int > 0){
            vmodel.setChangeToolbarsColors(true)
            //change height of layout to leave space to bottomBar
            vmodel.setfFillBottomBartLayout(true)
        }else{
            vmodel.setChangeToolbarsColors(false)
            //change height to fill the empty space of bottomBar
            vmodel.setfFillBottomBartLayout(false)
        }
        //proc the observer to change elements in layout
        vmodel.setSelectedItemList(layout)
    }
}

