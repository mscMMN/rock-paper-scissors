package de.nakhlah.markus.player

import de.nakhlah.markus.game.Action
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class PlayerTest {

    @MockK
    private lateinit var playerStrategy: PlayerStrategy

    private lateinit var playerSUT: Player

    @BeforeEach
    internal fun setUp() {
        every { playerStrategy.showAction() } returns Action.PAPER

        playerSUT = Player("Markus", playerStrategy)
    }

    @Test
    internal fun showAction() {
        assertEquals("Markus", playerSUT.name)
        assertEquals(Action.PAPER, playerSUT.showAction())

        verify { playerStrategy.showAction() }
    }

    @Test
    internal fun shouldUseTheNameForToString() {
        assertEquals("Markus", "$playerSUT")
    }
}
