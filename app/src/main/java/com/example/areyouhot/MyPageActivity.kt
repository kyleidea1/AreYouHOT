package com.example.areyouhot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyPageActivity() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.fillMaxWidth().aspectRatio(7f).padding(horizontal = 12.dp, vertical = 9.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("나의 당근")
                Icon(imageVector = Icons.Default.Settings, contentDescription = "settings")
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.fillMaxWidth().aspectRatio(2f).padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(modifier = Modifier.fillMaxWidth().aspectRatio(3f)) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier.fillMaxHeight().padding(15.dp).aspectRatio(1f)
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
                    Box(modifier = Modifier.fillMaxHeight().border(width = 1.dp, color = Color.LightGray), contentAlignment = Alignment.Center) {
                        Text("프로필 보기", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    }

                }
                Row(
                    modifier = Modifier.fillMaxWidth().aspectRatio(3f).padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            onClick = {}
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.sample),
                                contentDescription = "profile",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Text("판매내역")
                    }
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            onClick = {},
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.sample),
                                contentDescription = "profile",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Text("구매내역")
                    }
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            onClick = {},
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.sample),
                                contentDescription = "profile",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Text("관심목록")
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPageActivityPreview() {
    MyPageActivity()
}