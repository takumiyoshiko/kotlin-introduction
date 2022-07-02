package chapter12

fun main(args: Array<String>) {


    val player = Player()
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
    println("${player.name} ${player.formatHealthStatus()}")
}




