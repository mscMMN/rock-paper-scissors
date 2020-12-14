package de.nakhlah.markus.player

import de.nakhlah.markus.game.Action

class PlayerStrategyRandom: PlayerStrategy {

    override fun showAction(): Action = Action.values().random()

}
