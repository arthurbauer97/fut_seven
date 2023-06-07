package com.example.futseven

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.futseven.compose.components.FutSevenButton
import com.example.futseven.ui.theme.FutSevenTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FutSevenTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var nickName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .padding(24.dp)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = nickName,
            onValueChange = { nickName = it },
            maxLines = 1,
            label = {
                Text(text = stringResource(R.string.login_screen_label_nickname))
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            maxLines = 1,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        imageVector = if (passwordVisibility) Icons.Filled.Lock else Icons.Filled.Lock,
                        contentDescription = if (passwordVisibility) "Hide Password" else "Show Password"
                    )
                }
            },
            label = {
                Text(text = stringResource(R.string.login_screen_label_password))
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        FutSevenButton(
            text = stringResource(R.string.login_screen_button_enter),
            onclick = {
              TODO()
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = stringResource(R.string.login_screen_forgot_password))
    }
}


@Preview("login 1", showBackground = true)
@Composable
fun DefaultPreview() {
    FutSevenTheme {
        LoginScreen()
    }
}

