package de.nakhlah.markus.player

import de.nakhlah.markus.Action

interface PlayerStrategy {
    fun showAction(): Action
}
