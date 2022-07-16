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

    val employees = listOf("Denny", "Claudette", "Peter")
    val shirtSize = listOf("large", "x-large", "medium")
    val employeeShirtSize = employees.zip(shirtSize).toMap()
    println(employeeShirtSize)

    val foldedValue = listOf(1,2,3,4).fold(0) { accumulator, number ->
        println("Accumulated value: $accumulator")
        accumulator + (number * 3)
    }
    println("Final value: $foldedValue")

    fun Int.isPrime(): Boolean {
        (2 until this).map {
            if (this % it == 0) {
                return false
            }
        }
        return true
    }

    val oneThousandPrimes = generateSequence(3) { value ->
        value + 1
    }.filter { it.isPrime() }.take(1000)

    println(oneThousandPrimes.toList().size)

    // challenge 19.6
    fun flipValues(map: Map<String, Double>): Map<Double, String> {
        return map.entries.associate { (key, value) -> value to key }
    }

    val gradesByStudent = mapOf("Josh" to 4.0, "Alex" to 2.0)
    println(flipValues(gradesByStudent))

}
