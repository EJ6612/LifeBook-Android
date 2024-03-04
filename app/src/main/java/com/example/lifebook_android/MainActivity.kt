package com.example.lifebook_android

import LifeEvent
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
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileReader
import java.io.FileWriter
class MainActivity : ComponentActivity(){

    companion object {
        val FILE_NAME = "lifeBook.json"
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
    private fun loadEvents(): List<LifeEvent> {
        // Return a default or empty list of events for now
        return emptyList()
    }

    fun saveNewEvent(event: LifeEvent) {
        try {
            val events = loadEvents().toMutableList()
            events.add(event)

            val json = Gson().toJson(events)
            FileWriter(File(filesDir, FILE_NAME)).use { it.write(json) }

            println("Event saved successfully")
        } catch (e: Exception) {
            println("Problem saving event: ${e.message}")
        }
    }


    fun loadCurrentEvents(v: View): List<LifeEvent> {
        val file = File(filesDir, FILE_NAME)
        if (!file.exists()) {
            return emptyList()
        }

        return try {
            val reader = FileReader(file)
            val eventType = object : TypeToken<List<LifeEvent>>() {}.type
            Gson().fromJson(reader, eventType)
        } catch (e: Exception) {
            println("Error loading events: ${e.message}")
            emptyList()
        }
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