package petrobahia.marketingrequests.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import petrobahia.marketingrequests.R
import petrobahia.marketingrequests.viewmodel.GraphicPiecesViewModel
import petrobahia.marketingrequests.databinding.FragmentListgraphicpiecesBinding
import petrobahia.marketingrequests.ui.adapters.ListGraphicPiecesAdapter
import petrobahia.marketingrequests.ui.adapters.onGraphicPieceListener
import kotlinx.android.synthetic.main.recyclerview_listgraphicpieces_item.view.*
import petrobahia.marketingrequests.model.GraphicPiece
import petrobahia.marketingrequests.model.GraphicPieceList
import petrobahia.marketingrequests.util.`interface`.JsonMarketingRequestsAPI
import petrobahia.marketingrequests.util.network.RetrofitMarketingRequests
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListGraphicPiecesFragment: Fragment(), onGraphicPieceListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    //private var arrayItems:Array<String> = arrayOf("Email Marketing", "Imagem Whatsapp", "Apresentaçao PPT", "Avatar Whatsapp", "Video Comemorativo", "Test1", "Test2", "Test3", "Test4", "Test5", "Test6", "Test7")
    private lateinit var vmodel: GraphicPiecesViewModel
    private lateinit var binding: FragmentListgraphicpiecesBinding
    private lateinit var itemsSelected: ArrayList<ConstraintLayout>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_listgraphicpieces, container, false)

        vmodel = ViewModelProviders.of(this.activity as FragmentActivity).get(GraphicPiecesViewModel::class.java)
        //vmodel = ViewModelProviders.of(this).get(GraphicPiecesViewModel::class.java)

        viewManager = LinearLayoutManager(this.activity)

        //observing Livedata toolbartitle
        val args = arguments //receives a Bundle
        var graphicTypeText:String = args?.getString("typeGraphicSelected") as String

        vmodel.setToolbarTitle(graphicTypeText)
        vmodel.setfGetGraphicPiecesByType(true)

        val pBMarketingRequestsApi: JsonMarketingRequestsAPI = RetrofitMarketingRequests.getRetrofitInstance().create(JsonMarketingRequestsAPI::class.java)
        vmodel.fGetGraphicPiecesByType.observe(this, Observer{

            var call:Call<GraphicPieceList>? = when(graphicTypeText){
                getString(R.string.digital_piece) -> pBMarketingRequestsApi.getDigitalGraphicPiecesData()
                getString(R.string.printed_piece) -> pBMarketingRequestsApi.getPrintedGraphicPiecesData()
                else -> {
                    Log.e("fGetGraphicPiecesByType", "entered null in observer of fGetGraphicPiecesByType when '$graphicTypeText'")
                    null
                }
            }

            call?.enqueue(object: Callback<GraphicPieceList>{

                override fun onFailure(call: Call<GraphicPieceList>, t: Throwable) {
                    t.cause
                    Log.v("RETROFIT FAILURE", t.message)
                    return
                }

                override fun onResponse(call: Call<GraphicPieceList>, response: Response<GraphicPieceList>) {
                    Log.v("RETROFIT onRESPONSE", "Code: ${response.code()}") //To change body of created functions use File | Settings | File Templates.
                    if(!response.isSuccessful){
                        Log.e("RETROFIT RESPONSE FAIL", "didnt work :(\n Code: ${response.code()}") //To change body of created functions use File | Settings | File Templates.
                        return
                    }
                    var graphicPieceArrayList: ArrayList<GraphicPiece> = response.body()!!.getGraphicPieceArrayList()

                    viewAdapter = ListGraphicPiecesAdapter(graphicPieceArrayList, this@ListGraphicPiecesFragment)

                    recyclerView = binding.recyclerViewListGraphicPieces.apply{
                        setHasFixedSize(true)
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }
                    binding.progressBarFragmentListgraphicpieces.visibility = View.GONE
                    /*
                    for(item: GraphicPiece in graphicPieceArrayList) {
                        Log.v(
                            "RETROFIT RESPONSE",
                            item.getTitle()
                        ) //To change body of created functions use File | Settings | File Templates.
                    }*/

                }
            })

        })

        vmodel.selecedtItemList.observe(this, Observer{
            //mark item as selected and checkbox checked
            it.item_checkbox_listgraphicpieces.isChecked = !it.item_checkbox_listgraphicpieces.isChecked
            it.item_recyclerView_listgraphicpieces.isSelected = !it.item_recyclerView_listgraphicpieces.isSelected

            var numberSelectedItems = vmodel.getNumberItemsSelected() as Int

            if(it.item_recyclerView_listgraphicpieces.isSelected){
                numberSelectedItems+=1
                vmodel.setNumberItemsSelected(numberSelectedItems)
            }else {
                numberSelectedItems-=1
                vmodel.setNumberItemsSelected(numberSelectedItems)
            }

            //update visual number selected in bottomAppBar
            activity!!.findViewById<TextView>(R.id.bottomAppBar_numberSelected_GraphicPieces).text = numberSelectedItems.toString()

            if(numberSelectedItems == 0){
                //reset values to default
                vmodel.setDefaultValues()
            }else{
                vmodel.setChangeToolbarsColors(true)
                vmodel.setfFillBottomBartLayout(true)
            }
        })

        vmodel.fClearSelectedItems.observe(this, Observer{
            for (item in itemsSelected.iterator()){
                item.item_recyclerView_listgraphicpieces.isSelected = false
                item.item_checkbox_listgraphicpieces.isChecked = false
            }
            itemsSelected.clear()
            vmodel.setDefaultValues()
        })


        //return super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onClickItemList(layout:ConstraintLayout, itemsSelected: ArrayList<ConstraintLayout>) {
        //var view:View = viewManager.findViewByPosition(pos) as View
        //var color:String = String.format("%06x", ContextCompat.getColor(activity!!, R.color.colorSelectedItem) and 0xffffff)
        //var colorInt: Int = color.toInt(16)
        //Log.v("colortest", "pos $pos | $colorInt "+0x425363)
        //view.isSelected = !view.isSelected
        this.itemsSelected = itemsSelected

        vmodel.setSelectedItemList(layout)
    }
}

