package chapter10

import chapter8.dragoncoin
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

val patronList = listOf("Eli", "Mordoc", "Sophie")



fun main(args: Array<String>) {
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says : Elis isn't here.")
    }
    placeOrder("shandy,Dragon's Breath,5.91")
}

fun performPurchase(price: Double): Boolean {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    if (remainingBalance < 0) {
        println("the customer is short on gold")
        return false
    }
    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold  = remainingGold
    playerSilver = remainingSilver
    displayBalance()
    return true
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price"
    println(message)

    val canPurchase = performPurchase(price.toDouble())

    if (canPurchase) {
        val phrase = if (name == "Dragon's Breath") {
            "Madrigal exclaims ${toDragonSpeak("DRAGON'S BREATH: IT`SGOTWHATADVENTURES CRAVE")}"
        } else {
            "Madrigal says: Thanks for the $name"
        }
        println(phrase)
    }
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value) {
            "a", "A" -> "4"
            "e", "E" -> "3"
            "i", "I" -> "1"
            "o", "O" -> "0"
            "u", "U" -> "|_|"
            else -> it.value
        }
    }