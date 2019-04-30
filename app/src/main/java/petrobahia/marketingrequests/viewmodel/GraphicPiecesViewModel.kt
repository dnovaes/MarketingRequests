package petrobahia.marketingrequests.viewmodel

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import petrobahia.marketingrequests.SingleLiveEvent

class GraphicPiecesViewModel: ViewModel() {
    var toolbarTitle: MutableLiveData<String> = MutableLiveData<String>()
    var numberItemsSelected: MutableLiveData<Int> = MutableLiveData<Int>().apply {setValue(0)}
    var selecedtItemList = SingleLiveEvent<ConstraintLayout>()
    var changeToolbarsColors = MutableLiveData<Boolean>()
    var fFillBottomBartLayout= MutableLiveData<Boolean>()
    var fClearSelectedItems= SingleLiveEvent<Boolean>()

    private var argsTypeSelected: String = ""

    fun getToolbarTitle() = toolbarTitle.value

    fun setToolbarTitle(text:String){
        this.toolbarTitle.value = text
    }

    fun setArgsTypeSelected(argsTypeSelected:String){
        this.argsTypeSelected = argsTypeSelected
    }

    fun getArgsTypeSelected():String{
        return argsTypeSelected
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

    fun setfFillBottomBartLayout(bool: Boolean){
        this.fFillBottomBartLayout.value = bool
    }

    fun getFillBottomBarLayout() = fFillBottomBartLayout.value

    fun setDefaultValues(){
        fFillBottomBartLayout.value = false
        numberItemsSelected.value = 0
        changeToolbarsColors.value =  false
    }
    fun setfClearSelectedItems(bool: Boolean){
       fClearSelectedItems.value = bool
    }

}
