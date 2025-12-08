package com.rishiritesh.composeplayground.playground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rishiritesh.composeplayground.playground.navigation.PlaygroundScreen
import com.rishiritesh.composeplayground.playground.DemoRepository.demos
import com.rishiritesh.composeplayground.playground.ui.SectionHeader
import com.rishiritesh.composeplayground.ui.theme.ComposePlaygroundTheme
import com.rishiritesh.composeplayground.ui.theme.Spacing

@Composable
fun CatalogScreen(
    modifier: Modifier = Modifier,
    onOpenDemo: (PlaygroundScreen) -> Unit = {}
) {
    val sections = groupDemos(demos)

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = Spacing.md,
            end = Spacing.md,
            top = Spacing.sm,
            bottom = Spacing.lg
        ),
        verticalArrangement = Arrangement.spacedBy(Spacing.md),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            Text(
                text = "Compose UI Playground",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        item {
            Text(
                text = "Interactive UI demos built with Jetpack Compose",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = Spacing.sm)
            )
        }

        sections.forEach { (sectionTitle, sectionItems) ->

            item {
                SectionHeader(title = sectionTitle)
            }

            item {
                HorizontalDivider(
                    modifier = Modifier.padding(bottom = Spacing.md),
                    thickness = DividerDefaults.Thickness,
                    color = DividerDefaults.color
                )
            }

            items(sectionItems) { demo ->
                DemoCard(
                    title = demo.title,
                    description = demo.description,
                    onClick = {
                        // Map demo id -> PlaygroundScreen (typed)
                        val screen = when (demo.id) {
                            "animated_button" -> PlaygroundScreen.AnimatedButton
                            "complex_lazy" -> PlaygroundScreen.ComplexLazy
                            "animation_basics" -> PlaygroundScreen.AnimatedButton // placeholder
                            "visibility_animation" -> PlaygroundScreen.ComplexLazy // placeholder
                            else -> PlaygroundScreen.Catalog
                        }
                        onOpenDemo(screen)
                    }
                )
            }
        }
    }
}

private fun groupDemos(demos: List<DemoItem>) = mapOf(
    "Basic Demos" to demos.filter { it.id in listOf("animated_button", "complex_lazy") },
    "Animation Demos" to demos.filter { it.id in listOf("animation_basics", "visibility_animation") }
)

@Preview(showBackground = true)
@Composable
fun CatalogScreenPreview() {
    ComposePlaygroundTheme {
        // preview lambda accepts PlaygroundScreen
        CatalogScreen(onOpenDemo = { /* no-op */ })
    }
}
