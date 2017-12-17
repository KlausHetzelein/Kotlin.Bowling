package Bowling.Test

import Bowling.Main.BowlingCalculator
import kotlin.test.assertEquals
import org.testng.annotations.Test as test

class TestBowling {

   @test
   fun knockingDownOnePinGivesOne() {
       val calculator = BowlingCalculator()
       calculator.roll(1)
       val score = calculator.score
       assertEquals(1, score, "score should be 1")
   }

   @test
   fun knockingDownTwoPinsGivesTwo() {
       val calculator = BowlingCalculator()
       calculator.roll(2)
       val score = calculator.score
       assertEquals(2, score, "score should be 2")
   }

   @test
   fun twoSimpleRollsGivesSumOfRolls() {
       val calculator = BowlingCalculator()
       calculator.roll(2)
       calculator.roll(3)
       val score = calculator.score
       assertEquals(5, score, "score should sum of two Rolls, 5")
   }

   @test
   fun completeGameWithoutSpareOrStrikeGivesSumOfRolls() {
       val calculator = BowlingCalculator()
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       calculator.roll(1)
       val score = calculator.score
       assertEquals(20, score, "score should be sum of all rolls")
   }

   @test
   fun strikeFollowedByOneRollGivesDoubleOneRoll() {
       val calculator = BowlingCalculator()
       calculator.roll(10)
       calculator.roll(3)
       val score = calculator.score
       assertEquals(16, score, "Strike doubles next roll")
   }

   @test
   fun strikeFollowedByTwoRollsGivesDoubleOfTwoRolls() {
       val calculator = BowlingCalculator()
       calculator.roll(10)
       calculator.roll(3)
       calculator.roll(4)
       val score = calculator.score
       assertEquals(24, score, "Strike doubles next two rolls")
   }

   @test
   fun spareFollowedByOneRollsGivesDoubleOfThatRoll() {
       val calculator = BowlingCalculator()
       calculator.roll(6)
       calculator.roll(4) // spare
       calculator.roll(4)
       calculator.roll(3)
       val score = calculator.score
       assertEquals(21, score, "spare doubles only next roll")
   }

   @test
   fun twoStrikesGivesAlot() {
       val calculator = BowlingCalculator()
       calculator.roll(10)
       calculator.roll(10)
       calculator.roll(4)
       calculator.roll(3)
       val score = calculator.score
       assertEquals(48, score)
   }

   @test
   fun hmm() {
       val calculator = BowlingCalculator()
       calculator.roll(6)
       calculator.roll(4)
       calculator.roll(6)
       calculator.roll(4)
       calculator.roll(5)
       calculator.roll(2)
       val score = calculator.score
       assertEquals(38, score, "hmmm")
   }

   @test
   fun thePerfectGameGives300() {
       val calculator = BowlingCalculator()
       calculator.roll(10)
       calculator.roll(10)
       calculator.roll(10)
       calculator.roll(10)
       calculator.roll(10)
       calculator.roll(10)
       calculator.roll(10)
       calculator.roll(10)
       calculator.roll(10)
       calculator.roll(10)
       calculator.roll(10)
       calculator.roll(10)
       val score = calculator.score
       assertEquals(300, score, "perfect Gamescore is 300")
   }
}