package com.example.news_app.News_module

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

const val PRODUCT_BASAE_URL = "http://10.0.2.2/"

data class APIResponse(
    val success: Boolean,
    val message: String
)

interface NewsAppService{
    @GET("aubweekend1/read.php")
    suspend fun getProducts(
        @Query("api_key") apiKey: String = "thy",
    ): NewsAppModel

    @FormUrlEncoded
    @POST("aubweekend1/insert_post.php")
    suspend fun insertRecord(
        @Field("title") title: String,
        @Field("body") body: String,
        @Field("qty") qty: String,
        @Field("price") price: String,
        @Field("image") image: String,
        @Query("api_key") key: String = "thy"
    ): APIResponse
    @FormUrlEncoded
    @POST("aubweekend1/update_post.php")
    suspend fun updateRecord(
        @Field("pid") pid: String,
        @Field("title") title: String,
        @Field("body") body: String,
        @Field("qty") qty: String,
        @Field("price") price: String,
        @Field("image") image: String,
        @Query("api_key") key: String = "thy"
    ): APIResponse

    @FormUrlEncoded
    @POST("aubweekend1/delete_post.php")
    suspend fun deleteRecord(
        @Field("pid") pid: String,
        @Query("api_key") key: String = "thy"
    ): APIResponse


    companion object {
        var service: NewsAppService? = null
        fun getInstance(): NewsAppService{
            if (service == null) {
                val gson = GsonBuilder().setLenient().create()
                service = Retrofit.Builder()
                    .baseUrl(PRODUCT_BASAE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(NewsAppService::class.java)
            }
            return service!!

        }
    }
}
//const val NEWS_BASE_URL = "https://newsapi.org"
//
//interface NewsAppService {
//    @GET("/v2/everything")
//    suspend fun getBitcoinNews(
//        @Query("q") query: String = "bitcoin",
//        @Query("page") page: Int = 1,
//        @Query("apiKey") apiKey: String = "0d8af59e9989482d971d0b02a326465a"
//    ): NewsAppModel
//
//    companion object {
//        var service: NewsAppService? = null
//        fun getInstance(): NewsAppService {
//            if (service == null) {
//                service = Retrofit.Builder()
//                    .baseUrl(NEWS_BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                    .create(NewsAppService::class.java)
//            }
//            return service!!
//        }
//    }
//}
////https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=APIKEY
//const val BASE_URL = "https://newsapi.org/"
//
//interface NewsApp_service{
//    //@GET("v2/top-headlines")
//    @GET("everything")
//    suspend fun getTopHeadlines(
//        @Query("sources") sources: String = "bbc-news",
//        @Query("total results") totalResults: Int = 100,
//        @Query("api_key") apiKey: String = "0d8af59e9989482d971d0b02a326465a"
//    ): NewsAppModel
//
//    companion object {
//        var service : NewsApp_service? = null
//        fun getInstance(): NewsApp_service {
//            if(service == null){
//                service = Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                    .create(NewsApp_service::class.java)
//            }
//            return service!!
//        }
//    }
//}
