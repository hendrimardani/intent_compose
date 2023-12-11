package com.example.intentjetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.intentjetpackcompose.ui.theme.IntentJetpackComposeTheme

// param toSecondScreen is intent to first screen
@Composable
fun secondScreen(name: String, toFirstScreen: () -> Unit, toThirdScreen: (String) -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the second screen !!!")
        Text(text = "Welcome ${name} at the second screen", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(6.dp))
        Button(onClick = {
            toFirstScreen()
        }) {
            Text(text = "Go to first screen")
        }
        Button(onClick = {
            toThirdScreen(name)
        }) {
            Text(text = "GO to third screen")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun secondScreenPreview() {
    IntentJetpackComposeTheme {
        secondScreen("Jojon", {}, {})
    }
}