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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.areyouhot.model.Match
import com.example.areyouhot.model.sampleMatches
import com.example.areyouhot.view.theme.Divider
import com.example.areyouhot.view.theme.ProfileImage
import com.example.areyouhot.view.theme.Tier
import com.example.areyouhot.view.theme.Typography

@Composable
fun MatchDetailsActivity(match: Match = sampleMatches[0]) {
    val scrollState = rememberScrollState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            MatchThumbnail(matchThumbnail = match.thumbnailImage)
            HostInfo()
            Divider(1)
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Text(text = match.title, style = typography.titleLarge, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = match.martialArtType.name, style = typography.bodySmall, color = Color.Gray)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = match.body, style = typography.bodyMedium, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                Row() {
                    Text("관심: ${match.like} / 조회: ${match.views}", color = Color.Gray)
                }
            }
        }
    }
}

@Composable
private fun MatchThumbnail(matchThumbnail: Int) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1f)) {
        Image(painter = painterResource(matchThumbnail), "match thumbnail")
    }
}

@Composable
private fun HostInfo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(5f)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ProfileImage(
                R.drawable.sample,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text("WWIT", style = Typography.bodyMedium)
                Text("역삼동", style = Typography.bodySmall)
            }
        }
        TierInfo(tier = Tier.Gold, modifier = Modifier.fillMaxHeight())
    }
}

@Composable
fun TierInfo(tier: Tier, modifier: Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = tier.imageRes),
            contentDescription = "tier image",
            modifier = Modifier.fillMaxHeight()
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceAround) {
            Text(
                text = tier.tierName,
                style = typography.bodyMedium
            )
            Text(
                text = "LP: ${tier.leaguePoint}",
                style = typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MatchDetailsActivityPreview() {
    MatchDetailsActivity()
}