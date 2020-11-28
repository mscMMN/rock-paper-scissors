package de.nakhlah.markus.player

import de.nakhlah.markus.Action
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PlayerTest {

    private lateinit var playerSUT: Player

    @BeforeEach
    internal fun setUp() {
        playerSUT = Player("Markus", PlayerStrategyFixed(Action.PAPER))
    }

    @Test
    internal fun showAction() {
        assertEquals("Markus", playerSUT.name)
        assertEquals(Action.PAPER, playerSUT.showAction())
    }
}
