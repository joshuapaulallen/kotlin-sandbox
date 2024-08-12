package challenge.advent.twentytwo.two

import challenge.advent.FileTools
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.stream.Collectors

internal class RockPaperScissorsGameTest {

    @Test
    fun test() {
        assertEquals(
            15,
            RockPaperScissorsGame(RockPaperScissorsGame.Choice.ROCK, RockPaperScissorsGame.Choice.PAPER).playerTwoScore()
                    + RockPaperScissorsGame(RockPaperScissorsGame.Choice.PAPER, RockPaperScissorsGame.Choice.ROCK).playerTwoScore()
                    + RockPaperScissorsGame(RockPaperScissorsGame.Choice.SCISSORS, RockPaperScissorsGame.Choice.SCISSORS).playerTwoScore()
        )
    }

    @Test
    fun testWithParse() {
        assertEquals(
            15,
            RockPaperScissorsGameUtils.parse(listOf("A Y", "B X", "C Z")).stream()
                .collect(Collectors.summingInt { c -> c.playerTwoScore() })
        )
    }

    @Test
    fun run() {
        val file = FileTools.readEntireFileFromResource("/challenge/advent/2022/02/input-2a.txt")
        val result = RockPaperScissorsGameUtils.parse(file.split("\n")).stream()
            .collect(Collectors.summingInt { c -> c.playerTwoScore() })
        System.out.println(result)
    }

}