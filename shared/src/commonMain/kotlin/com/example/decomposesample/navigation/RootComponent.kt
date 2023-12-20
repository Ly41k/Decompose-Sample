package com.example.decomposesample.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    private val navigation = StackNavigation<Configuration>()

    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.ScreenA,
        handleBackButton = true,
        childFactory = ::createChild
    )

    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
        return when (config) {
            Configuration.ScreenA -> Child.ScreenA(ScreenAComponent(
                componentContext = context,
                onNavigationToScreenB = {
                    navigation.pushNew(Configuration.ScreenB(it))
                }
            ))

            is Configuration.ScreenB -> Child.ScreenB(ScreenBComponent(
                text = config.text,
                componentContext = context,
                onGoBack = {
                    navigation.pop()
                }
            ))
        }
    }

    sealed class Child {
        data class ScreenA(val component: ScreenAComponent) : Child()
        data class ScreenB(val component: ScreenBComponent) : Child()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object ScreenA : Configuration()

        @Serializable
        data class ScreenB(val text: String) : Configuration()
    }

}