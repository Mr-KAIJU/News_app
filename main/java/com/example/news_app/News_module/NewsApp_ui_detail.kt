package com.example.news_app.News_module


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.Textsms
//import androidx.compose.material3.AlertDialog
//import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
//import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

//import androidx.compose.runtime.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsApp_Detail(vm: NewsAppViewModel, nc: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("News Detail") },
                navigationIcon = {
                    IconButton(onClick = {
                        vm.resetStates()
                        nc.popBackStack()
                    }) {
                        Icon(
                            Icons.Default.ArrowBackIosNew,
                            contentDescription = "Back",
                        )
                    }
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier.padding(it)
        ) {
            News_Detail_Body(vm)
        }
    }
}

@Composable
fun News_Detail_Body(vm: NewsAppViewModel) {
    val element = vm.selectedRecord

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        AsyncImage(
            model = element.image,
            error = painterResource(android.R.drawable.ic_menu_info_details),
            contentDescription = element.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(200.dp) // Adjust the size as needed
        )

        Spacer(modifier = Modifier.height(16.dp)) // Space between image and title
        Text(
            text = element.title,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp)) // Space between title and body
        Text(
            text = element.body,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )

        if (vm.isLoading) {
            CircularProgressIndicator()
        } else if (vm.successMessage.isNotEmpty()) {
            Text(vm.successMessage, color = Color.Blue)
        } else if (vm.errorMessage.isNotEmpty()) {
            Text(vm.errorMessage, color = Color.Red)
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun NewsApp_Detail(vm: NewsAppViewModel, nc: NavController) {
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = { Text("News Detail") },
//                navigationIcon = {
//                    IconButton(onClick = {
//                        vm.resetStates()
//                        nc.popBackStack()
//                    }) {
//                        Icon(
//                            Icons.Default.ArrowBackIosNew,
//                            contentDescription = "Back",
//                        )
//                    }
//                }
//            )
//        }
//    ) {
//        Surface(
//            modifier = Modifier.padding(it)
//        ) {
//            News_Detail_Body(vm,nc)
//        }
//    }
//}
//
//@Composable
//fun News_Detail_Body(vm: NewsAppViewModel, nc: NavController) {
//
//    val element = vm.selectedRecord
//
//    var title by remember { mutableStateOf(element.title) }
//    var body by remember { mutableStateOf(element.body) }
//    var price by remember { mutableStateOf(element.price) }
//    var qty by remember { mutableStateOf(element.qty) }
//    var image by remember { mutableStateOf(element.image) }
//
//    var showDialog by remember { mutableStateOf(false) }
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        AsyncImage(
//            model = element.image,
//            error = painterResource(android.R.drawable.ic_menu_info_details),
//            contentDescription = element.image,
//            contentScale = ContentScale.Crop,
//        )
//        Text(text = element.title)
//
//        TextField(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(5.dp),
//            value = title,
//            onValueChange = { title = it },
//            label = { Text("Title") },
//            placeholder = { Text("Enter Title") },
//            leadingIcon = {
//                Icon(
//                    Icons.Default.TextFields,
//                    contentDescription = null,
//                )
//            },
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Text,
//            )
//        )
//        TextField(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(5.dp),
//            value = body,
//            onValueChange = { body = it },
//            label = { Text("body") },
//            placeholder = { Text("Enter body") },
//            leadingIcon = {
//                Icon(
//                    Icons.Default.Textsms,
//                    contentDescription = null,
//                )
//            },
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Text,
//            )
//        )
//        TextField(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(5.dp),
//            value = price,
//            onValueChange = { price = it },
//            label = { Text("price") },
//            placeholder = { Text("Enter price") },
//            leadingIcon = {
//                Icon(
//                    Icons.Default.CurrencyExchange,
//                    contentDescription = null,
//                )
//            },
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Number,
//            )
//        )
//        TextField(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(5.dp),
//            value = qty,
//            onValueChange = { qty = it },
//            label = { Text("Quantity") },
//            placeholder = { Text("Enter Quantity") },
//            leadingIcon = {
//                Icon(
//                    Icons.Default.Numbers,
//                    contentDescription = null,
//                )
//            },
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Number,
//            )
//        )
//        TextField(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(5.dp),
//            value = image,
//            onValueChange = { image = it },
//            label = { Text("image") },
//            placeholder = { Text("Enter image") },
//            leadingIcon = {
//                Icon(
//                    Icons.Default.Image,
//                    contentDescription = null,
//                )
//            },
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Text,
//            )
//        )
//
//
//        if (vm.isLoading) {
//            CircularProgressIndicator()
//        }
//
//        else if (vm.successMessage.isNotEmpty()) {
//            Text(vm.successMessage, color = Color.Blue)
//        }
//
//        else if (vm.errorMessage.isNotEmpty()) {
//            Text(vm.errorMessage, color = Color.Red)
//        }
//    }
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun NewsApp_Detail() {
//
//}
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun NewsApp_Detail(navController: NavController) {
//    val navController = rememberNavController()
//    ModalNavigationDrawer(drawerContent = { /* ... */ }) {
//        Scaffold(
//            topBar = {
//                TopAppBar(
//                    title = { Text("News Detail") },
//                    navigationIcon = {
//                        IconButton(onClick = { navController.navigateUp() }) {
//                            Icon(
//                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                                contentDescription = "Go back"
//                            )
//                        }
//                    }
//                )
//            }
//        ) {
//            Box(modifier = Modifier.padding(it)){
//                DetailBody()
//            }
//        }
//    }
//}
//@Composable
//fun DetailBody(){}