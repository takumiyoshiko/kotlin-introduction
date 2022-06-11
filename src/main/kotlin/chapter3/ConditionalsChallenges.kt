package chapter3

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoint = 89
    val isBlessed = true
    val isImmortal = false
    val karma = (Math.pow(Math.random(), (110 - healthPoint) / 100.0) * 20).toInt()
    println(karma)

    //Aura
    val auraVisible = isBlessed && healthPoint > 50 || isImmortal
    val auraColor = when(karma) {
        in 0..5 -> "RED"
        in 6..10 -> "ORANGE"
        in 11..15 -> "PURPLE"
        in 16..20 -> "GREEN"
        else -> "NONE"
    }



    val healthStates = when (healthPoint) {
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

    val statusFormatString = "(HP: $healthPoint)(Aura: $auraColor) -> $healthStates"

    println(statusFormatString)

}