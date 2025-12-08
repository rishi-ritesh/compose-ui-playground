package com.rishiritesh.composeplayground.playground.demos.animations.animatedbutton

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rishiritesh.composeplayground.ui.theme.Spacing
import com.rishiritesh.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun AnimatedButtonScreen(
    modifier: Modifier = Modifier,
    viewModel: AnimatedButtonViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()

    // local visible flag for entry animation
    var visible by remember { mutableStateOf(false) }
    androidx.compose.runtime.LaunchedEffect(Unit) {
        visible = true
    }

    androidx.compose.animation.AnimatedVisibility(
        visible = visible,
        enter = androidx.compose.animation.fadeIn() + androidx.compose.animation.slideInVertically(
            // slide in from slightly below
            initialOffsetY = { fullHeight -> fullHeight / 6 }
        ),
        exit = androidx.compose.animation.fadeOut()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(Spacing.md),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Animated Button (ViewModel)", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(Spacing.md))

            AnimatedMorphingButton(
                initialWidth = 220.dp,
                currentState = state,
                onAction = { viewModel.performAction() }
            )
        }
    }
}

/**
 * Stateless morphing button which takes the current state from outside.
 */
@Composable
fun AnimatedMorphingButton(
    initialWidth: Dp = 220.dp,
    currentState: AnimatedButtonState,
    onAction: () -> Unit
) {
    // width animation: shrink slightly when loading
    val targetWidth = when (currentState) {
        AnimatedButtonState.Idle, AnimatedButtonState.Success -> initialWidth
        AnimatedButtonState.Loading -> initialWidth * 0.72f
    }
    val width by animateDpAsState(
        targetValue = targetWidth,
        animationSpec = spring(stiffness = Spring.StiffnessMedium)
    )

    // color animation: blue -> secondary -> green on success
    val bgColor by animateColorAsState(
        targetValue = when (currentState) {
            AnimatedButtonState.Idle -> MaterialTheme.colorScheme.primary
            AnimatedButtonState.Loading -> MaterialTheme.colorScheme.secondary
            AnimatedButtonState.Success -> Color(0xFF4CAF50)
        },
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    val shape = RoundedCornerShape(12.dp)

    Surface(
        modifier = Modifier
            .width(width)
            .height(52.dp)
            .clip(shape),
        color = bgColor,
        shadowElevation = 6.dp,
        tonalElevation = 2.dp
    ) {
        val contentDesc = when (currentState) {
            AnimatedButtonState.Idle -> "Perform action"
            AnimatedButtonState.Loading -> "Loading"
            AnimatedButtonState.Success -> "Success"
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .semantics { this.contentDescription = contentDesc },
            contentAlignment = Alignment.Center
        ) {
            when (currentState) {
                AnimatedButtonState.Idle -> {
                    // full-surface clickable: use Text and a transparent click overlay
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Tap to run",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }

                    // clickable overlay
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .then(Modifier)
                            .clickable { onAction() }
                    )
                }

                AnimatedButtonState.Loading -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(
                            strokeWidth = 2.5.dp,
                            modifier = Modifier.size(18.dp),
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text("Working...", color = MaterialTheme.colorScheme.onSecondary)
                    }
                }

                AnimatedButtonState.Success -> {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "Success",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Loading")
@Composable
fun AnimatedMorphingButtonLoadingPreview() {
    ComposePlaygroundTheme {
        AnimatedMorphingButton(initialWidth = 220.dp, currentState = AnimatedButtonState.Loading, onAction = {})
    }
}

@Preview(showBackground = true, name = "Success")
@Composable
fun AnimatedMorphingButtonSuccessPreview() {
    ComposePlaygroundTheme {
        AnimatedMorphingButton(initialWidth = 220.dp, currentState = AnimatedButtonState.Success, onAction = {})
    }
}

