package de.nakhlah.markus.game

data class Statistics(val firstPlayerWins: Int, val secondPlayerWins: Int, val numberOfDraws: Int) {
    fun print() {
        println("Player one has won $firstPlayerWins times")
        println("Player two has won $secondPlayerWins times")
        println("Out of ${firstPlayerWins + secondPlayerWins + numberOfDraws} rounds there have been $numberOfDraws draws")
        println()

        val overallWinner: String? = determineOverallWinner(firstPlayerWins, secondPlayerWins)

        if (overallWinner != null) {
            println("The overall winner of this game is: $overallWinner")
        } else {
            println("No winner - no loser! Play again!")
        }
    }

    private fun determineOverallWinner(winsForFirstPlayer: Int, winsForSecondPlayer: Int) =
            if (winsForFirstPlayer == winsForSecondPlayer) null else if (winsForFirstPlayer > winsForSecondPlayer) "Player one" else "Player two"

}
