import kotlin.system.exitProcess

fun main() {

    val gamingDices = createGamingDices()

    for(x in 1..3) {

        rollDices(gamingDices)

        printValues(gamingDices)

        checkLocking(gamingDices)

    }

    checkResults(gamingDices)

    exitProcess(0)




}




fun createGamingDices () : MutableList<Dice> {

    var dices = mutableListOf<Dice>()

    for(x in 0..5) dices.add(Dice())

    return dices

}

fun rollDices(dices:MutableList<Dice>){

    for (dice in dices){

        if(dice.isLocked)
            continue
        else
            dice.rollDice()

    }

}

fun printValues(dices:MutableList<Dice>){

    for (dice in dices) println("This dice value is ${dice.value}.")
}


fun checkLocking(dices:MutableList<Dice>){

    var decision : String?


    for (dice in dices){

        if(!dice.isLocked){

            println("Do you want to lock this dice with a value ${dice.value}? [y/n]")

            decision = readLine()

            if (decision.equals("y")) {
                dice.isLocked = true
            }
        }

    }

}

fun checkResults (dices:MutableList<Dice>) {

    if (isJamb(dices)) println("You scored JAMB!")

    else if(isPoker(dices)) println("You scored Poker!")

    else if(isTris(dices)) println("You scored Tris!")

    else println("Better luck next timw!")

}



fun isTris (dices:MutableList<Dice>) : Boolean{

    val arrayOfValues = IntArray(6);

    for (dice in dices){

        when(dice.value){
            1 -> arrayOfValues[0]++
            2 -> arrayOfValues[1]++
            3 -> arrayOfValues[2]++
            4 -> arrayOfValues[3]++
            5 -> arrayOfValues[4]++
            else -> arrayOfValues[5]++

        }

    }

    return arrayOfValues.contains(3)

}

fun isPoker (dices:MutableList<Dice>) : Boolean{

    val arrayOfValues = IntArray(6);

    for (dice in dices){

        when(dice.value){
            1 -> arrayOfValues[0]++
            2 -> arrayOfValues[1]++
            3 -> arrayOfValues[2]++
            4 -> arrayOfValues[3]++
            5 -> arrayOfValues[4]++
            else -> arrayOfValues[5]++

        }

    }

    return arrayOfValues.contains(4)

}

fun isJamb (dices:MutableList<Dice>) : Boolean{

    val arrayOfValues = IntArray(6);

    for (dice in dices){

        when(dice.value){
            1 -> arrayOfValues[0]++
            2 -> arrayOfValues[1]++
            3 -> arrayOfValues[2]++
            4 -> arrayOfValues[3]++
            5 -> arrayOfValues[4]++
            else -> arrayOfValues[5]++

        }

    }

    return arrayOfValues.contains(5)

}

