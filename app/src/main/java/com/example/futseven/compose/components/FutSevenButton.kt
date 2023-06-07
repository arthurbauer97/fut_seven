package com.example.futseven.compose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FutSevenButton(text: String, onclick: () -> Unit, isSecondary: Boolean = false) {
    val buttonColors = if (isSecondary) {
        ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = MaterialTheme.colors.onSecondary
        )
    } else {
        ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary
        )
    }

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        onClick = { onclick },
        colors = buttonColors
    ) {
        Text(text = text)
    }
}

