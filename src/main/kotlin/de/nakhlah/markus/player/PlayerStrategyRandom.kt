package de.nakhlah.markus.player

import de.nakhlah.markus.game.Action
import kotlin.random.Random

class PlayerStrategyRandom: PlayerStrategy {

    private val random = Random.Default

    override fun showAction(): Action = Action.values()[random.nextInt(Action.values().size)]

}
