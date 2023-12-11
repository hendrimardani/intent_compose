package com.example.intentjetpackcompose

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.intentjetpackcompose.ui.theme.IntentJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    myApp()
                }
            }
        }
    }
}

@Composable
fun myApp() {
    // Call the intent
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first_screen") {
        composable(route = "first_screen") {
            firstScreen {
                // var $name for catch data from first_screen
                val name = if(it == "") "No Name" else it
                navController.navigate("second_screen/$name")
            }
        }
        composable(route = "second_screen/{name}") {
            val name = it.arguments?.getString("name") ?: "No Name"
            secondScreen(
                name,
                { navController.navigate("first_screen") },
                { navController.navigate("third_screen/$name") },
            )
        }
        composable(route = "third_screen/{name}") {
            val name = it.arguments?.getString("name") ?: "No Name"
            thirdScreen(
                name,
                { navController.navigate("first_screen") }
            )
        }
    }
}