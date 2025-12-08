package com.rishiritesh.composeplayground.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme

// --- Core color tokens (tune these later if you like) ---
val md_blue_40 = Color(0xFF4661F2)
val md_blue_80 = Color(0xFFD7DEFF)
val md_purple_40 = Color(0xFF6750A4)
val md_purple_80 = Color(0xFFD0BCFF)

val md_gray_10 = Color(0xFF121212)
val md_gray_20 = Color(0xFF1C1B1F)
val md_gray_30 = Color(0xFF2A2A2E)
val md_gray_90 = Color(0xFFE6E1E5)

val success = Color(0xFF4CAF50)
val error = Color(0xFFB00020)
val surfaceTint = md_purple_40

// --- Light color scheme (semantic) ---
val LightColorTokens = lightColorScheme(
    primary = md_purple_40,
    onPrimary = Color.White,
    secondary = Color(0xFF625B71),
    onSecondary = Color.White,
    background = Color(0xFFF7F5FF),
    onBackground = md_gray_20,
    surface = Color.White,
    onSurface = md_gray_20,
    surfaceTint = surfaceTint,
    error = error,
    onError = Color.White
)

// --- Dark color scheme (semantic) ---
val DarkColorTokens = darkColorScheme(
    primary = md_purple_80,
    onPrimary = md_purple_40,
    secondary = Color(0xFFCCC2DC),
    onSecondary = md_gray_20,
    background = md_gray_20,
    onBackground = md_gray_90,
    surface = md_gray_10,
    onSurface = md_gray_90,
    surfaceTint = surfaceTint,
    error = error,
    onError = Color.Black
)
