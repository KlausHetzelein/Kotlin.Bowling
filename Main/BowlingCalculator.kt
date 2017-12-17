package Bowling.Main

private const val NUMBER_OF_ROLLS = 21
private const val NUMBER_OF_FRAMES = 10

class BowlingCalculator {
    var score: Int = 0
        private set

    private var rollCount = 0

    private var rolls: IntArray = IntArray(NUMBER_OF_ROLLS, { 0 })

    private fun calculateScore() {
        score = 0
        var rollIndex = 0
        for (frame in (1..NUMBER_OF_FRAMES)) {
            if (isStrike(rollIndex)) {
                score += 10 + getStrikeBonus(rollIndex)
                rollIndex++
            } else if (isSpare(rollIndex)) {
                score += 10 + getSpareBonus(rollIndex)
                rollIndex += 2
            } else {
                score += getFrameScore(rollIndex)
                rollIndex += 2
            }
        }
    }

    private fun getStrikeBonus(rollIndex: Int) = rolls[rollIndex + 1] + rolls[rollIndex + 2]
    private fun getSpareBonus(rollIndex: Int) = rolls[rollIndex + 2]
    private fun getFrameScore(rollIndex: Int) = rolls[rollIndex] + rolls[rollIndex + 1]
    private fun isSpare(rollIndex: Int) = getFrameScore(rollIndex) == 10
    private fun isStrike(rollIndex: Int) = rolls[rollIndex] == 10

    fun roll(roll: Int) {
        rolls[rollCount++] = roll

        calculateScore()
    }
}