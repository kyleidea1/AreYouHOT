package com.example.areyouhot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.areyouhot.ui.theme.Divider

@Composable
fun ChatContentActivity() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(6f)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "arrowBack")
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("코리안좀비")
                    Text("골드 3", color = Color.Gray)
                }
                Row() {
                    Icon(imageVector = Icons.Outlined.DateRange, contentDescription = "dateRange")
                    Icon(imageVector = Icons.Outlined.MoreVert, contentDescription = "moreVert")
                }
            }
            Divider(1)
            Row(
                modifier = Modifier.background(color = Color.LightGray)
            ) {

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ChatContentActivityPreview() {
    ChatContentActivity()
}