open class Archive(override val name: String, val listOfNotes: MutableList<Note>) : Menu {
    companion object {
        val selectArchive: Select<Archive> = Select("Список архивов:", "archive")
        val listArchives = mutableListOf<Archive>()
    }
}