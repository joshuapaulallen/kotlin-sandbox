package challenge.advent.twentytwo.one

import challenge.advent.ChallengeInputTools
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class FoodCartTest {

    @Test
    fun partOneSmallInput() {
        val inputGroups = ChallengeInputTools.parseResourceIntoGroups("/challenge/advent/2022/01/short-input-1a.txt");
        val foodCarts = FoodCartUtils.parse(inputGroups)
        assertEquals(24000, FoodCartUtils.findBiggestFoodCart(foodCarts).calorieCount())
    }

    @Test
    fun partOne() {
        val inputGroups = ChallengeInputTools.parseResourceIntoGroups("/challenge/advent/2022/01/input-1a.txt");
        val foodCarts = FoodCartUtils.parse(inputGroups)
        System.out.println(FoodCartUtils.findBiggestFoodCart(foodCarts).calorieCount())
    }

}