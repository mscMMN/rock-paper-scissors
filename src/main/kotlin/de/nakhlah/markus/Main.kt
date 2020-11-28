package de.nakhlah.markus

import de.nakhlah.markus.player.Player
import de.nakhlah.markus.player.PlayerStrategyFixed
import de.nakhlah.markus.player.PlayerStrategyRandom

fun main(args: Array<String>) {
    println("Welcome to Rock, Paper, Scissors!")

    val firstPlayer = Player("Markus")
    val secondPlayer = Player("The Rock™", PlayerStrategyFixed(Action.ROCK))

    Game(firstPlayer, secondPlayer, 100).play()
}

