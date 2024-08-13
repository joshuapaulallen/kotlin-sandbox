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

        fun parseWithStrategy(inputs: List<String>): Set<RockPaperScissorsGame> {
            return inputs.stream()
                .map { i -> parseWithStrategy(i) }
                .collect(Collectors.toSet());
        }

        fun parseWithStrategy(input: String): RockPaperScissorsGame {
            val items = input.split(Pattern.compile("\\s+"))
            val opponentChoice = toChoice(items[0])
            return RockPaperScissorsGame(opponentChoice, toStrategicChoice(opponentChoice, items[1]))
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

        fun toStrategicChoice(opponentChoice: RockPaperScissorsGame.Choice, strategy: String): RockPaperScissorsGame.Choice {
            // need to lose
            if (strategy == "X") {
                return when (opponentChoice) {
                    RockPaperScissorsGame.Choice.ROCK -> RockPaperScissorsGame.Choice.SCISSORS
                    RockPaperScissorsGame.Choice.PAPER -> RockPaperScissorsGame.Choice.ROCK
                    RockPaperScissorsGame.Choice.SCISSORS -> RockPaperScissorsGame.Choice.PAPER
                }
            }

            // need to draw
            if (strategy == "Y") {
                return opponentChoice
            }

            // need to win
            if (strategy == "Z") {
                return when (opponentChoice) {
                    RockPaperScissorsGame.Choice.ROCK -> RockPaperScissorsGame.Choice.PAPER
                    RockPaperScissorsGame.Choice.PAPER -> RockPaperScissorsGame.Choice.SCISSORS
                    RockPaperScissorsGame.Choice.SCISSORS -> RockPaperScissorsGame.Choice.ROCK
                }
            }

            throw IllegalArgumentException("Unrecognized strategy: $strategy")
        }

    }

}