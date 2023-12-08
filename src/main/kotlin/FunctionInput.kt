class FunctionInput {
    fun userInput(): String {
        while (true) {
            val name = scanner.nextLine()
            if (name.isBlank()) {
                println("Содержимое не может быть пустым\nПовторите ввод:")
                continue
            }
            return name
        }
    }
}