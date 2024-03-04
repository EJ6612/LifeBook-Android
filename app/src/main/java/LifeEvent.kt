open class LifeEvent {
    var eventName: String = ""
        get() = field
        set(value) { field = value }
    var eventDate: String = ""
        get() = field
        set(value) { field = value }
    var eventDetails: String = ""
        get() = field
        set(value) { field = value }
    var eventLocation: String = ""
        get() = field
        set(value) { field = value }

    var taskList: MutableList<LifeEvent> = mutableListOf()
    fun saveEvent(newTask: LifeEvent) {
        taskList.add(newTask)
    }
}

// properties -> info
    // name of event, time/date, explanation, location
// save to list