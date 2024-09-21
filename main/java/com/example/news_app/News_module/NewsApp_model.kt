package com.example.news_app.News_module

import com.google.gson.annotations.SerializedName

data class NewsAppModel (

    @SerializedName("success") var success : Boolean,
    @SerializedName("records") var records : List<Records>

)
data class Records (

    @SerializedName("pid") var pid : String,
    @SerializedName("title") var title : String,
    @SerializedName("body") var body : String,
    @SerializedName("price") var price : String,
    @SerializedName("qty") var qty : String,
    @SerializedName("image") var image : String

)
//data class NewsAppModel (
//
//    @SerializedName("status") var status : String,
//    @SerializedName("totalResults") var totalResults : Int,
//    @SerializedName("articles") var articles : List<News_Articles>
//
//)
//
//data class Source (
//
//    @SerializedName("id") var id : String,
//    @SerializedName("name") var name : String
//
//)
//data class News_Articles (
//
//    @SerializedName("source") var source : Source,
//    @SerializedName("author") var author : String,
//    @SerializedName("title") var title : String,
//    @SerializedName("description") var description : String,
//    @SerializedName("url") var url : String,
//    @SerializedName("urlToImage") var urlToImage : String,
//    @SerializedName("publishedAt") var publishedAt : Date,
//    @SerializedName("content") var content : String
//
//)
//data class BottomNavItem(
//    val title: String,
//    val route: String,
//    val selectedIcon: ImageVector,
//    val unselectedIcon: ImageVector
//)