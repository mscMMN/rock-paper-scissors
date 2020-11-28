package de.nakhlah.markus.game

import de.nakhlah.markus.player.Player

class Game(private val firstPlayer: Player, private val secondPlayer: Player, numberOfRounds: Int = 3) {

    init {
        if (numberOfRounds < 1) throw IllegalArgumentException("You must play at least one round!")
    }

    private val rounds = (1..numberOfRounds).map { Round(it) }

    fun play() {
        println("The game between $firstPlayer and $secondPlayer begins")

        rounds.forEach { it.play(firstPlayer, secondPlayer) }

        println("The game is over")
        println()

        val winsForFirstPlayer = countWinsForPlayer(firstPlayer)
        val winsForSecondPlayer = countWinsForPlayer(secondPlayer)
        val draws = rounds.count { it.isDraw }

        println("$firstPlayer has won $winsForFirstPlayer times")
        println("$secondPlayer has won $winsForSecondPlayer times")
        println("Out of ${rounds.size} rounds there have been $draws draws")
        println()

        val overallWinner: Player? = determineOverallWinner(winsForFirstPlayer, winsForSecondPlayer)

        if (overallWinner != null) {
            println("The overall winner of this game is: $overallWinner")
        } else {
            println("No winner - no loser! Play again!")
        }
    }

    private fun determineOverallWinner(winsForFirstPlayer: Int, winsForSecondPlayer: Int) =
            if (winsForFirstPlayer == winsForSecondPlayer) null else if (winsForFirstPlayer > winsForSecondPlayer) firstPlayer else secondPlayer

    private fun countWinsForPlayer(firstPlayer: Player) = rounds.count { firstPlayer == it.winner }

}
