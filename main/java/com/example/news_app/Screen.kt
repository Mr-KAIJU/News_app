package com.example.news_app

sealed class Screen (val screen: String){
    data object Home: Screen("home_Screen")
    data object Search:Screen("search_Screen")
    data object AboutUs:Screen("aboutUs_Screen")
    data object Detail:Screen("detail_Screen")
}