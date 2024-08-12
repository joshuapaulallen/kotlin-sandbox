package challenge.advent.twentytwo.one

class FoodCart(val items: Set<FoodItem> = setOf()) {

    fun calorieCount(): Int {
        return items.stream()
            .map { item -> item.calories }
            .toList()
            .reduce { sum, current -> sum + current }
    }

}