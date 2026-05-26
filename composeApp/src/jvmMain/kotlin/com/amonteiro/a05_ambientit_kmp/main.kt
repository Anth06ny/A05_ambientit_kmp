package com.amonteiro.a05_ambientit_kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.amonteiro.a05_ambientit_kmp.di.initKoin

fun main() = application {
    initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "A05_ambientit_kmp",
    ) {
        App()
    }
}