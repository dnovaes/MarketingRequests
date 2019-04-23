package com.example.marketingrequests.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.marketingrequests.R
import kotlinx.android.synthetic.main.recyclerview_listgraphicpieces_item.view.*

class ListGraphicPiecesAdapter(private val myDataset: Array<String>) :
    RecyclerView.Adapter<ListGraphicPiecesAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val layoutHolder: ConstraintLayout) : RecyclerView.ViewHolder(layoutHolder)


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ListGraphicPiecesAdapter.MyViewHolder {
        // create a new view
        val layoutHolder= LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_listgraphicpieces_item, parent, false) as ConstraintLayout
        // set the view's size, margins, paddings and layout parameters
        //...
        return MyViewHolder(layoutHolder)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.layoutHolder.item_text_listgraphicpieces.text = myDataset[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}
