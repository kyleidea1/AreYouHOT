package com.example.areyouhot.model

enum class MartialArtType {
    BOXING,
    KICKBOXING,
    WRESTLING,
    JIU_JITSU,
    MMA,
    MUAY_THAI;

    fun toDisplayName(): String = when(this) {
        BOXING -> "복싱"
        KICKBOXING -> "킥복싱"
        WRESTLING -> "레슬링"
        JIU_JITSU -> "주짓수"
        MMA -> "종합격투기"
        MUAY_THAI -> "무에타이"
    }
}