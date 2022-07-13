package chapter18

fun main() {
//    print(frame("Welcome, Madrigal", 5 ))
    print("Welcome, Madrigal".frame(5))
}

fun String.frame(padding: Int, formatChar: String = "*"): String {
    val greeting = this
    val middle = formatChar.padEnd(padding)
        .plus(greeting)
        .plus(formatChar.padStart(padding))
    val end = (0 until middle.length).joinToString("") {formatChar}
    return "$end\n$middle\n$end"
}
//
//fun frame(name: String, padding: Int, formatChar: String = "*"): String {
//    val greeting = "$name!"
//    val middle = formatChar.padEnd(padding)
//        .plus(greeting)
//        .plus(formatChar.padStart(padding))
//    val end = (0 until middle.length).joinToString("") {formatChar}
//    return "$end\n$middle\n$end"
//}