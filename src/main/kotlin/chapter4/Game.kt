package chapter4

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoint = 89
    val isBlessed = true
    val isImmortal = false

    //Aura
    val auraColor = auraColor(isBlessed, healthPoint, isImmortal)

    val healthStates = formatHealthStatus(healthPoint, isBlessed)


    printPlayerStatus(auraColor=auraColor, isBlessed=isBlessed, name=name, healthStates=healthStates)

    castFireball()
    TODO()
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStates: String
) {
    println("(Aura: $auraColor) " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStates")
}

private fun auraColor(isBlessed: Boolean, healthPoint: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoint > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}

private fun formatHealthStatus(healthPoint: Int, isBlessed: Boolean) =
    when (healthPoint) {
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


private fun castFireball(numFireballs: Int = 2) {
    println("A glass of fireball springs into existence. (x$numFireballs)")
}