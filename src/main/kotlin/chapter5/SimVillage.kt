package chapter5

fun main(args: Array<String>) {
    runSimulation("Guyal") { playerName, numBuildings ->
        val currentYear = 2018
        println("Adding $numBuildings")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}

inline fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    println(greetingFunction(playerName, numBuildings))
}
