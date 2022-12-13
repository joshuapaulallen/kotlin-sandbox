package challenge.advent.twentytwo.one

import kotlin.streams.toList

class FoodCart(val items: Set<FoodItem> = setOf()) {

    fun calorieCount(): Int {
        return items.stream()
            .map { item -> item.calories }
            .toList()
            .reduce { sum, current -> sum + current }
    }

}