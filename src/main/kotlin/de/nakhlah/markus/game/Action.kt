package de.nakhlah.markus.game

enum class Action {
    ROCK,
    PAPER,
    SCISSORS,
    SPOCK,
    LIZARD
}

fun Action.beats(otherAction: Action): Boolean = when (this) {
    Action.PAPER -> otherAction in setOf(Action.ROCK, Action.SPOCK)
    Action.ROCK -> otherAction in setOf(Action.SCISSORS, Action.LIZARD)
    Action.SCISSORS -> otherAction in setOf(Action.PAPER, Action.LIZARD)
    Action.LIZARD -> otherAction in setOf(Action.PAPER, Action.SPOCK)
    Action.SPOCK -> otherAction in setOf(Action.ROCK, Action.SCISSORS)
}
