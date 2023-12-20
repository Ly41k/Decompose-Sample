package com.example.decomposesample.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.decomposesample.navigation.ScreenBComponent


@Composable
fun ScreenB(text: String, component: ScreenBComponent) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Screen B: $text")
        Button(onClick = {
            component.goBack()
        }) {
            Text("Go back")
        }
    }
}
