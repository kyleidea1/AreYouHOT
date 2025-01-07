package com.example.areyouhot.view

import androidx.compose.foundation.Image
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.areyouhot.model.Chat
import com.example.areyouhot.model.chatData
import com.example.areyouhot.view.theme.Divider
import com.example.areyouhot.view.theme.TopBar
import com.example.areyouhot.view.theme.Typography

@Composable
fun ChatActivity() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column() {
            TopBar(title = "채팅")
            Divider(2)
            ChatList()
        }
    }
}

@Composable
fun ChatList() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            count = chatData.size,
            key = { index -> chatData[index].userName },
            contentType = { index -> chatData[index] }
        ) { index ->
            val chat = chatData[index]
            ChatListItem(chat)
            Divider(1f)
        }
    }
}

@Composable
private fun ChatListItem(chatListData: Chat) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(4f)
            .padding(10.dp)
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
        ) {
            Image(
                painter = painterResource(id = chatListData.userImage),
                contentDescription = chatListData.userName + "Profile",
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(chatListData.userName, style = Typography.bodyLarge)
                Text(chatListData.userInfo, modifier = Modifier.padding(8.dp, 0.dp), style = Typography.bodySmall, color = Color.Gray)
                Text(chatListData.date, style = Typography.bodySmall, color = Color.Gray)

            }
            Spacer(modifier = Modifier.padding(5.dp))
            Text(chatListData.content, modifier = Modifier.fillMaxWidth(), style = Typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatActivityPreview() {
    ChatActivity()
}