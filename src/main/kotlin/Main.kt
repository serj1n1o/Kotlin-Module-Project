import java.util.Scanner

val scanner = Scanner(System.`in`)
fun main(args: Array<String>) {

    Archive.selectArchive.selection(Archive.listArchives)
    scanner.close()
}

