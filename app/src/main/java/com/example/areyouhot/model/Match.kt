package com.example.areyouhot.model

import androidx.annotation.DrawableRes
import com.example.areyouhot.R
import com.example.areyouhot.view.theme.Tier
import java.time.LocalDateTime
import java.util.UUID

data class Match(
    val id: String = UUID.randomUUID().toString(),
    @DrawableRes val thumbnailImage: Int,
    val title: String,
    val martialArtType: MartialArtType,
    val matchDate: LocalDateTime,
    val host: User,
    val body: String,
    val like: Int,
    val views: Int
)

// 격투기 종목을 위한 enum class
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

// 방장 정보를 위한 데이터 클래스
data class User(
    val id: String = UUID.randomUUID().toString(),
    val nickname: String,
    @DrawableRes val profileImage: Int,
    val tier: Tier
)

// 사용 예시
val sampleMatches = listOf(
    Match(
        thumbnailImage = R.drawable.sample,
        title = "주말 스파링 하실 분",
        martialArtType = MartialArtType.BOXING,
        matchDate = LocalDateTime.of(2025, 1, 15, 14, 0),
        host = User(
            nickname = "복싱왕",
            profileImage = R.drawable.sample,
            tier = Tier.Gold
        ),
        body = "드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와",
        like = 12,
        views = 120
    ),
    Match(
        thumbnailImage = R.drawable.sample,
        title = "주짓수 롤링 파트너 구합니다",
        martialArtType = MartialArtType.JIU_JITSU,
        matchDate = LocalDateTime.of(2025, 1, 20, 19, 30),
        host = User(
            nickname = "주짓수마스터",
            profileImage = R.drawable.sample,
            tier = Tier.Platinum
        ),
        body = "드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와",
        like = 12,
        views = 120
    )
)