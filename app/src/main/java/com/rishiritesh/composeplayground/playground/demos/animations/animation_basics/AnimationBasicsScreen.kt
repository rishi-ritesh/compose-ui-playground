package com.rishiritesh.composeplayground.playground.demos.animations.animation_basics

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rishiritesh.composeplayground.ui.theme.ComposePlaygroundTheme
import com.rishiritesh.composeplayground.ui.theme.Spacing

/**
 * Simple "Animation Basics" demo:
 * - A pulsing box using animateFloatAsState
 * - A toggleable content area using AnimatedVisibility + fadeIn/fadeOut
 *
 * Keep the screen lightweight and preview-friendly.
 */
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState

@Composable
fun AnimationBasicsScreen(
    modifier: Modifier = Modifier,
    viewModel: AnimationBasicsViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    var pulsing by remember { mutableStateOf(uiState.pulsing) } // transitional: keep local for animation smoothing
    // We'll drive pulsing from uiState, but we want composable to react to changes immediately:
    LaunchedEffect(uiState.pulsing) { pulsing = uiState.pulsing }

    val expanded = uiState.expanded

    // pulse scale: toggles between 0.95 and 1.08
    val targetScale = if (pulsing) 1.08f else 0.95f
    val scale by animateFloatAsState(
        targetValue = targetScale,
        animationSpec = tween(durationMillis = 600)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(Spacing.md),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text("Animation Basics", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(Spacing.md))

        // Pulsing box (click to toggle pulsing)
        Box(
            modifier = Modifier
                .size(120.dp)
                .scale(scale)
                .background(color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(12.dp))
                .clickable { viewModel.togglePulsing() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (pulsing) "Pulsing" else "Paused",
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Spacer(modifier = Modifier.height(Spacing.lg))

        // Toggle visibility
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { viewModel.toggleExpanded() }) {
                Text(if (expanded) "Hide details" else "Show details")
            }
            Spacer(modifier = Modifier.width(Spacing.md))
            Text("Visibility: ${if (expanded) "Shown" else "Hidden"}")
        }

        Spacer(modifier = Modifier.height(Spacing.md))

        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn(animationSpec = tween(350)),
            exit = fadeOut(animationSpec = tween(250))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Spacing.md)
                    .background(MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(8.dp))
                    .padding(Spacing.md)
            ) {
                Text("Animated content", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(Spacing.xs))
                Text(
                    "This area appears/disappears using AnimatedVisibility with fade animations. " +
                            "Use animate*AsState for simple property animations (scale, alpha, etc.).",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AnimationBasicsPreview() {
    ComposePlaygroundTheme {
        AnimationBasicsScreen()
    }
}
