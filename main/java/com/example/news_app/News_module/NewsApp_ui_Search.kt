package com.example.news_app.News_module

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Surface
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Divider
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsApp_Search() {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var items by remember { mutableStateOf(listOf<Records>()) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Search Page")
                }
            )
        }
    ){
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                query = text,
                onQueryChange = {
                    text = it
                },
                onSearch = {
                    active = false
                },
                active = active,
                onActiveChange = {
                    active = it
                },
                placeholder = {
                    Text(text = "Search for news..")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                },
                trailingIcon = {
                    if(active){
                        Icon(
                            modifier = Modifier.clickable {
                                if (text.isNotEmpty()){
                                    text = ""
                                } else{active = false}
                            },
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close Icon")
                    }
                }
            ) {
                items.forEach {
                    Row(modifier = Modifier.padding(16.dp)) {
                        Icon(
                            modifier = Modifier.padding(end = 16.dp),
                            imageVector = Icons.Default.History,
                            contentDescription = "History Icon")
                        Text(text = it.title)
                    }

                }
            }
            //Text(text = "Welcome to Search Page!!!")
        }
    }
}

