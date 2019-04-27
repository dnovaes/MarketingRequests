package com.example.marketingrequests.viewmodel

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marketingrequests.SingleLiveEvent

class GraphicPiecesViewModel: ViewModel() {
    var toolbarTitleText: MutableLiveData<String> = MutableLiveData<String>()
    var bottombarVisibility: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    var numberItemsSelected: MutableLiveData<Int> = MutableLiveData<Int>().apply {setValue(0)}
    var selecedtItemList = SingleLiveEvent<ConstraintLayout>()
    var changeToolbarsColors = MutableLiveData<Boolean>()
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

    fun setChangeToolbarsColors(bool:Boolean){
        this.changeToolbarsColors.value = bool
    }

    fun setSelectedItemList(item:ConstraintLayout){
       this.selecedtItemList.value = item
    }

    fun setNumberItemsSelected(num:Int){
       this.numberItemsSelected.value = num
    }

    fun getNumberItemsSelected() = numberItemsSelected.value

}
