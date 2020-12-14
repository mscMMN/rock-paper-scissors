package de.nakhlah.markus.game

import de.nakhlah.markus.player.Player

class Game(private val firstPlayer: Player, private val secondPlayer: Player, numberOfRounds: Int = 3) {

    init {
        if (numberOfRounds < 1) throw IllegalArgumentException("You must play at least one round!")
    }

    val rounds = (1..numberOfRounds).map { Round(it) }

    fun play(): Statistics {
        println("The game between $firstPlayer and $secondPlayer begins")

        rounds.forEach { it.play(firstPlayer, secondPlayer) }

        println("The game is over")
        println()

        return calculateStatistics()
    }

    private fun calculateStatistics(): Statistics {
        val winsForFirstPlayer = countWinsForPlayer(firstPlayer)
        val winsForSecondPlayer = countWinsForPlayer(secondPlayer)
        val draws = rounds.count { it.isDraw }

        return Statistics(winsForFirstPlayer, winsForSecondPlayer, draws)
    }

    private fun countWinsForPlayer(firstPlayer: Player) = rounds.count { firstPlayer == it.winner }

}
