package chapter5

fun main(args: Array<String>) {
    runSimulation("Guyal", ::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2018
        println("Adding $numBuildings")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}

inline fun runSimulation(playerName: String,
                         costPrinter: (Int) -> Unit,
                         greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    costPrinter(numBuildings)
    println(greetingFunction(playerName, numBuildings))
}

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("construction cost: ${cost * numBuildings}")
}