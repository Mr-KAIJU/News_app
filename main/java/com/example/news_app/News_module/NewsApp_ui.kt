package com.example.news_app.News_module

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsApp_Home(vm: NewsAppViewModel, nc: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("News App") },
                actions = {
                    IconButton(onClick = {
                        vm.getResultList()
                    }) {
                        Icon(
                            Icons.Default.Refresh,
                            contentDescription = "Refresh",
                        )
                    }
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier.padding(it)
        ) {
            ProductBody(vm, nc)
        }
    }
}

@Composable
fun ProductBody(vm: NewsAppViewModel, nc: NavController) {
    LaunchedEffect(Unit) {
        vm.getResultList()
    }

    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        if (vm.isLoading) {
            CircularProgressIndicator()
        } else if (vm.errorMessage.isNotEmpty()) {
            Text("Error: ${vm.errorMessage}")
        } else {
            LazyColumn() {
                items(vm.records.size) {
                    val element = vm.records[it]
                    Row(
                        modifier = Modifier.padding(10.dp).clickable {
                            vm.selectedRecord = element
                            nc.navigate("updateProduct")
                        },
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Surface(
                            modifier = Modifier.size(120.dp),
                            color = Color.Gray,
                        ) {
                            AsyncImage(
                                model = element.image,
                                error = painterResource(android.R.drawable.ic_menu_info_details),
                                contentDescription = element.image,
                                contentScale = ContentScale.Crop,
                            )
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            Column() {
                                Text(element.title)
                            }
                        }
                    }
                }
            }
        }
    }
}
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun NewsApp_Home(vm: NewsAppViewModel) {
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = { Text("News App") },
//                actions = {
//                    IconButton(onClick = {
//                        vm.getBitcoinNews()  // Trigger refresh
//                    }) {
//                        Icon(
//                            Icons.Default.Refresh,
//                            contentDescription = "Refresh",
//                        )
//                    }
//                }
//            )
//        }
//    ) { paddingValues ->
//        Surface(
//            modifier = Modifier.padding(paddingValues)
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                Home_Body(vm)
//            }
//        }
//    }
//}
//
//@Composable
//fun Home_Body(vm: NewsAppViewModel) {
//    // Fetch news articles when the composable is first loaded
//    LaunchedEffect(Unit) {
//        vm.getBitcoinNews()
//    }
//
//    Box(
//        contentAlignment = Alignment.TopCenter
//    ) {
//        when {
//            vm.isLoading -> {
//                CircularProgressIndicator()
//            }
//            vm.errorMessage.isNotEmpty() -> {
//                Text("Error: ${vm.errorMessage}")
//            }
//            else -> {
//                LazyColumn(
//                    modifier = Modifier.fillMaxSize(),
//                    contentPadding = PaddingValues(16.dp)
//                ) {
//                    items(vm.articles.size) { index ->
//                        val article = vm.articles[index]
//                        NewsItem(article = article)
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun NewsItem(article: News_Articles) {
//    Row(
//        modifier = Modifier
//            .padding(10.dp)
//            .fillMaxWidth()
//    ) {
//        Surface(
//            modifier = Modifier.size(120.dp),
//            color = Color.Gray
//        ) {
//            AsyncImage(
//                model = article.urlToImage,
//                contentDescription = "Article Image",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxSize(),
//                error = painterResource(id = android.R.drawable.ic_menu_report_image) // Fallback image
//            )
//        }
//
//        Spacer(modifier = Modifier.width(10.dp))
//
//        Column(
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text(
//                text = article.title,
//                style = MaterialTheme.typography.titleMedium,
//                maxLines = 2,
//                overflow = TextOverflow.Ellipsis
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = article.description?: "No description available",
//                style = MaterialTheme.typography.headlineSmall,
//                maxLines = 3,
//                overflow = TextOverflow.Ellipsis
//            )
//        }
//    }
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun NewsApp_Home() {
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = { Text("News App") },
//                actions = {
//                    IconButton(onClick = {
//                        //vm.getResultList()
//                    }) {
//                        Icon(
//                            Icons.Default.Refresh,
//                            contentDescription = "Refresh",
//                        )
//                    }
//                }
//            )
//        }
//    ) {
//        Surface(
//            modifier = Modifier.padding(it)
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize() ,
//                contentAlignment = Alignment.Center
//            ) {
//                //Home_Body(vm , nc)
//                Text(
//                    text = "Welcome to News App",
//                    fontSize = 30.sp
//                )
//                //Home_Body(vm)
//            }
//        }
//    }
//
//
//}
//
//
//@Composable
//fun Home_Body(vm: NewsApp_viewmodel) {
//    LaunchedEffect(Unit) {
//        vm.getResultList()
//    }
//
//    Box(
//        contentAlignment = Alignment.TopCenter
//    ) {
//        if (vm.isLoading) {
//            CircularProgressIndicator()
//        } else if (vm.errorMessage.isNotEmpty()) {
//            Text("Error: ${vm.errorMessage}")
//        } else {
//            LazyColumn() {
//                items(vm.results.size) {
//                    val element = vm.results[it]
//                    Row(
//                        modifier = Modifier
//                            .padding(10.dp),
////                            .clickable {
////                                nc.navigate("detail")
////                            },
//                        verticalAlignment = Alignment.CenterVertically,
//                    ) {
//
//                        Surface(
//                            modifier = Modifier.size(120.dp),
//                            color = Color.Gray,
//                        ) {
////                            AsyncImage(
////                                model = element.urlToImage,
////                                error = painterResource(android.R.drawable.ic_menu_info_details),
////                                contentDescription = element.urlToImage,
////                                contentScale = ContentScale.Crop,
////                            )
//                        }
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(10.dp)
//                        ) {
//                            Column() {
//                                Text(element.title)
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}