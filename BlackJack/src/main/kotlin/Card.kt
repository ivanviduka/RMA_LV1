import kotlin.random.Random

data class Card(
    val cardNumber : Int = Random.nextInt(2,11)
)