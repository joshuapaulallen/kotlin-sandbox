package challenge.advent.twentytwo.two

import java.util.regex.Pattern
import java.util.stream.Collectors

class RockPaperScissorsGameUtils private constructor() {

    companion object {
        fun parse(inputs: List<String>): Set<RockPaperScissorsGame> {
            return inputs.stream()
                .map { i -> parse(i) }
                .collect(Collectors.toSet());
        }

        fun parse(input: String): RockPaperScissorsGame {
            val items = input.split(Pattern.compile("\\s+"))
            return RockPaperScissorsGame(toChoice(items[0]), toChoice(items[1]))
        }

        fun toChoice(input: String): RockPaperScissorsGame.Choice {
            if (setOf("A", "X").contains(input)) {
                return RockPaperScissorsGame.Choice.ROCK;
            }
            if (setOf("B", "Y").contains(input)) {
                return RockPaperScissorsGame.Choice.PAPER;
            }
            if (setOf("C", "Z").contains(input)) {
                return RockPaperScissorsGame.Choice.SCISSORS;
            }

            throw IllegalArgumentException("Unrecognized input: $input")
        }

    }

}