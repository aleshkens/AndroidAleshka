package ru.andrewkir.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.andrewkir.main.presentation.screen.GoodsScreen
import ru.andrewkir.main.presentation.theme.Saturday10Theme

class MainActivity : ComponentActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)


    enableEdgeToEdge()
    setContent {
      Saturday10Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Column(modifier = Modifier.padding(innerPadding)) {
            GoodsScreen()
          }
        }
      }
    }
  }

  @Preview(showBackground = true)
  @Composable
  fun GreetingPreview() {
    Saturday10Theme {
      GoodsScreen()
    }
  }
}