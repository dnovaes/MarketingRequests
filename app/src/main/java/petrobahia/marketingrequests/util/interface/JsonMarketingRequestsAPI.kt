package petrobahia.marketingrequests.util.`interface`

import petrobahia.marketingrequests.model.GraphicPiece
import petrobahia.marketingrequests.model.GraphicPieceList
import retrofit2.Call
import retrofit2.http.GET

public interface JsonMarketingRequestsAPI{

    @GET("graphicpieces")
    fun getGraphicPiecesData(): Call<GraphicPieceList>
}