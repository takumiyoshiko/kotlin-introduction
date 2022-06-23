package chapter8

import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

//var playerGold = 10
//var playerSilver = 10
var dragonsBreath = 5 / 0.125
var dragoncoin = 5

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
    placeOrder("shandy,Dragon's Breath,5.91")
    placeOrder("shandy,Dragon's Breath,5.91")
}

fun performPurchase(price: Double): Boolean {
    displayBalance()
//    val totalPurse = playerGold + (playerSilver / 100.0)
//    println("Total purse: $totalPurse")
//    println("Purchasing item for $price")
    println("Total dragoncoin: $dragoncoin")

    val priceDragoncoin = price / 1.43
    println("price with dragoncoin: $priceDragoncoin")

    val remainingBalance = dragoncoin - priceDragoncoin
    if (remainingBalance < 0) {
        println("the customer is short on gold")
        return false
    }
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
//    playerGold  = remainingGold
//    playerSilver = remainingSilver
    displayBalance()
    return true
}

private fun displayBalance() {
//    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
    println("Player's purse balance: Dragoncoin: $dragoncoin")
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
        val soldDragonsBreath = 12
        dragonsBreath -= soldDragonsBreath
        println("Remaining Dragon's Breath: $dragonsBreath")
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