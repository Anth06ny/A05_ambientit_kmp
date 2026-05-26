package com.amonteiro.a05_ambientit_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform