package com.example.lifebook_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.io.FileOutputStream

class EventsActivity : AppCompatActivity() {
    companion object {
        val FILE_NAME = "lifeBook.txt"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
    }

    fun saveNewEvent(v: View) {
        var testData = "TEST"

        try {
            FileOutputStream(EventsActivity.FILE_NAME).use {
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