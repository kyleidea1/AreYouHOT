package com.example.areyouhot

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
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.areyouhot.ui.theme.Divider
import com.example.areyouhot.ui.theme.TopBar

data class ChatData(
    val userName: String,
    val userImage: Int,
    val userInfo: String,
    val date: String,
    val content: String
)

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
    val chatData = listOf(
        ChatData("WWf33", R.drawable.sample, "합정동", "3일 전", "네 잘쓰세요! ㅎㅎ"),
        ChatData("JohnDoe", R.drawable.sample, "신촌", "2일 전", "거래 감사합니다!"),
        ChatData("JaneSmith", R.drawable.sample, "강남", "어제", "언제 오실 예정인가요?")
    )

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
            ChatListItem(
                chatUserName = chat.userName,
                chatUserImage = chat.userImage,
                chatDate = chat.date,
                chatContent = chat.content,
                chatUserInfo = chat.userInfo,
            )
            Divider(1f)
        }
    }
}

@Composable
private fun ChatListItem(
    chatUserImage: Int,
    chatUserName: String,
    chatUserInfo: String,
    chatDate: String,
    chatContent: String
) {
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
                painter = painterResource(id = chatUserImage),
                contentDescription = chatUserName + "Profile",
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
                Text(chatUserName, fontSize = 20.sp)
                Text(chatUserInfo, modifier = Modifier.padding(8.dp, 0.dp), fontSize = 12.sp, color = Color.Gray)
                Text(chatDate, fontSize = 12.sp, color = Color.Gray)

            }
            Spacer(modifier = Modifier.padding(5.dp))
            Text(chatContent, modifier = Modifier.fillMaxWidth(), fontSize = 15.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatActivityPreview() {
    ChatActivity()
}