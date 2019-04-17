package com.example.marketingrequests.ViewModel

import androidx.lifecycle.ViewModel
import com.example.marketingrequests.GraphicPiecesFragment
import com.example.marketingrequests.ListGraphicPiecesFragment
import com.example.marketingrequests.Title

class GraphicPiecesViewModel: ViewModel() {
    // Create a LiveData with a String
    private var toolbarTitleText: String = "Peças Gr�ficas"
    private var argsTypeSelected: String = ""

    private val title: Title = Title("Requisitar Peças Gr\u00E1ficas")

    fun setToolbarTitle(toolbarTitle:String){
        this.toolbarTitleText = toolbarTitle
    }

    fun getToolbarTitle() = toolbarTitleText

    fun setArgsTypeSelected(argsTypeSelected:String){
        this.argsTypeSelected = argsTypeSelected
    }

    fun getArgsTypeSelected():String{
        return argsTypeSelected
    }

    fun getTitle() = title

}
