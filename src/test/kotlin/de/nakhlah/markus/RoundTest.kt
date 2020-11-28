package de.nakhlah.markus

import de.nakhlah.markus.player.Player
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class RoundTest {

    private lateinit var roundSUT: Round

    @MockK
    private lateinit var firstPlayer: Player

    @MockK
    private lateinit var secondPlayer: Player

    @BeforeEach
    fun setUp() {
        roundSUT = Round(1)
    }

    @Test
    internal fun shouldDetermineFirstPlayerAsWinner() {
        every { firstPlayer.showAction()  } returns Action.PAPER
        every { secondPlayer.showAction()  } returns Action.ROCK

        roundSUT.play(firstPlayer, secondPlayer)

        assertEquals(1, roundSUT.number)
        assertEquals(firstPlayer, roundSUT.winner)
        assertFalse(roundSUT.isDraw)
    }

    @Test
    internal fun shouldDetermineSecondPlayerAsWinner() {
        every { firstPlayer.showAction()  } returns Action.SCISSORS
        every { secondPlayer.showAction()  } returns Action.ROCK

        roundSUT.play(firstPlayer, secondPlayer)

        assertEquals(1, roundSUT.number)
        assertEquals(secondPlayer, roundSUT.winner)
        assertFalse(roundSUT.isDraw)
    }

    @Test
    internal fun shouldDetermineDraw() {
        every { firstPlayer.showAction()  } returns Action.ROCK
        every { secondPlayer.showAction()  } returns Action.ROCK

        roundSUT.play(firstPlayer, secondPlayer)

        assertEquals(1, roundSUT.number)
        assertNull(roundSUT.winner)
        assertTrue(roundSUT.isDraw)
    }
}
