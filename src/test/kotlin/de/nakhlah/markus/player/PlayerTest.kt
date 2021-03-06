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

    private val playerName = "Markus"

    @BeforeEach
    internal fun setUp() {
        every { playerStrategy.showAction() } returns Action.PAPER

        playerSUT = Player(playerName, playerStrategy)
    }

    @Test
    internal fun shouldPlayAnAction() {
        val playedAction = playerSUT.showAction()

        assertEquals(Action.PAPER, playedAction)

        verify { playerStrategy.showAction() }
    }

    @Test
    internal fun shouldHaveName() {
        assertEquals(playerName, playerSUT.name)
    }

    @Test
    internal fun shouldUseTheNameForToString() {
        assertEquals(playerName, "$playerSUT")
    }
}
