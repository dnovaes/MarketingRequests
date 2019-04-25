package com.example.marketingrequests.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marketingrequests.model.Title

class GraphicPiecesViewModel: ViewModel() {
    private val title: Title =
        Title("Requisitar Peças Gr\u00E1ficas")
    // Create a LiveData with a String
    var toolbarTitleText: MutableLiveData<String> = MutableLiveData<String>().apply { setValue(title.name)}
    var bottombarVisibility: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    private var argsTypeSelected: String = ""


    fun setToolbarTitle(toolbarTitle:String){
        this.toolbarTitleText = MutableLiveData<String>().apply{ setValue(toolbarTitle)}
    }

    fun getToolbarTitle() = toolbarTitleText

    fun setArgsTypeSelected(argsTypeSelected:String){
        this.argsTypeSelected = argsTypeSelected
    }

    fun getArgsTypeSelected():String{
        return argsTypeSelected
    }

    fun setBottomBarVisibility(bool:Boolean){
        this.bottombarVisibility.value = bool
    }

    fun getTitle() = title

}