class Select<T>(private val name: String, private val type: String) where T : Menu {
    private var point = -1

    companion object {
        private var itemArchive = -1
    }

    fun <T : Menu> selection(list: MutableList<T>) {
        while (true) {
            println(name)
            println(
                if (type == "archive") "0. Создать архив"
                else "0. Создать заметку"
            )

            if (list.isNotEmpty()) {
                list.forEach { println("${list.indexOf(it) + 1}. ${it.name}") }
            }
            println("${list.size + 1}. Выход")
            println("Введите номер пункта меню: ")

            if (scanner.hasNextInt()) {
                point = scanner.nextInt()
                scanner.nextLine()
                if (point !in 0..list.size + 1) {
                    println("Введен отсутствующий пункт меню, попробуйте еще")
                    continue
                }
            } else {
                scanner.next()
                println("Неверный ввод, выберете соотвествующий пункт меню.")
                continue
            }

            when (point) {
                0 -> createElement()
                list.size + 1 -> break
                else -> {
                    if (type == "archive") itemArchive = point - 1
                    showContent(list[point - 1])
                }
            }
        }

    }

    private fun createElement() {

        while (true) {
            if (type == "archive") {
                println("Введите название архива")
                Archive.listArchives.add(
                    Archive(
                        name = FunctionInput().userInput(),
                        mutableListOf()
                    )
                )
                break
            } else {
                println("Введите название заметки")
                val name = FunctionInput().userInput()
                println("Введите текст заметки")
                Archive.listArchives[itemArchive].listOfNotes.add(
                    Note(
                        name,
                        text = FunctionInput().userInput()
                    )
                )
                break
            }
        }
    }


    private fun <T : Menu> showContent(t: T) {
        if (t is Archive) {
            Note.selectNote.selection(Archive.listArchives[point - 1].listOfNotes)
        } else if (t is Note) {
            println("${t.text}\nВведите любой сивол для возврата к списку заметок")
            scanner.nextLine()
        }
    }


}




