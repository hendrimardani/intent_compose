package com.example.intentjetpackcompose

import android.widget.Space
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.intentjetpackcompose.ui.theme.IntentJetpackComposeTheme

// Param toSecondScreen is intent to second screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun firstScreen(toSecondScreen: (String) -> Unit) {
    val name = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the first screen !!!")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = name.value, onValueChange = {
            name.value = it
        }, label = { Text(text = "Enter name") })
        Spacer(modifier = Modifier.height(6.dp))
        Button(onClick = {
            // Send data to secondScreen
            toSecondScreen(name.value)
        }) {
            Text(text = "Go to second screen")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun firstScreenPreview() {
    IntentJetpackComposeTheme {
        firstScreen({})
    }
}