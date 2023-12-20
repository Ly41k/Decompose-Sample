package com.example.decomposesample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform