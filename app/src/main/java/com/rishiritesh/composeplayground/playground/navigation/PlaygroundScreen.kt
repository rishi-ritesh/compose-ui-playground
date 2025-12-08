package com.rishiritesh.composeplayground.playground.navigation

/**
 * Typed navigation model for the Playground.
 * - route: unique stable string used by NavHost
 * - title: optional human label (useful for top bars)
 */
sealed class PlaygroundScreen(val route: String, val title: String = "") {
    object Catalog : PlaygroundScreen("catalog", "Catalog")
    object AnimatedButton : PlaygroundScreen("animated_button", "Animated Button")
    object ComplexLazy : PlaygroundScreen("complex_lazy", "Complex LazyColumn")

    // Add new screens here as objects:
     object AnimationBasics : PlaygroundScreen("animation_basics", "Animation Basics")
}
