package com.event.anime.extension

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import kotlinx.coroutines.coroutineScope

fun Modifier.shimmerEffect(): Modifier = composed {
    // State to track the size of the content
    var size by remember { mutableStateOf(IntSize.Zero) }

    // Animation transition for shimmer effect
    val transition = rememberInfiniteTransition(
        label = "Animates the background",
    )
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        ),
        label = "Animates the background",
    )

    // Apply background with linear gradient and animate it
    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFDBDBDB),
                Color(0xFF8F8B8B),
                Color(0xFFDBDBDB),
            ),
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    ).onGloballyPositioned {
        size = it.size
    }
}

fun Modifier.disableSplitMotionEvents() =
    pointerInput(Unit) {
        coroutineScope {
            var currentId: Long = -1L
            awaitPointerEventScope {
                while (true) {
                    awaitPointerEvent(PointerEventPass.Initial).changes.forEach { pointerInfo ->
                        when {
                            pointerInfo.pressed && currentId == -1L -> currentId = pointerInfo.id.value
                            pointerInfo.pressed.not() && currentId == pointerInfo.id.value -> currentId = -1
                            pointerInfo.id.value != currentId && currentId != -1L && pointerInfo.id.value != currentId -> pointerInfo.consume()
                            else -> Unit
                        }
                    }
                }
            }
        }
    }