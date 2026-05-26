package com.amonteiro.a05_ambientit_kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "A05_ambientit_kmp",
    ) {
        App()
    }
}