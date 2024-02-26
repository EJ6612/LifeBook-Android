package com.example.lifebook_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
    }
}
/*
    //file-save code
    companion object {
        val FILE_NAME = "lifeBook.txt"
    }
    fun saveNewEvent(v: View) {
        var testData = "TEST"

        try {
            FileOutputStream(MainActivity.FILE_NAME).use {
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

    //when + button is clicked
    //fun onCreateNewEventClicked(view: View) {
        //val intent = Intent(this, NewEventPage::class.java)
    //}//android:onClick="onCreateNewEventClicked"
} */