package com.example.areyouhot.model

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
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

@RequiresApi(Build.VERSION_CODES.O)
val sampleMatches = listOf(
    Match(
        thumbnailImage = R.drawable.sample,
        title = "주말 스파링 하실 분",
        martialArtType = MartialArtType.BOXING,
        matchDate = LocalDateTime.of(2025, 1, 15, 14, 0),
        host = User(
            nickname = "복싱왕",
            profileImage = R.drawable.sample,
            tier = Tier.Gold,
            address = "장전동"
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
            tier = Tier.Platinum,
            address = "구서동"
        ),
        body = "드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와드루와",
        like = 12,
        views = 120
    )
)