package com.rishiritesh.composeplayground.playground.demos.animations.animation_basics

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AnimationBasicsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AnimationBasicsUiState())
    val uiState: StateFlow<AnimationBasicsUiState> = _uiState.asStateFlow()

    fun togglePulsing() {
        val current = _uiState.value
        _uiState.value = current.copy(pulsing = !current.pulsing)
    }

    fun toggleExpanded() {
        val current = _uiState.value
        _uiState.value = current.copy(expanded = !current.expanded)
    }
}
