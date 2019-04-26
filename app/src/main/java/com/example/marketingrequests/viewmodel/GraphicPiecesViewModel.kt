package com.example.marketingrequests.viewmodel

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marketingrequests.SingleLiveEvent

class GraphicPiecesViewModel: ViewModel() {
    var toolbarTitleText: MutableLiveData<String> = MutableLiveData<String>()
    var bottombarVisibility: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    var selecedtItemList = SingleLiveEvent<ConstraintLayout>()
    private var argsTypeSelected: String = ""

    fun getToolbarTitle() = toolbarTitleText.value

    fun setToolbarTitle(toolbarTitle:String){
        this.toolbarTitleText = MutableLiveData<String>().apply{ setValue(toolbarTitle)}
    }

    fun setArgsTypeSelected(argsTypeSelected:String){
        this.argsTypeSelected = argsTypeSelected
    }

    fun getArgsTypeSelected():String{
        return argsTypeSelected
    }

    fun setBottomBarVisibility(bool:Boolean){
        this.bottombarVisibility.value = bool
    }

    fun setSelectedItemList(item:ConstraintLayout){
       this.selecedtItemList.value = item
    }

}
