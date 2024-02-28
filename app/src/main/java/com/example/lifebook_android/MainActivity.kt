package com.example.lifebook_android

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.lifebook_android.ui.theme.LifeBookAndroidTheme
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    companion object {
        val FILE_NAME = "lifeBook.txt"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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