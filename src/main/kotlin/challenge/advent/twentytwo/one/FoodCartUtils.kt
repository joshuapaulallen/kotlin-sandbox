package challenge.advent.twentytwo.one

import java.util.stream.Collectors
import kotlin.streams.toList

class FoodCartUtils private constructor() {

    companion object {

        fun parse(inputGroups: List<List<String>>): Set<FoodCart> {
            return inputGroups.stream()
                .map { group -> parseFoodCart(group) }
                .collect(Collectors.toSet())
        }

        private fun parseFoodCart(foodItems: List<String>): FoodCart {
            return FoodCart(foodItems.stream().map { item -> FoodItem(item.toInt()) }.collect(Collectors.toSet()))
        }

        fun findBiggestFoodCart(foodCarts: Set<FoodCart>): FoodCart {
            return foodCarts.stream()
                .reduce { biggest, current -> if (current.calorieCount() > biggest.calorieCount()) current else biggest }
                .orElse(null)
        }

    }

}