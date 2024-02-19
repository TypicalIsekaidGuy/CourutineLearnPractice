package com.example.courutinelearnpractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.courutinelearnpractice.ui.theme.CourutineLearnPracticeTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourutineLearnPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting( ) {

    var corvalue1 by remember{mutableStateOf(111111110)}
    var corvalue2 by remember{mutableStateOf(111111110)}
    Text(
        text = "first is $corvalue1, second is $corvalue2",
        modifier = Modifier,
    )
    Button(onClick = { MainScope().launch {corvalue1 =  fetch() }},modifier = Modifier.size(64.dp)) {

    }
}
suspend fun fetch(): Int{
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL1).build()
    val response: Service1 = retrofit.create(Service1::class.java)
    Log.d("MAIN",response.get())
    return response.get().body()?.id ?: 0
}
data class Response1(
    val userId: Int,
    val  id: Int,
    val  title: String,
    val  completed: Boolean
)
data class Response2(
    val count: Int,
    val  entries: map
    )
data class map(
    val API: String,
    val Description: String,
    val Auth: String,
    val HTTPS: Boolean,
    val Cors: String,
    val Link: String,
    val Category: String
)
private const val BASE_URL1 =
    "https://jsonplaceholder.typicode.com/todos/1/"
private const val BASE_URL2 =
    "https://api.publicapis.org/entries/"

interface Service1 {
    @GET("/")
    suspend fun get(): Response<Response1>
}