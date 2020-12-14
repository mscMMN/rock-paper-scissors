package de.nakhlah.markus.game

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class ActionTest {

    @Test
    fun `Paper beats Spock and Rock`() {
        assertTrue(Action.PAPER.beats(Action.SPOCK))
        assertTrue(Action.PAPER.beats(Action.ROCK))
    }

    @Test
    fun `Rock beats Lizard and Scissors`() {
        assertTrue(Action.ROCK.beats(Action.LIZARD))
        assertTrue(Action.ROCK.beats(Action.SCISSORS))
    }

    @Test
    fun `Lizard beats Paper and Spock`() {
        assertTrue(Action.LIZARD.beats(Action.PAPER))
        assertTrue(Action.LIZARD.beats(Action.SPOCK))
    }

    @Test
    fun `Spock beats Scissors and Rock`() {
        assertTrue(Action.SPOCK.beats(Action.SCISSORS))
        assertTrue(Action.SPOCK.beats(Action.ROCK))
    }

    @Test
    fun `Scissors beats Paper and Lizard`() {
        assertTrue(Action.SCISSORS.beats(Action.PAPER))
        assertTrue(Action.SCISSORS.beats(Action.LIZARD))
    }
}
