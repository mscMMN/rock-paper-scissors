package de.nakhlah.markus.game

enum class Action {
    ROCK,
    PAPER,
    SCISSORS
}

fun Action.beats(otherAction: Action): Boolean = when (this) {
    Action.PAPER -> Action.ROCK == otherAction
    Action.ROCK -> Action.SCISSORS == otherAction
    Action.SCISSORS -> Action.PAPER == otherAction
}
