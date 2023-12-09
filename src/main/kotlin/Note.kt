class Note(override val name: String, var text: String) : Menu {
    companion object {
        val selectNote: Select<Note> = Select("Список заметок:", "note")
    }
}
