package com.example.marketingrequests

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marketingrequests.viewmodel.GraphicPiecesViewModel
import com.example.marketingrequests.databinding.FragmentListgraphicpiecesBinding
import com.example.marketingrequests.ui.adapters.ListGraphicPiecesAdapter
import com.example.marketingrequests.ui.adapters.ListGraphicPiecesAdapter.onGraphicPieceListener
import com.google.android.material.bottomappbar.BottomAppBar



class ListGraphicPiecesFragment: Fragment(), onGraphicPieceListener{

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var arrayItems:Array<String> = arrayOf("Email Marketing",
        "Imagem Whatsapp", "Apresentaçao PPT", "Avatar Whatsapp", "Video Comemorativo", "Test1", "Test2", "Test3", "Test4", "Test5", "Test6", "Test7")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentListgraphicpiecesBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_listgraphicpieces, container, false)

        viewManager = LinearLayoutManager(this.activity)
        viewAdapter = ListGraphicPiecesAdapter(arrayItems, this)

        recyclerView = binding.recyclerViewListGraphicPieces.apply{
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }

        //observing Livedata toolbartitle
        val args = arguments //receives a Bundle

        var vmodel = ViewModelProviders.of(this).get(GraphicPiecesViewModel::class.java)
        vmodel.setToolbarTitle(args!!.getString("typeGraphicSelected"))
        vmodel.setBottomBarVisibility(true)

        vmodel.toolbarTitleText.observe(this, Observer { textString ->
            activity!!.findViewById<TextView>(R.id.toolbarTitle).setText(textString)
        })

        vmodel.bottombarVisibility.observe(this, Observer { bool ->
            when(bool){
                true -> activity!!.findViewById<BottomAppBar>(R.id.bottomAppBar_GraphicPieces).visibility = VISIBLE
                false -> activity!!.findViewById<BottomAppBar>(R.id.bottomAppBar_GraphicPieces).visibility = INVISIBLE
            }
        })

        //return super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onClick(pos: Int) {
        var view:View = viewManager.findViewByPosition(pos) as View
        var color:String = String.format("%06x", ContextCompat.getColor(activity!!, R.color.colorSelectedItem) and 0xffffff)
        var colorInt: Int = color.toInt(16)
        Log.v("colortest", "pos $pos | $colorInt "+0x425363)

        //view.setBackgroundResource(int)
        view.setBackgroundColor(colorInt)
    }
}

