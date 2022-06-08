package chapter3

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoint = 89
    val isBlessed = true

    if (healthPoint == 100) {
        println(name + " is in excellent condition!")
    } else if (healthPoint >= 90) {
        println(name + " has a few scratches")
    } else if (healthPoint >= 75) {
        if (isBlessed) {
            println(name + " has some minor wounds but is healing quite quickly!")
        } else {
            println(name + " has some minor wounds.")
        }
    } else if (healthPoint >= 15) {
        println(name + "looks pretty hurt")
    } else {
        println(name + " is awful condition!")
    }

}