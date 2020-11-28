package de.nakhlah.markus.player

import de.nakhlah.markus.game.Action

interface PlayerStrategy {
    fun showAction(): Action
}
