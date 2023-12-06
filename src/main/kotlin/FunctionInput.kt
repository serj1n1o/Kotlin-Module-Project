class FunctionInput {
    fun userInput(): String {
        while (true) {
            val name = scanner.nextLine()
            if (name.isEmpty()) {
                println("Содержимое не может быть пустым\nПовторите ввод:")
                continue
            }
            return name
        }
    }
}