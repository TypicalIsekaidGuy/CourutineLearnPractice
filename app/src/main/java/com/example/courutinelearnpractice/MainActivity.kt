package com.example.courutinelearnpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.courutinelearnpractice.ui.theme.CourutineLearnPracticeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var corvalue1 by mutableStateOf(111111110)
        var corvalue2 by mutableStateOf(111111110)
        setContent {
            CourutineLearnPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(corvalue1,corvalue2)
                }
            }
        }
    }
}

@Composable
fun Greeting( cor1: Int, cor2: Int) {
    Text(
        text = "first is $cor1, second is $cor2",
        modifier = Modifier,
    )
    Button(onClick = { /*TODO*/ }) {

    }
}
suspend fun fetch(){
    GlobalScope.launch{
        launch {

        }
    }
}

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"
