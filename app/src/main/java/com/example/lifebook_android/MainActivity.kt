package com.example.lifebook_android

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lifebook_android.ui.theme.LifeBookAndroidTheme
import java.io.FileOutputStream

class MainActivity : ComponentActivity() {

    companion object {
        val FILE_NAME = "lifeBook.txt"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeBookAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }


    fun saveNewEvent(v: View) {
        var testData = "TEST"

        try {
            FileOutputStream(FILE_NAME).use {
                    stream -> stream.write(testData.toByteArray())
                println("Saved to file")
            }
        }
        catch (e: Exception) {
            println("Problem saving to file")
        }

    }

    fun loadCurrentEvents(v: View) {

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LifeBookAndroidTheme {
        Greeting("Android")
    }
}