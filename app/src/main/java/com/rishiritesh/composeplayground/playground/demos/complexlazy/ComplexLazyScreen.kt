package com.rishiritesh.composeplayground.playground.demos.complexlazy

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rishiritesh.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun ComplexLazyScreen(modifier: Modifier = Modifier) {
    // sample data: 5 sections, each with a few items
    val sections = List(5) { sectionIndex ->
        "Section ${sectionIndex + 1}" to List(6) { itemIndex -> "Item ${itemIndex + 1} of S${sectionIndex + 1}" }
    }

    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        modifier = modifier
    ) {
        sections.forEach { (title, itemsList) ->
            // header
            item {
                Text(
                    text = title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
            }

            // items
            items(itemsList) { item ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
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
