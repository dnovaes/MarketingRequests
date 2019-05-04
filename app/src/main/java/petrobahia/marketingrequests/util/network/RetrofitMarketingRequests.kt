package petrobahia.marketingrequests.util.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitMarketingRequests {
    companion object{
        private val BASE_URL = "https://bobito.herokuapp.com/"
        //private val BASE_URL = "http://localhost:3000/"

        fun getRetrofitInstance(): Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }

    }
}
