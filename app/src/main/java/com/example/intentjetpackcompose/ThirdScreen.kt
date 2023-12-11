package com.example.intentjetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.intentjetpackcompose.ui.theme.IntentJetpackComposeTheme

@Composable
fun thirdScreen(name:String, toFirstScreen: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Klik this button for go to first screen")
        Text(text = "Hello ${name}")
        Button(onClick = { toFirstScreen() }) {
            Text(text = "Go to first screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun thirdScreenPreview() {
    IntentJetpackComposeTheme{
        thirdScreen("Hendri",  {})
    }
}