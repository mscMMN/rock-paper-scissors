package de.nakhlah.markus

import de.nakhlah.markus.player.Player

class Game(private val firstPlayer: Player, private val secondPlayer: Player, numberOfRounds: Int = 3) {

    init {
        if (numberOfRounds < 1) throw IllegalArgumentException("You must play at least one round!")
    }

    private val rounds = (1..numberOfRounds).map { Round(it) }

    fun play() {
        println("The game begins")

        rounds.forEach { it.play(firstPlayer, secondPlayer) }

        println("The game is over")

        val winsForFirstPlayer = rounds.count { firstPlayer == it.winner }
        val winsForSecondPlayer = rounds.count { secondPlayer == it.winner }
        val draws = rounds.count { it.isDraw }

        println("${firstPlayer.name} has won $winsForFirstPlayer times")
        println("${secondPlayer.name} has won $winsForSecondPlayer times")
        println("Out of ${rounds.size} rounds there have been $draws draws")
    }
}
