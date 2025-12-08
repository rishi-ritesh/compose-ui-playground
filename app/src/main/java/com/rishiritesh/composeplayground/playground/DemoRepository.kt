package com.rishiritesh.composeplayground.playground

object DemoRepository {
    val demos: List<DemoItem> = listOf(
        DemoItem(
            id = "animated_button",
            title = "Animated Button",
            description = "A simple animated color-changing button"
        ),
        DemoItem(
            id = "complex_lazy",
            title = "Complex LazyColumn",
            description = "Section headers + cards inside a large list"
        ),
        DemoItem(
            id = "animation_basics",
            title = "Animation Basics",
            description = "Demonstrates animate*AsState & simple transitions"
        ),
        DemoItem(
            id = "visibility_animation",
            title = "Visibility Animation",
            description = "AnimatedVisibility, expand/shrink animations"
        )
    )
}
