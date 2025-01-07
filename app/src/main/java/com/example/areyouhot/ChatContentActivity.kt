package com.example.areyouhot

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.areyouhot.model.Message
import com.example.areyouhot.model.messageData
import com.example.areyouhot.view.theme.Divider
import com.example.areyouhot.view.theme.MainRed
import com.example.areyouhot.view.theme.Typography

@Composable
fun ChatContentActivity() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top
            ) {
                Column {
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
                            Text("코리안좀비", style = Typography.titleMedium)
                            Text("골드 3", style = Typography.titleSmall, color = Color.Gray)
                        }
                        Row() {
                            Icon(imageVector = Icons.Outlined.DateRange, contentDescription = "dateRange")
                            Icon(imageVector = Icons.Outlined.MoreVert, contentDescription = "moreVert")
                        }
                    }
                    Divider(1)
                }
                MessageList()
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = "add")
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = { Text("메시지 입력", style = Typography.bodyLarge) }
                )
                Icon(imageVector = Icons.Outlined.Send, contentDescription = "send")
            }
        }

    }
}

@Composable
fun MessageList() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        items(
            count = messageData.size,
            key = { index -> messageData[index].id },
            contentType = { index -> messageData[index] }
        ) { index ->
            val message = messageData[index]
            MessageItem(message)
        }
    }
}

@Composable
fun MessageItem(message: Message) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = if (message.isMine) Arrangement.End else Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {
        if (message.isMine) Text(message.timestamp, style = Typography.bodySmall, color = Color.Gray)
        Spacer(modifier = Modifier.padding(4.dp))
        Column(
            modifier = Modifier
                .background(color = if (message.isMine) MainRed else Color.White)
                .padding(12.dp)
        ) {
            Text(message.content, style = Typography.bodyLarge, color = if (message.isMine) Color.White else Color.Black)
        }
        Spacer(modifier = Modifier.padding(4.dp))
        if (!message.isMine) Text(message.timestamp, style = Typography.bodySmall, color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun ChatContentActivityPreview() {
    ChatContentActivity()
}