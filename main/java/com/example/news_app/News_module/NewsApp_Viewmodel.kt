package com.example.news_app.News_module

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class NewsAppViewModel : ViewModel() {
    private val _records = mutableStateListOf<Records>()
    var errorMessage: String by mutableStateOf("")
    var successMessage: String by mutableStateOf("")
    var isLoading: Boolean by mutableStateOf(false)
    val records: List<Records>
        get() = _records

    var selectedRecord: Records by mutableStateOf(
        Records(pid="", title = "", body="", price="", qty="", image="")
    )

    fun resetStates(){
        errorMessage = ""
        successMessage = ""
        isLoading = false
        selectedRecord = Records(pid="", title = "", body="", price="", qty="", image="")
    }

    fun insertRecord(record: Records) {
        viewModelScope.launch {
            isLoading = true
            val service = NewsAppService.getInstance()
            try {
                val response: APIResponse = service.insertRecord(
                    title = record.title,
                    body = record.body,
                    price = record.price,
                    qty = record.qty,
                    image = record.image,
                )

                if (response.success) {
                    successMessage = response.message
                    errorMessage = ""
                    getResultList()
                } else {
                    successMessage = ""
                    errorMessage = "Error: $response"
                }
            } catch (e: Exception) {
                errorMessage = "Exception: ${e.message.toString()}"
            } finally {
                isLoading = false
            }
        }
    }

    fun updateRecord(record: Records) {
        viewModelScope.launch {
            isLoading = true
            val service = NewsAppService.getInstance()
            try {
                val response: APIResponse = service.updateRecord(
                    pid = record.pid,
                    title = record.title,
                    body = record.body,
                    price = record.price,
                    qty = record.qty,
                    image = record.image,
                )

                if (response.success) {
                    successMessage = response.message
                    errorMessage = ""
                    getResultList()
                } else {
                    successMessage = ""
                    errorMessage = "Error: $response"
                }
            } catch (e: Exception) {
                errorMessage = "Exception: ${e.message.toString()}"
            } finally {
                isLoading = false
            }
        }
    }

    fun deleteRecord(pid: String) {
        viewModelScope.launch {
            isLoading = true
            val service = NewsAppService.getInstance()
            try {
                val response: APIResponse = service.deleteRecord(
                    pid = pid,
                )

                if (response.success) {
                    successMessage = response.message
                    _records.removeIf { it.pid == pid }
                } else {
                    errorMessage = "Error: $response"
                }
            } catch (e: Exception) {
                errorMessage = "Exception: ${e.message.toString()}"
            } finally {
                isLoading = false
            }
        }
    }

    fun getResultList() {
        viewModelScope.launch {
            isLoading = true
            val apiService = NewsAppService.getInstance()
            try {
                _records.clear()
                _records.addAll(apiService.getProducts().records)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            } finally {
                isLoading = false
            }
        }
    }
}
//class NewsAppViewModel : ViewModel() {
//    private val _articles = mutableStateListOf<News_Articles>()
//    var errorMessage: String by mutableStateOf("")
//    var isLoading: Boolean by mutableStateOf(false)
//    val articles: List<News_Articles>
//        get() = _articles
//
//    // Fetch news articles related to Bitcoin
//    fun getBitcoinNews(page: Int = 1) {
//        viewModelScope.launch {
//            isLoading = true
//            val apiService = NewsAppService.getInstance()
//            try {
//                _articles.clear()
//                _articles.addAll(apiService.getBitcoinNews(page = page).articles)
//            } catch (e: Exception) {
//                errorMessage = e.message.toString()
//            } finally {
//                isLoading = false
//            }
//        }
//    }
//}
//class NewsApp_viewmodel : ViewModel() {
//    private val _results = mutableStateListOf<News_Articles>()
//    var errorMessage: String by mutableStateOf("")
//    var isLoading: Boolean by mutableStateOf(false)
//    val results: List<News_Articles>
//        get() = _results
//
//    fun getResultList(totalResults: Int=100) {
//        viewModelScope.launch {
//            isLoading = true
//            val apiService = NewsAppService.getInstance()
//            try {
//                _results.clear()
//                _results.addAll(apiService.getBitcoinNews(totalResults = totalResults).articles)
//            } catch (e: Exception) {
//                errorMessage = e.message.toString()
//            } finally {
//                isLoading = false
//            }
//        }
//    }
//}