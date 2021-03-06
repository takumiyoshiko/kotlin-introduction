package chapter11

import chapter8.dragoncoin
import kotlin.math.roundToInt
import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-data.txt").readText().split("\n")
val patronGold = mutableMapOf<String, Double>()


fun main(args: Array<String>) {
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says : Elis isn't here.")
    }

    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }

    //Challenge 10.11
    var formattedMenuList1 = "*** Welcome to Taernyl's Folly ***\n"

    menuList.forEach {
        val (type, name,price) = it.split(",")
        val wordList = name.split(" ")
        var formattedName: String = ""
        wordList.forEach {
            formattedName += it.capitalize() + " "
        }
        formattedMenuList1 += formattedName + "*".repeat(21 - formattedName.length) + "%10s".format(price).replace(" ", "*") + "\n"
    }
    println(formattedMenuList1)

    //Challenge 10.12
    var formattedMenuList2 = "*** Welcome to Taernyl's Folly ***\n"

    var beforeType: String = ""
    menuList.sorted().forEach {
        val (type, name,price) = it.split(",")
        if (beforeType != type) {
            var spaceNum = ((31 - 4 - type.length) / 2).toInt()
            formattedMenuList2 += " ".repeat(spaceNum) + "~[$type]~\n"
        }
        beforeType = type
        val wordList = name.split(" ")
        var formattedName: String = ""
        wordList.forEach {
            formattedName += it.capitalize() + " "
        }
        formattedMenuList2 += formattedName + "*".repeat(21 - formattedName.length) + "%10s".format(price).replace(" ", "*") + "\n"
    }
    println(formattedMenuList2)


    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    println(uniquePatrons)

    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }

    displayPatronBalances()

}

fun displayPatronBalances() {
    var debtorList = mutableListOf<String>()
    patronGold.forEach { patron, balance ->
        if (balance < 0) {
            println("$patron, balance: ${"%.2f".format(balance)}")
            println("You don't have enough money! Get away!")
            debtorList.add(patron)
        } else {
            println("$patron, balance: ${"%.2f".format(balance)}")
        }
    }
    debtorList.forEach {patron ->
        patronGold.remove(patron)
        uniquePatrons.remove(patron)
    }
}

fun performPurchase(price: Double, patronName: String){
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price"
    println(message)

    performPurchase(price.toDouble(), patronName)

    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims ${toDragonSpeak("DRAGON'S BREATH: IT`SGOTWHATADVENTURES CRAVE")}"
    } else {
        "$patronName says: Thanks for the $name"
    }
    println(phrase)

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