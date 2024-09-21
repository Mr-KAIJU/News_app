package com.example.news_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.news_app.News_module.NewsApp_AboutUs
import com.example.news_app.News_module.NewsApp_Detail
import com.example.news_app.News_module.NewsApp_Home
import com.example.news_app.News_module.NewsApp_Search
import com.example.news_app.News_module.NewsAppViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AsyncApp()

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AsyncApp() {
    val vm = NewsAppViewModel()
    val nc = rememberNavController()
    NavHost(navController = nc, startDestination = "home") {
        composable("home") {
            NewsApp_Home(vm, nc)
        }
//        composable("search") {
//            NewsApp_Search()
//        }
        composable("detail") {
            NewsApp_Detail(vm, nc)
        }


//    Box(
//        modifier = Modifier
//            .fillMaxSize(),
//        contentAlignment = Alignment.TopCenter,
//
//    ) {
//        //NewsApp_AboutUs()
//        NewsApp_Home(vm)
//        NavBottomBar()
//
//
//    }

    }
    NavBottomBar()

}
@Composable
fun NavBottomBar() {

    val navigateionController = rememberNavController()
    //val context = LocalContext.current.applicationContext
    val selected = remember { mutableStateOf(Icons.Default.Home) }
    val vm = NewsAppViewModel()
    val nc = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Black
            ) {

                // For Home Screen
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navigateionController.navigate(Screen.Home.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
                    )
                }

                // For Search Screen
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Search
                        navigateionController.navigate(Screen.Search.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Search) Color.White else Color.DarkGray
                    )
                }

                // For About US Screen
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navigateionController.navigate(Screen.AboutUs.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Person) Color.White else Color.DarkGray
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navigateionController,
            startDestination = Screen.Home.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.screen) { NewsApp_Home(vm, nc) }
            composable(Screen.Search.screen) { NewsApp_Search() }
            composable(Screen.AboutUs.screen) { NewsApp_AboutUs() }
            composable(Screen.Detail.screen) { NewsApp_Detail(vm,nc) }
        }

    }
}



//val bottomNavItem = listOf(
//    BottomNavItem(
//        title = "Home_Screen",
//        route = "home",
//        selectedIcon = Icons.Filled.Home,
//        unselectedIcon = Icons.Outlined.Home,
//    ),
//    BottomNavItem(
//        title = "Search_Screen",
//        route = "search",
//        selectedIcon = Icons.Filled.DateRange,
//        unselectedIcon = Icons.Outlined.DateRange,
//    ),
//    BottomNavItem(
//        title = "AboutUs_Screen",
//        route = "aboutUs",
//        selectedIcon = Icons.Filled.Person,
//        unselectedIcon = Icons.Outlined.Person,
//    ),
//    BottomNavItem(
//        title = "Detail_Screen",
//        route = "detail",
//        selectedIcon = Icons.Filled.Settings,
//        unselectedIcon = Icons.Outlined.Settings,
//    ),
//)
//
//data class BottomNavItem(
//    val title: String,
//    val route: String,
//    val selectedIcon: ImageVector,
//    val unselectedIcon: ImageVector
//)