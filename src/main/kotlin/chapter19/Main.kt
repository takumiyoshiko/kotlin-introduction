package chapter19

fun main() {
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals
        .map { animal -> "A baby $animal" }
        .map { baby -> "$baby, with the cutest little tail ever" }
    println(babies)
    println(animals)

    val tenDollarWords = listOf("auspicious", "avuncular", "obviate")
    val tenDollarWordLengths = tenDollarWords.map { it.length }
    println(tenDollarWordLengths)
    println(tenDollarWords.size)
    println(tenDollarWordLengths.size)

    println(listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9)).flatMap { it })

    val itemsOfManyColors = listOf(
        listOf("red apple", "green apple", "blue apple"),
        listOf("red fish", "blue fish"),
        listOf("yellow banana", "teal banana")
    )
    val redItems = itemsOfManyColors.flatMap { it.filter { it.contains("red") } }
    println(redItems)

    val numbers = listOf(7, 4, 8, 4, 3, 22, 28, 11)
    val primes = numbers.filter { number ->
        (2 until number).map { number % it }
        .none { it == 0 }
        }
    println(primes)
}
