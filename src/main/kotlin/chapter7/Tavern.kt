package chapter7

const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
    placeOrder("elixir,Shirley's Temple,4.12")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price"
    println(message)

//    val phrase = "Ah, delicious $name!"
//    println("Madrigal exclaims: ${toDragonSpeak(phrase)}

    val phrase = if (name == "Dragon's Breath") {
//        "Madrigal exclaims ${toDragonSpeak("Ah delicious $name")}"
        "Madrigal exclaims ${toDragonSpeak("DRAGON'S BREATH: IT`SGOTWHATADVENTURES CRAVE")}"
    } else {
        "Madrigal says: Thanks for the $name"
    }
    println(phrase)

}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value) {
            "a" -> "4"
            "A" -> "4"
            "e" -> "3"
            "E" -> "3"
            "i" -> "1"
            "I" -> "1"
            "o" -> "0"
            "O" -> "0"
            "u" -> "|_|"
            "U" -> "|_|"
            else -> it.value
        }
    }