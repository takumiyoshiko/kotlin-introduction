import com.bignerdranch.nyethack.Room
import com.bignerdranch.nyethack.TownSquare

fun main(args: Array<String>) {

    val player = Player(name = "Madrigal")
    player.healthPoints = 100
    player.castFireball()

    var currentRoom: Room = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

    //Aura
    val auraColor = player.auraColor()

    val healthStates = player.formatHealthStatus()


    printPlayerStatus(player)

    var room = Room("Foyer")
    println(room is Room)
    println(room is TownSquare)

    var townSquare = TownSquare()
    println(townSquare is TownSquare)
    println(townSquare is Room)

    var className = when(townSquare) {
        is Room -> "Room"
        else -> throw java.lang.IllegalArgumentException()
    }
    println(className)
}

private fun printPlayerStatus(
    player: Player
) {
    println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("HP: ${player.healthPoints}, Hometown: ${player.homeTown}")
    println("${player.name} ${player.formatHealthStatus()}")
}




