package com.example.areyouhot.model

import com.example.areyouhot.R

data class Chat(
    val userName: String,
    val userImage: Int,
    val userInfo: String,
    val date: String,
    val content: String
)

val chatData = listOf(
    Chat("WWf33", R.drawable.sample, "합정동", "3일 전", "네 잘쓰세요! ㅎㅎ"),
    Chat("JohnDoe", R.drawable.sample, "신촌", "2일 전", "거래 감사합니다!"),
    Chat("JaneSmith", R.drawable.sample, "강남", "어제", "언제 오실 예정인가요?")
)