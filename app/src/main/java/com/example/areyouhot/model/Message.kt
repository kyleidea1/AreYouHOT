package com.example.areyouhot.model

data class Message(
    val id: Int,
    val senderName: String,
    val content: String,
    val timestamp: String,
    val isMine: Boolean
)

val messageData = listOf(
    Message(
        id = 1,
        senderName = "Alice",
        content = "안녕하세요! 오늘 기분은 어떠세요?",
        timestamp = "10:30 PM",
        isMine = false
    ),
    Message(
        id = 2,
        senderName = "Me",
        content = "안녕하세요! 저는 괜찮아요. 감사합니다.",
        timestamp = "10:32 PM",
        isMine = true
    ),
    Message(
        id = 3,
        senderName = "Alice",
        content = "내일 약속 시간은 몇 시가 좋을까요?",
        timestamp = "10:35 PM",
        isMine = false
    ),
    Message(
        id = 4,
        senderName = "Me",
        content = "오후 2시가 좋을 것 같아요.",
        timestamp = "10:36 PM",
        isMine = true
    ),
    Message(
        id = 5,
        senderName = "Alice",
        content = "좋아요. 내일 봐요!",
        timestamp = "10:40 PM",
        isMine = false
    )
)
