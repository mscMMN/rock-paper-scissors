package de.nakhlah.markus.player

import de.nakhlah.markus.Action

class PlayerStrategyFixed(private val fixedAction: Action): PlayerStrategy {
    override fun showAction(): Action = fixedAction
}
