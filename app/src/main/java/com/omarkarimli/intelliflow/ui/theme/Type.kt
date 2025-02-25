package com.omarkarimli.intelliflow.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

// Default Material 3 typography values
val baseline = Typography()

val textSnippets = TextSnippets()

// Set of Material typography styles to start with
val Typography = Typography(

    displayLarge = baseline.displayLarge.copy(fontFamily = textSnippets.displayFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = textSnippets.displayFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = textSnippets.displayFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = textSnippets.displayFontFamily, fontWeight = FontWeight.SemiBold, lineHeight = 1.2.em),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = textSnippets.displayFontFamily, fontWeight = FontWeight.SemiBold),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = textSnippets.displayFontFamily, fontWeight = FontWeight.SemiBold),
    titleLarge = baseline.titleLarge.copy(fontFamily = textSnippets.displayFontFamily, fontWeight = FontWeight.SemiBold),
    titleMedium = baseline.titleMedium.copy(fontFamily = textSnippets.displayFontFamily, fontWeight = FontWeight.SemiBold),
    titleSmall = baseline.titleSmall.copy(fontFamily = textSnippets.displayFontFamily, fontWeight = FontWeight.SemiBold),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = textSnippets.bodyFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = textSnippets.bodyFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = textSnippets.bodyFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = textSnippets.bodyFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = textSnippets.bodyFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = textSnippets.bodyFontFamily),

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)