package de.nakhlah.markus.player

import de.nakhlah.markus.Action

class Player(val name: String, private val strategy: PlayerStrategy) {
    fun showAction(): Action = strategy.showAction()
}
