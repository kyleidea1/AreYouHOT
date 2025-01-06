package com.example.areyouhot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyPageActivity() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            MyPageTopBar(text = "나의 당근", icon = Icons.Outlined.Settings)
            Divider(1)
            Column(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier.fillMaxWidth().aspectRatio(4f)) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier.fillMaxHeight().aspectRatio(1f)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.sample),
                                contentDescription = "profile",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Column(
                            modifier = Modifier.fillMaxHeight().padding(8.dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text("WWIT", modifier = Modifier.fillMaxWidth(), fontSize = 25.sp)
                            Spacer(modifier = Modifier.padding(5.dp))
                            Text("역삼동 #18", modifier = Modifier.fillMaxWidth(), fontSize = 15.sp)
                        }
                    }
                    Box(modifier = Modifier.fillMaxWidth().aspectRatio(7f).border(width = 1.dp, color = Color.LightGray).clickable {  }, contentAlignment = Alignment.Center) {
                        Text("프로필 보기", textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth().aspectRatio(3f),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NavigationIconColumn(text = "판매내역", drawable = R.drawable.sample)
                    NavigationIconColumn(text = "구매내역", drawable = R.drawable.sample)
                    NavigationIconColumn(text = "관심목록", drawable = R.drawable.sample)
                }
            }
            Divider(8)
            NavigateIconRow("내 동네 설정", Icons.Outlined.Place)
            NavigateIconRow("동네 인증하기", Icons.Outlined.AddCircle)
            NavigateIconRow("키워드 알림", Icons.Outlined.Notifications)
            NavigateIconRow("모아보기", Icons.Outlined.Home)
            Divider(8)
            NavigateIconRow("동네생활 글", Icons.Outlined.Create)
            NavigateIconRow("동네생활 댓글", Icons.Outlined.ThumbUp)
        }
    }
}

@Composable
private fun MyPageTopBar(title: String, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(7f)
            .padding(horizontal = 12.dp, vertical = 9.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title)
        Icon(imageVector = icon, contentDescription = icon.name)
    }
}

@Composable
private fun NavigationIconColumn(text: String, drawable: Int) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = {}
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = text,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(text)
    }
}

@Composable
private fun Divider(height: Int) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(height.dp)
        .background(Color.LightGray))
}

@Composable
private fun NavigateIconRow(text: String, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(8f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            modifier = Modifier
                .aspectRatio(1f)
                .padding(5.dp)
        )
        Text(text, modifier = Modifier.padding(5.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MyPageActivityPreview() {
    MyPageActivity()
}