package de.nakhlah.markus

import de.nakhlah.markus.game.Action
import de.nakhlah.markus.game.Game
import de.nakhlah.markus.player.Player
import de.nakhlah.markus.player.PlayerStrategyFixed

fun main() {
    println("Welcome to Rock, Paper, Scissors!")

    val firstPlayer = Player("Markus")
    val secondPlayer = Player("The Rock™", PlayerStrategyFixed(Action.ROCK))

    val statistics = Game(firstPlayer, secondPlayer, 100).play()

    statistics.print()
}

