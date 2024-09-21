package com.example.news_app.News_module

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
//import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
//import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
//import coil.compose.AsyncImage
import com.example.news_app.R

//import androidx.compose.ui.Alignment
//import com.example.news_app.bottomNavItem
//import com.example.news_app.navBottomBar

@OptIn(ExperimentalMaterial3Api::class)

@Preview(showSystemUi = true)
@Composable
fun NewsApp_AboutUs() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "About Us")
                }
            )
        }
    ){
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
            //Text(text = "Welcome to About Us Page!!!")
            AboutUsBody()
        }
    }

}

data class Member(val name: String, val id : Int = 0)

@Composable
fun MemberCard(member: Member) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray
        ),
        border = BorderStroke(2.dp, color = Color.Black),

    modifier = Modifier
        .fillMaxWidth()
        .padding(1.dp)
    ) {
        Column {
            Text(
                text = member.name,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "ID: ${member.id}",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )

        }
    }
}

@Composable
fun AboutUsBody() {
    val memberList = listOf(
        Member("Pheak Serey Voudthy",2521),
        Member("Chhun Sovandany",2522),
        Member("Kim Tithya",2589),
        Member("Chung Chinga",2552)
    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())

        ) {
            Text(text = "Our Members", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.padding(5.dp))
            for (member in memberList) {
                MemberCard(member = member)
                Spacer(modifier = Modifier.padding(1.dp))
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = "Our Description", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = "A team of four students from IT421: Mobile Development II worked together to develop a modest project centered around a news application. They used Kotlin and Jetpack Compose, among other skills they learnt from your instructor.")
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = "Our Image", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.padding(5.dp))
            Image(painter = painterResource(id = R.drawable.thhy_3), contentDescription = "")
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = "*Pheak Serey Voudthy")
            Spacer(modifier = Modifier.padding(5.dp))
            Image(painter = painterResource(id = R.drawable.dany_1), contentDescription = "")
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = "*Chun Sovandany")
            Spacer(modifier = Modifier.padding(5.dp))
            Image(painter = painterResource(id = R.drawable.kim), contentDescription = "")
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = "*Kim Tithya")
            Spacer(modifier = Modifier.padding(5.dp))
            Image(painter = painterResource(id = R.drawable.chinga), contentDescription = "")
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = "*Chung Chinga")
            Spacer(modifier = Modifier.padding(5.dp))


        }
    }
}

//@Composable
//fun AboutUsBody() {
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter){
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth()
//        ){
//            Text(text = "Our Memeber")
//            Spacer(modifier = Modifier.padding(5.dp))
//            OutlinedCard(
//                colors = CardDefaults.cardColors(
//                    containerColor = MaterialTheme.colorScheme.surface
//                ),
//                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Column {
//                    Text(
//                        text = "Pheak Serey Voudthy",
//                        modifier = Modifier.padding(16.dp),
//                        textAlign = TextAlign.Center,
//                        style = MaterialTheme.typography.headlineSmall
//                    )
//                }
//            }
//            Spacer(modifier = Modifier.padding(5.dp))
//            OutlinedCard(
//                colors = CardDefaults.cardColors(
//                    containerColor = MaterialTheme.colorScheme.surface
//                ),
//                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Column {
//                    Text(
//                        text = "Chhun Sovandany",
//                        modifier = Modifier.padding(16.dp),
//                        textAlign = TextAlign.Center,
//                        style = MaterialTheme.typography.headlineSmall
//                    )
//                }
//            }
//            Spacer(modifier = Modifier.padding(5.dp))
//            OutlinedCard(
//                colors = CardDefaults.cardColors(
//                    containerColor = MaterialTheme.colorScheme.surface
//                ),
//                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Column {
//                    Text(
//                        text = "Kim Tithya",
//                        modifier = Modifier.padding(16.dp),
//                        textAlign = TextAlign.Center,
//                        style = MaterialTheme.typography.headlineSmall
//                    )
//                }
//            }
//            Spacer(modifier = Modifier.padding(5.dp))
//            OutlinedCard(
//                colors = CardDefaults.cardColors(
//                    containerColor = MaterialTheme.colorScheme.surface
//                ),
//                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Column {
//                    Text(
//                        text = "Chung Chinga",
//                        modifier = Modifier.padding(16.dp),
//                        textAlign = TextAlign.Center,
//                        style = MaterialTheme.typography.headlineSmall
//                    )
//                }
//            }
//            Text(text = "A team of four students from IT421: Mobile Development II worked together to develop a modest project centered around a news application. They used Kotlin and Jetpack Compose, among other skills they learnt from your instructor.")
//        }
//    }
//
//}

