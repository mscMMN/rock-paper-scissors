package de.nakhlah.markus.player

import de.nakhlah.markus.game.Action
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PlayerStrategyRandomTest {

    private lateinit var playerStrategyRandomSUT: PlayerStrategyRandom

    @BeforeEach
    internal fun setUp() {
        playerStrategyRandomSUT = PlayerStrategyRandom()
    }

    @Test
    internal fun showAction() {
        assertTrue(playerStrategyRandomSUT.showAction() in Action.values())
    }
}
