package challenge.advent.twentytwo.two

class RockPaperScissorsGame(private val playerOneChoice: Choice, private val playerTwoChoice: Choice) {

    enum class Choice(val value: Int) {
        ROCK(1),
        PAPER(2),
        SCISSORS(3);
    }

    private enum class PlayerResult(val value: Int) {
        WIN(6),
        LOSS(0),
        DRAW(3);
    }

    private class GameResult(val playerOneResult: PlayerResult, val playerTwoResult: PlayerResult) {
        companion object {
            fun draw(): GameResult {
                return GameResult(PlayerResult.DRAW, PlayerResult.DRAW)
            }
            fun playerOneWins(): GameResult {
                return GameResult(PlayerResult.WIN, PlayerResult.LOSS)
            }
            fun playerTwoWins(): GameResult {
                return GameResult(PlayerResult.LOSS, PlayerResult.WIN)
            }
        }
    }

    private val gameResult = play();

    fun playerOneScore(): Int {
        return playerOneChoice.value + gameResult.playerOneResult.value
    }

    fun playerTwoScore(): Int {
        return playerTwoChoice.value + gameResult.playerTwoResult.value
    }

    private fun play(): GameResult {
        if (playerOneChoice == playerTwoChoice) {
            return GameResult.draw();
        }

        if (
            (playerOneChoice == Choice.ROCK && playerTwoChoice == Choice.SCISSORS)
            || (playerOneChoice == Choice.PAPER && playerTwoChoice == Choice.ROCK)
            || (playerOneChoice == Choice.SCISSORS && playerTwoChoice == Choice.PAPER)
        ){
            return GameResult.playerOneWins();
        }

        return GameResult.playerTwoWins();
    }
}