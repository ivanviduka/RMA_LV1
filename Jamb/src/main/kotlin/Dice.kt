import kotlin.random.Random

class Dice (var value: Int=1, var isLocked: Boolean = false){


    fun rollDice() {

        this.value = Random.nextInt(1,6)
    }


}