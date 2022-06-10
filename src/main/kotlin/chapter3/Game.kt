package chapter3

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoint = 89
    val isBlessed = true
    val isImmortal = false

    //Aura
    val auraVisible = isBlessed && healthPoint > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    println(auraColor)

    val healthStates = if (healthPoint == 100) {
            " is in excellent condition!"
        } else if (healthPoint in 90..99) {
            " has a few scratches"
        } else if (healthPoint in 75..89) {
            if (isBlessed) {
                " has some minor wounds but is healing quite quickly!"
            } else {
                " has some minor wounds."
            }
        } else if (healthPoint in 15..74) {
            "looks pretty hurt"
        } else {
            " is awful condition!"
        }
    println(name + " " + healthStates)

}