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
       assertEquals(5, score, "score should be sum of two rolls, 5")
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
       calculator.roll(1)   // u have 20 rolls without any spare or strike

       val score = calculator.score
       assertEquals(20, score, "score should be sum of all rolls")
   }

   @test
   fun strikeFollowedByOneRollGivesNextRollAsBonus() {
       val calculator = BowlingCalculator()

       calculator.roll(10)
       calculator.roll(3)

       val score = calculator.score
       assertEquals(16, score, "Strike doubles next roll")
   }

   @test
   fun strikeFollowedByTwoRollsGivesNextTwoRollsAsBonus() {
       val calculator = BowlingCalculator()

       calculator.roll(10)
       calculator.roll(3)
       calculator.roll(4)

       val score = calculator.score
       assertEquals(24, score, "Strike doubles next two rolls")
   }

   @test
   fun spareFollowedByOneRollsGivesNextRollAsBonus() {
       val calculator = BowlingCalculator()

       calculator.roll(6)
       calculator.roll(4) // spare
       calculator.roll(4)
       calculator.roll(3)

       val score = calculator.score
       assertEquals(21, score, "spare doubles only next roll")
   }

   @test
   fun twoStrikesGivesNextTwoRollsAsBonusOnEachStrike() {
       val calculator = BowlingCalculator()

       calculator.roll(10)
       calculator.roll(10)
       calculator.roll(4)
       calculator.roll(3)

       val score = calculator.score

       // 48 = (10 + (10+4)) + (10 + (4+3)) + (4 + 3)
       assertEquals(48, score)
   }

   @test
   fun TwoSparesFollowedByNonSpecialFrameGivesNextRollAsBonusOnEachSpare() {
       val calculator = BowlingCalculator()

       // frame 1 spare
       calculator.roll(6)
       calculator.roll(4)
       // frame 2 spare
       calculator.roll(6)
       calculator.roll(4)
       // frame 3 nothing
       calculator.roll(5)
       calculator.roll(2)

       val score = calculator.score
       // 38 = ( 6 + 4 + (6)) + (6 +4 +(5)) + (5 + 2)
       assertEquals(38, score, "hmmm")
   }

   @test
   fun thePerfectGameGives300() {
       val calculator = BowlingCalculator()

       // the perfect game consists of 12 Strikes
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
       assertEquals(300, score, "the score of perfect game is 300")
   }
}