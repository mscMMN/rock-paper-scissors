package de.nakhlah.markus.game

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class ActionTest {

    @Test
    fun paperBeatsRock() {
        assertTrue(Action.PAPER.beats(Action.ROCK))
    }

    @Test
    fun rockBeatsScissors() {
        assertTrue(Action.ROCK.beats(Action.SCISSORS))
    }

    @Test
    fun scissorsBeatsPaper() {
        assertTrue(Action.SCISSORS.beats(Action.PAPER))
    }
}
