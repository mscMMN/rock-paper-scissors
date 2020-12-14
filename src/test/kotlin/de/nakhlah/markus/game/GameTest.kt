package de.nakhlah.markus.game

import de.nakhlah.markus.player.Player
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class GameTest {

    private lateinit var gameSUT: Game

    @MockK
    private lateinit var firstPlayer: Player

    @MockK
    private lateinit var secondPlayer: Player

    @BeforeEach
    fun setUp() {
        every { firstPlayer.name } returns "Player 1"
        every { secondPlayer.name } returns "Player 2"

        gameSUT = Game(firstPlayer, secondPlayer)
    }

    @Test
    internal fun shouldThrowExceptionIfNumberOfRoundsIsLessThanOne() {
        val actualException = assertThrows<IllegalArgumentException> { Game(firstPlayer, secondPlayer, 0) }
        assertEquals("You must play at least one round!", actualException.message)
    }

    @Test
    internal fun shouldPlaySpecifiedAmountOfRounds() {
        every { firstPlayer.showAction() } returnsMany listOf(Action.PAPER, Action.ROCK, Action.SCISSORS, Action.SCISSORS, Action.ROCK)
        every { secondPlayer.showAction() } returns Action.SCISSORS

        val game = Game(firstPlayer, secondPlayer, 5)
        val statistics = game.play()

        assertEquals(2, statistics.firstPlayerWins)
        assertEquals(1, statistics.secondPlayerWins)
        assertEquals(2, statistics.numberOfDraws)

        verify(exactly = 5) { firstPlayer.showAction() }
        verify(exactly = 5) { secondPlayer.showAction() }
    }

}
