package com.example.areyouhot.model

import androidx.annotation.DrawableRes
import com.example.areyouhot.R
import com.example.areyouhot.view.theme.Tier
import java.util.UUID

data class User(
    val id: String = UUID.randomUUID().toString(),
    val nickname: String,
    @DrawableRes val profileImage: Int,
    val tier: Tier,
    val address: String
)

val sampleUser = User(
    nickname = "복싱왕",
    profileImage = R.drawable.sample,
    tier = Tier.Gold,
    address = "장전동"
)

val sampleUserList = listOf(
    User(
        nickname = "복싱왕",
        profileImage = R.drawable.sample,
        tier = Tier.Gold,
        address = "장전동"
    ),
    User(
        nickname = "검객",
        profileImage = R.drawable.sample,
        tier = Tier.Silver,
        address = "서면"
    ),
    User(
        nickname = "무림고수",
        profileImage = R.drawable.sample,
        tier = Tier.Platinum,
        address = "해운대"
    ),
    User(
        nickname = "암살자",
        profileImage = R.drawable.sample,
        tier = Tier.Bronze,
        address = "동래"
    ),
    User(
        nickname = "협객",
        profileImage = R.drawable.sample,
        tier = Tier.Diamond,
        address = "광안리"
    )
)
