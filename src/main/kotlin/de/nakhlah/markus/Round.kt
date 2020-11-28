package de.nakhlah.markus

import de.nakhlah.markus.player.Player

data class Round(val number: Int) {
    var winner: Player? = null
        private set

    var isDraw: Boolean = false
        private set

    fun play(firstPlayer: Player, secondPlayer: Player) {
        val firstPlayerAction = firstPlayer.showAction()
        val secondPlayerAction = secondPlayer.showAction()

        isDraw = firstPlayerAction == secondPlayerAction

        if (!isDraw) {
            winner = if (firstPlayerAction.beats(secondPlayerAction)) firstPlayer else secondPlayer
        }
    }

}

private fun Action.beats(otherAction: Action): Boolean = when (this) {
    Action.PAPER -> Action.ROCK == otherAction
    Action.ROCK -> Action.SCISSORS == otherAction
    Action.SCISSORS -> Action.PAPER == otherAction
}
