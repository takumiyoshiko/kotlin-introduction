package chapter3

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoint = 89
    val isBlessed = true
    val isImmortal = false

    //Aura
    val auraVisible = isBlessed && healthPoint > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"

    val healthStatesWhen = when (healthPoint) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches"
        in 75..90 -> if (isBlessed) {
                "has some minor wounds but is healing quite quickly!"
            } else {
                "has some minor wounds."
            }
        in 15..74 -> "looks pretty hurt"
        else -> "is awful condition!"

    }

    val healthStates = if (healthPoint == 100) {
            "is in excellent condition!"
        } else if (healthPoint in 90..99) {
            "has a few scratches"
        } else if (healthPoint in 75..89) {
            if (isBlessed) {
                "has some minor wounds but is healing quite quickly!"
            } else {
                "has some minor wounds."
            }
        } else if (healthPoint in 15..74) {
            "looks pretty hurt"
        } else {
            "is awful condition!"
        }

    println("(Aura: $auraColor) " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatesWhen")

}