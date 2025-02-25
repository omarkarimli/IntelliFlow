package com.omarkarimli.intelliflow.ui.theme

import androidx.compose.ui.text.font.FontFamily
import com.omarkarimli.intelliflow.R
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight

class TextSnippets {

    private val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_light, FontWeight.Light),
        Font(R.font.poppins_regular, FontWeight.Normal),
        Font(R.font.poppins_medium, FontWeight.Medium),
        Font(R.font.poppins_bold, FontWeight.Bold),
    )

    val displayFontFamily = poppinsFontFamily
    val bodyFontFamily = poppinsFontFamily
}
