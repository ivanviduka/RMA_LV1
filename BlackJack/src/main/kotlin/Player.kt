class Player (
    var cardsValue : Int = 0,
    var isPlaying : Boolean = true
)
{
    fun isOverTheLimit() : Boolean =  (cardsValue>21)

    fun stand() {
        isPlaying = false
    }

}