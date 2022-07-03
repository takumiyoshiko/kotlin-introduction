
fun main(args: Array<String>) {

    val player = Player(name = "kar")
    player.healthPoints = 100
    player.castFireball()

    //Aura
    val auraColor = player.auraColor()

    val healthStates = player.formatHealthStatus()


    printPlayerStatus(player)

}

private fun printPlayerStatus(
    player: Player
) {
    println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("HP: ${player.healthPoints}, Hometown: ${player.homeTown}")
    println("${player.name} ${player.formatHealthStatus()}")
}




