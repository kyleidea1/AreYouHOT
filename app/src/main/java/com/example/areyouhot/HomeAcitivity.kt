package com.example.areyouhot

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.areyouhot.model.Match
import com.example.areyouhot.model.sampleMatches
import com.example.areyouhot.view.theme.MainRed
import com.example.areyouhot.view.theme.Typography

@Composable
fun HomeActivity(navController: NavController) {  // NavController 추가
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            TitleBar(navController)
            MatchList(
                matches = sampleMatches,
                navController = navController  // NavController 전달
            )
        }
    }
}

@Composable
fun MatchList(
    matches: List<Match>,
    navController: NavController,  // NavController 추가
    context: Context = LocalContext.current
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(matches) { match ->
            MatchItem(
                match = match,
                onClick = {
                    navController.navigate("match_details/${matches.indexOf(match)}")
                }
            )
        }
    }
}

@Composable
private fun MatchItem(
    match: Match,
    onClick: () -> Unit  // @Composable 어노테이션 제거
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .aspectRatio(4f)
            .clickable(onClick = onClick)  // onClick 핸들러 추가
    ) {
        Image(
            painter = painterResource(R.drawable.sample),
            "sample",
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(match.title, style = Typography.bodyLarge)
            Text(match.host.nickname, style = Typography.bodyMedium)
            Text(match.matchDate.toString(), style = Typography.bodyMedium)
        }
    }
}

@Composable
private fun TitleBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(MainRed)
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(0.16f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "역삼동", color = Color.White)
                Icon(
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f),
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    tint = Color.White,
                    contentDescription = "dropdown"
                )
            }
            Row() {
                IconButton(
                    onClick = { navController.navigate("search")},
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "검색",
                        modifier = Modifier
                            .aspectRatio(1f)
                            .padding(5.dp)
                    )
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "알림",
                        modifier = Modifier
                            .aspectRatio(1f)
                            .padding(5.dp)
                    )
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Send,
                        contentDescription = "위치",
                        modifier = Modifier
                            .aspectRatio(1f)
                            .padding(5.dp)
                    )
                }

            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeActivityPreview() {
//    HomeActivity()
//}