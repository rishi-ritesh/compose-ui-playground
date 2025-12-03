package com.rishiritesh.composeplayground.playground.demos.animatedbutton

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.rishiritesh.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun AnimatedButtonScreen(modifier: Modifier = Modifier) {
    var toggled by remember { mutableStateOf(false) }
    val bg by animateColorAsState(targetValue = if (toggled) Color(0xFF4CAF50) else Color(0xFF2196F3))

    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, alignment = Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Animated Button Demo (simple placeholder)")
        Button(
            onClick = { toggled = !toggled },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = if (toggled) "Toggled" else "Tap me",
                color = Color.White
            )
        }

        // visual indicator using the animated color
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(bg)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedButtonPreview() {
    ComposePlaygroundTheme {
        AnimatedButtonScreen()
    }
}
