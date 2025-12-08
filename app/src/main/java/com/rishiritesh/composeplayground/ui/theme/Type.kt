package com.rishiritesh.composeplayground.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * App-wide typography scale.
 * Clean, modern, slightly enhanced version of Material3 defaults.
 */
val AppTypography = Typography(

    // Headlines
    headlineLarge = Typography().headlineLarge.copy(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    headlineMedium = Typography().headlineMedium.copy(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    headlineSmall = Typography().headlineSmall.copy(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),

    // Titles
    titleLarge = Typography().titleLarge.copy(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
    ),
    titleMedium = Typography().titleMedium.copy(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
    ),
    titleSmall = Typography().titleSmall.copy(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
    ),

    // Body text
    bodyLarge = Typography().bodyLarge.copy(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp
    ),
    bodyMedium = Typography().bodyMedium.copy(
        fontFamily = FontFamily.Default,
        fontSize = 14.sp
    ),
    bodySmall = Typography().bodySmall.copy(
        fontFamily = FontFamily.Default,
        fontSize = 12.sp
    ),

    // Labels (buttons, chips)
    labelLarge = Typography().labelLarge.copy(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium
    )
)
