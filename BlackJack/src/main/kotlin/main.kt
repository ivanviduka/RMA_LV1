import kotlin.system.exitProcess

fun main() {

    val humanPlayer = Player()
    val dealer = Player()

    startTheGame(humanPlayer, dealer)

    while(isValid(humanPlayer, dealer)) {

        showCurrentValues(humanPlayer, dealer)

        drawingPlayersCard(humanPlayer)

        drawingDealersCard(dealer)

    }

    showCurrentValues(humanPlayer, dealer)

    declareWinner(humanPlayer, dealer)

    exitProcess(0)

}




fun startTheGame(player1 : Player, player2 : Player) {

    val firstCard = Card()
    val secondCard = Card()

    player1.cardsValue = firstCard.cardNumber
    player2.cardsValue = secondCard.cardNumber
}

fun isValid (player1 : Player, player2 : Player) : Boolean {

    if(player1.isOverTheLimit() || player2.isOverTheLimit() ) return false

    if( !player1.isPlaying && !player2.isPlaying) return false

    return true

}

fun showCurrentValues(player1 : Player, player2 : Player) {

    println("Player has a cards value of ${player1.cardsValue}")
    println("Dealer has a cards value of ${player2.cardsValue}")
}

fun drawingPlayersCard(player: Player){

    if(player.isPlaying){

        val answer: String?

        println("Do you want another card? [y/n]")

        answer = readLine()

        if ( answer.equals("y") ){

            val newCard = Card()

            player.cardsValue += newCard.cardNumber

        }

        else player.stand()

    }

}

fun drawingDealersCard(dealer: Player){

    if(dealer.cardsValue < 17) {

        val newCard = Card()

        if( (newCard.cardNumber == 11) && ((dealer.cardsValue + newCard.cardNumber) > 21) ) dealer.cardsValue += 1


        else dealer.cardsValue += newCard.cardNumber

    }

    else
        dealer.stand()

}

fun declareWinner(player : Player, dealer : Player) {

    if(player.isOverTheLimit() || (player.cardsValue < dealer.cardsValue) ) println("Dealer wins!")

    else if (dealer.isOverTheLimit() || (player.cardsValue > dealer.cardsValue) ) println("Player wins!")

    else println("Its a tie!")


}