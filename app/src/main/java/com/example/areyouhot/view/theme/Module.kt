package com.example.areyouhot.view.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.areyouhot.R

@Composable
fun Divider(height: Int) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(height.dp)
        .background(Color.LightGray))
}

@Composable
fun TopBar(title: String, icon: ImageVector? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(7f)
            .padding(horizontal = 12.dp, vertical = 9.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title)
        if (icon != null) {
            Icon(imageVector = icon, contentDescription = icon.name)
        }
    }
}

@Composable
fun ProfileImage(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier,
    size: Dp = 100.dp
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

sealed class Tier(
    @DrawableRes val imageRes: Int,
    val tierName: String,
    val leaguePoint: Int
) {
    object Bronze : Tier(R.drawable.tier_bronze, "브론즈", 100)
    object Silver : Tier(R.drawable.tier_silver, "실버", 200)
    object Gold : Tier(R.drawable.tier_gold, "골드", 300)
    object Platinum : Tier(R.drawable.tier_platinum, "플래티넘", 400)
    object Diamond : Tier(R.drawable.tier_diamond, "다이아몬드", 500)

    companion object {
        fun getAllTiers() = listOf(Bronze, Silver, Gold, Platinum, Diamond)
    }
}

//data class FireParticle(
//    val initialPosition: Offset,
//    val angle: Float,
//    val speed: Float,
//    val startTime: Long,
//    val lifetime: Int,  // 파티클의 수명 (밀리초)
//    val size: Float
//)
//
//@Composable
//private fun FireParticleEffect(particles: List<FireParticle>) {
//    Canvas(modifier = Modifier.fillMaxSize()) {
//        particles.forEach { particle ->
//            val age = (System.currentTimeMillis() - particle.startTime).toFloat()
//            val progress = age / particle.lifetime
//
//            // 파티클의 현재 위치 계산
//            val x = particle.initialPosition.x +
//                    cos(particle.angle) * particle.speed * age * 0.1f
//            val y = particle.initialPosition.y +
//                    sin(particle.angle) * particle.speed * age * 0.1f -
//                    (age * age * 0.0001f) // 중력 효과 추가
//
//            // 색상 및 투명도 계산
//            val alpha = 1f - progress
//            val color = when {
//                progress < 0.3f -> Color(1f, 0.8f, 0.2f, alpha) // 노란색
//                progress < 0.6f -> Color(1f, 0.4f, 0f, alpha)   // 주황색
//                else -> Color(1f, 0f, 0f, alpha)                // 빨간색
//            }
//
//            // 파티클 그리기
//            drawCircle(
//                color = color,
//                radius = particle.size * (1f - progress * 0.7f), // 시간이 지날수록 크기 감소
//                center = Offset(x, y)
//            )
//        }
//    }
//}
//
//// 전역적으로 사용할 수 있는 애니메이션 컨트롤러
//object FireAnimationController {
//    private val _isEnabled = MutableStateFlow(true)
//    val isEnabled: StateFlow<Boolean> = _isEnabled
//
//    fun enable() {
//        _isEnabled.value = true
//    }
//
//    fun disable() {
//        _isEnabled.value = false
//    }
//}
//
//// CompositionLocal을 통해 애니메이션 오버레이 접근
//val LocalFireAnimationOverlay = staticCompositionLocalOf<FireAnimationOverlay?> { null }
//
//class FireAnimationOverlay {
//    private val particles = mutableStateListOf<FireParticle>()
//
//    fun addParticlesAt(position: Offset) {
//        if (!FireAnimationController.isEnabled.value) return
//
//        repeat(20) {
//            // 기존의 FireParticle 생성 로직
//            particles.add(
//                FireParticle(
//                    initialPosition = position,
//                    angle = Random.nextFloat() * 2f * Math.PI.toFloat(),
//                    speed = Random.nextFloat() * 3f + 2f,
//                    startTime = System.currentTimeMillis(),
//                    lifetime = Random.nextInt(500, 1000),
//                    size = Random.nextFloat() * 20f + 10f
//                )
//            )
//        }
//    }
//
//    @Composable
//    fun Overlay() {
//        FireParticleEffect(particles)
//    }
//}
//
//@Composable
//fun WithFireAnimation(
//    modifier: Modifier = Modifier,
//    content: @Composable () -> Unit
//) {
//    val overlay = remember { FireAnimationOverlay() }
//
//    Box(modifier = modifier) {
//        CompositionLocalProvider(LocalFireAnimationOverlay provides overlay) {
//            // 기존 컨텐츠
//            content()
//
//            // 오버레이 레이어
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .pointerInput(Unit) {
//                        awaitPointerEventScope {
//                            while (true) {
//                                val event = awaitPointerEvent()
//                                if (!event.changes.first().pressed) continue
//
//                                // 애니메이션 추가
//                                overlay.addParticlesAt(event.changes.first().position)
//
//                                // 아래 레이어로 터치 이벤트 전달
//                                event.changes.forEach { it.consume() }
//                            }
//                        }
//                    }
//            ) {
//                overlay.Overlay()
//            }
//        }
//    }
//}