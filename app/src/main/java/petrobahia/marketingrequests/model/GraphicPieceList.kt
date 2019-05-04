package petrobahia.marketingrequests.model

import com.google.gson.annotations.SerializedName

public class GraphicPieceList{

    @SerializedName("success")
    private lateinit var messageSuccess: String
    @SerializedName("message")
    private lateinit var messageContent: String
    @SerializedName("content")
    private lateinit var graphicPieceList: ArrayList<GraphicPiece>

    fun getGraphicPieceArrayList(): ArrayList<GraphicPiece> = this.graphicPieceList

    fun setGraphicPieceArrayList(list: ArrayList<GraphicPiece>){
        this.graphicPieceList = list
    }

    fun getMessageSuccess() = messageSuccess
    fun setMessageSuccess(message:String){
       this.messageSuccess = message
    }

    fun getMessageContent() = messageContent
    fun setMessageContent(message:String){
        this.messageContent = message
    }

}
