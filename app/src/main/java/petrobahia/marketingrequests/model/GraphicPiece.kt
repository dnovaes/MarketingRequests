package petrobahia.marketingrequests.model

public class GraphicPiece{

    private var id: String? = null
    private var title: String? = null
    private var type: String? = null

    fun getId() = id

    fun seId(id: String){
        this.id = id
    }

    fun getTitle() = title

    fun setTitle(title: String){
        this.title = title
    }

    fun getType() = type

    fun setType(type: String){
        this.type = type
    }

    public fun GraphicPiece(id:String, title: String, type: String){
        this.id = id
        this.title = title
        this.type = type
    }

}
