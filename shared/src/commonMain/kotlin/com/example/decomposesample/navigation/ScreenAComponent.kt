package com.example.decomposesample.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class ScreenAComponent(
    componentContext: ComponentContext,
    private val onNavigationToScreenB: (String) -> Unit
) : ComponentContext by componentContext {

    private var _text = MutableValue("")
    val text: Value<String> = _text

    fun onEvent(event: ScreenAEvent) {
        when (event) {
            ScreenAEvent.ClickButtonA -> onNavigationToScreenB(text.value)
            is ScreenAEvent.UpdateText -> {
                _text.value = event.text
            }
        }
    }

}
