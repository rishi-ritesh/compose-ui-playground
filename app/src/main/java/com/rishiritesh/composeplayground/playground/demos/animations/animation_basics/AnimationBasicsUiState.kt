package com.rishiritesh.composeplayground.playground.demos.animations.animation_basics

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class AnimationBasicsUiState(
    val pulsing: Boolean = true,
    val expanded: Boolean = true
)
