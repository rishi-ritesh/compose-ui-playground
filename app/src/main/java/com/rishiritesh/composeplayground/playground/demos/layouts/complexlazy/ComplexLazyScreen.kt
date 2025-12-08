package com.rishiritesh.composeplayground.playground.demos.layouts.complexlazy

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rishiritesh.composeplayground.ui.theme.ComposePlaygroundTheme
import com.rishiritesh.composeplayground.ui.theme.Spacing
import kotlinx.coroutines.delay
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.unit.Dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComplexLazyScreen(modifier: Modifier = Modifier) {
    // sample data: 5 sections, each with a few items
    val sections = List(5) { sectionIndex ->
        "Section ${sectionIndex + 1}" to List(6) { itemIndex -> "Item ${itemIndex + 1} of S${sectionIndex + 1}" }
    }

    // We want a one-shot "stagger" when the screen first appears.
    // Use derived key so it's re-triggerable if needed.
    val firstAppearKey = remember { Any() }

    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        modifier = modifier
    ) {
        sections.forEach { (title, itemsList) ->

            // stickyHeader keeps the section title pinned while scrolling inside the section
            stickyHeader {
                Surface(
                    tonalElevation = 2.dp,
                    shadowElevation = 2.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Text(
                        text = title,
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                    )
                }
            }

            // Use itemsIndexed so we have the index for staggered animation delays
            itemsIndexed(itemsList) { index, item ->
                // Each item manages its own local "appeared" state.
                // We'll stagger using a small delay proportional to the index.
                var appeared by remember(firstAppearKey) { mutableStateOf(false) }

                // Trigger appear animation once when the item enters composition
                LaunchedEffect(firstAppearKey) {
                    // small stagger: base 40ms per item (tweak if you like)
                    delay((index * 40).coerceAtMost(400).toLong())
                    appeared = true
                }

                // animate elevation from 0.dp -> 8.dp when appeared becomes true
                val targetElevation: Dp = if (appeared) 6.dp else 0.dp
                val elevation by animateDpAsState(
                    targetValue = targetElevation,
                    animationSpec = spring(stiffness = Spring.StiffnessLow)
                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = elevation)
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComplexLazyScreenPreview() {
    ComposePlaygroundTheme {
        ComplexLazyScreen()
    }
}
