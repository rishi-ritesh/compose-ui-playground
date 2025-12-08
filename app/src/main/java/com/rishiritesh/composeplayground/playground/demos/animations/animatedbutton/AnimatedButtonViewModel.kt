package com.rishiritesh.composeplayground.playground.demos.animations.animatedbutton

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AnimatedButtonViewModel : ViewModel() {

    private val _state = MutableStateFlow(AnimatedButtonState.Idle)
    val state: StateFlow<AnimatedButtonState> = _state

    /**
     * Performs the demo action. This simulates an async work flow:
     * Idle -> Loading -> Success -> Idle (after a short delay).
     */
    fun performAction() {
        // Guard: avoid re-triggering while already loading
        if (_state.value == AnimatedButtonState.Loading) return

        viewModelScope.launch {
            _state.value = AnimatedButtonState.Loading

            // simulate network / work
            delay(1400L)

            _state.value = AnimatedButtonState.Success

            // auto-reset after a short delay for demo purposes
            delay(1200L)
            _state.value = AnimatedButtonState.Idle
        }
    }
}
