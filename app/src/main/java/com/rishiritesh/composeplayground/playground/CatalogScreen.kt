package com.rishiritesh.composeplayground.playground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rishiritesh.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun CatalogScreen(
    modifier: Modifier = Modifier,
    onOpenDemo: (demoId: String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, alignment = Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Compose UI Playground", modifier = Modifier.padding(bottom = 8.dp))
        Button(onClick = { onOpenDemo("animated_button") }) {
            Text("Animated Button (demo)")
        }
        Button(onClick = { onOpenDemo("complex_lazy") }) {
            Text("Complex LazyColumn (demo)")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CatalogScreenPreview() {
    ComposePlaygroundTheme {
        CatalogScreen()
    }
}
