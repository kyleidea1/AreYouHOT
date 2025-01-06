package com.example.areyouhot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeActivity() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            TitleBar()
            MatchList()
        }
    }
}

@Composable
fun MatchList() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(10) {
            MatchItem()
        }
    }
}

//@Composable
//fun MatchList(matches: List<Match>) { // Match는 데이터 클래스
//    LazyColumn(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        items(matches) { match ->
//            MatchItem() // 필요한 경우 match 데이터를 MatchItem에 전달
//        }
//    }
//}

@Composable
private fun MatchItem() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp))
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .aspectRatio(4f)) {
        Image(
            painter = painterResource(R.drawable.sample),
            "sample",
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
            Text("페라리 브라이트 네롤리입니다.")
            Text("페라리 브라이트 네롤리입니다.")
            Text("페라리 브라이트 네롤리입니다.")
        }
    }
}

@Composable
private fun TitleBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
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
                Text(text = "역삼동")
                Icon(
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f),
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = "dropdown"
                )
            }
            Row() {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sample),
                        contentDescription = "sample",
                        modifier = Modifier.fillMaxSize()
                    )
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sample),
                        contentDescription = "sample",
                        modifier = Modifier.fillMaxSize()
                    )
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sample),
                        contentDescription = "sample",
                        modifier = Modifier.fillMaxSize()
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeActivityPreview() {
    HomeActivity()
}