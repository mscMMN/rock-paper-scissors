package de.nakhlah.markus.player

import de.nakhlah.markus.game.Action

class Player(val name: String, private val strategy: PlayerStrategy = PlayerStrategyRandom()) {
    fun showAction(): Action = strategy.showAction()
}
