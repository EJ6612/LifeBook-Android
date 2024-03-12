import android.view.View
import com.example.lifebook_android.MainActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class EventList(private val filesDir: File) {
    var taskList: MutableList<LifeEvent> = mutableListOf()

    companion object {
        val FILE_NAME = "lifeBook.json"
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
            FileWriter(File(filesDir, MainActivity.FILE_NAME)).use { it.write(json) }

            println("Event saved successfully")
        } catch (e: Exception) {
            println("Problem saving event: ${e.message}")
        }
    }


    fun loadCurrentEvents(v: View): List<LifeEvent> {
        val file = File(filesDir, MainActivity.FILE_NAME)
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