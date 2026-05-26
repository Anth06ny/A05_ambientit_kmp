package com.amonteiro.a05_ambientit_kmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource

import a05_ambientit_kmp.composeapp.generated.resources.Res
import a05_ambientit_kmp.composeapp.generated.resources.compose_multiplatform
import androidx.compose.ui.input.key.Key.Companion.R
import com.amonteiro.a05_ambientit_kmp.presentation.AppNavigation
import com.amonteiro.a05_ambientit_kmp.presentation.ui.theme.A26_04_ambientit_kotlinTheme

@Composable
@Preview
fun App() {
    A26_04_ambientit_kotlinTheme {
        AppNavigation()
    }
}