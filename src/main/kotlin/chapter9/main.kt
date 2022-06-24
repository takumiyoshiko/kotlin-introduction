package chapter9

import java.io.File


fun main(args: Array<String>) {
    // run
    fun nameIsLong(name: String) = name.length >= 20
    println("Madrigal".run(::nameIsLong))
    println("Polarcubis, Supreme Master of NyetHack".run(::nameIsLong))

    fun playerCreateMessage(nameTooLong: Boolean): String {
        return if (nameTooLong) {
            "Name is too long. Please choose another name"
        } else {
            "Welcome, adventure"
        }
    }
    "Polarcubis, Supreme Master of NyetHack"
        .run(::nameIsLong)
        .run(::playerCreateMessage)
        .run(::println)

    //with
    val nameTooLong = with("Polarcubis, Supreme Master of NyetHack") {
        length >= 20
    }
    println(nameTooLong)

    // also
    val fileContents: List<String>
    File("src/main/kotlin/chapter9/file.txt")
        .also {
            print(it.name)
        }.also {
            fileContents = it.readLines()
        }
    println(fileContents)

    // takeIf
    val fileContents2 = File("src/main/kotlin/chapter9/file.txt")
        .takeIf{ it.canRead() && it.canWrite()}
        ?.readText()
    println(fileContents2)

    // takeUnless
    val fileContents3 = File("src/main/kotlin/chapter9/file.txt").takeUnless { it.isHidden }?.readText()
    println(fileContents3)
}

