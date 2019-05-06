package petrobahia.marketingrequests.viewmodel

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import petrobahia.marketingrequests.SingleLiveEvent
import petrobahia.marketingrequests.model.GraphicPieceList

class GraphicPiecesViewModel: ViewModel() {
    var toolbarTitle: MutableLiveData<String> = MutableLiveData<String>()
    var numberItemsSelected: MutableLiveData<Int> = MutableLiveData<Int>().apply {setValue(0)}
    var selecedtItemList = SingleLiveEvent<ConstraintLayout>()
    var changeToolbarsColors = MutableLiveData<Boolean>()
    //Flags
    var fFillBottomBartLayout= MutableLiveData<Boolean>()
    var fClearSelectedItems= SingleLiveEvent<Boolean>()
    var fGetGraphicPiecesByType = MutableLiveData<Boolean>()

    private var fGraphicPieceList: MutableLiveData<GraphicPieceList> = MutableLiveData<GraphicPieceList>()
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

    fun getfGraphicPieceList() = fGraphicPieceList.value

    fun setfGraphicPieceList(list: GraphicPieceList){
        fGraphicPieceList.value = list
    }

    fun getfGetGraphicPiecesByType() = fGetGraphicPiecesByType.value
    fun setfGetGraphicPiecesByType(bool:Boolean){
        fGetGraphicPiecesByType.value = bool
    }
}
