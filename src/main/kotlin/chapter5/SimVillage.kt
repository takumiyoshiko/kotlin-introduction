package chapter5

fun main(args: Array<String>) {
    runSimulation()
}

inline fun runSimulation() {
    val greetingFunction = configurationGreetingFunction()
    println(greetingFunction("Guyal"))
}

fun configurationGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2018
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copylight $currentYear)"
    }
}