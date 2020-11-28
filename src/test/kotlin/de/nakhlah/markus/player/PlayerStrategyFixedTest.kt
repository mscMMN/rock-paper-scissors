package de.nakhlah.markus.player

import de.nakhlah.markus.game.Action
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PlayerStrategyFixedTest {
    private lateinit var playerStrategyFixedSUT: PlayerStrategyFixed

    @BeforeEach
    internal fun setUp() {
        playerStrategyFixedSUT = PlayerStrategyFixed(Action.PAPER)
    }

    @Test
    internal fun showActionPaper() {
        playerStrategyFixedSUT = PlayerStrategyFixed(Action.PAPER)
        assertEquals(Action.PAPER, playerStrategyFixedSUT.showAction())
    }

    @Test
    internal fun showActionRock() {
        playerStrategyFixedSUT = PlayerStrategyFixed(Action.ROCK)
        assertEquals(Action.ROCK, playerStrategyFixedSUT.showAction())
    }

    @Test
    internal fun showActionScissors() {
        playerStrategyFixedSUT = PlayerStrategyFixed(Action.SCISSORS)
        assertEquals(Action.SCISSORS, playerStrategyFixedSUT.showAction())
    }
}
