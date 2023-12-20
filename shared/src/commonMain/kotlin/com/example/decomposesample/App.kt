package com.example.decomposesample

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.example.decomposesample.navigation.RootComponent
import com.example.decomposesample.screens.ScreenA
import com.example.decomposesample.screens.ScreenB
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(root: RootComponent) {
    MaterialTheme {

        val childStack by root.childStack.subscribeAsState()
        Children(
            stack = childStack,
            animation = stackAnimation(slide())
        ) { child ->
            when (val instance = child.instance) {
                is RootComponent.Child.ScreenA -> ScreenA(instance.component)
                is RootComponent.Child.ScreenB -> ScreenB(instance.component.text, instance.component)
            }
        }
    }
}