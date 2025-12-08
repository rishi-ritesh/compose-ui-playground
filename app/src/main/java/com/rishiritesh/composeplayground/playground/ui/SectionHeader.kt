package com.rishiritesh.composeplayground.playground.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rishiritesh.composeplayground.ui.theme.Spacing

/**
 * Small, reusable section header for Catalog and other lists.
 * Title is required. Optional subtitle can be null or blank.
 */
@Composable
fun SectionHeader(
    title: String,
    subtitle: String? = null,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(vertical = Spacing.xs)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium
        )

        if (!subtitle.isNullOrBlank()) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.75f),
                modifier = Modifier.padding(top = Spacing.xs)
            )
        }
    }
}
