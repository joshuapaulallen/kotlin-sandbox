package challenge.advent.twentytwo.three

import challenge.advent.StringTools

class Rucksack(val compartments: List<Compartment>) {

    companion object {

        fun parse(str: String, numCompartments: Int): Rucksack {
            val compartments = StringTools.splitString(str, numCompartments).map { segment -> Compartment.parse(segment) }.toList()
            return Rucksack(compartments)
        }

    }

    fun items(): List<Item> {
        return compartments.map { compartment -> compartment.items }.flatten()
    }

    fun findCommonItems(): List<Item> {
        if (compartments.isEmpty()) return emptyList()
        if (compartments.size == 1) return compartments[0].items

        return compartments.map { c -> c.items }
            .fold(compartments[0].items.toSet()) { acc, compartmentItems -> acc.intersect(compartmentItems.toSet()) }
            .toList()
    }

    override fun toString(): String = compartments.joinToString(":") { c -> c.toString() }

    class Compartment(val items: List<Item>) {

        companion object {
            fun parse(str: String): Compartment = Compartment(str.map { c -> Item(c) }.toList())
        }

        /**
         * Converts each item to its character and joins them into a string.
         */
        override fun toString(): String = items.joinToString("") { it.char.toString() }

    }

    class Item(val char: Char) : Comparable<Item> {

        fun priority(): Int = if (char.isUpperCase()) char.code - 38 else char.code - 96

        override fun toString(): String = this.char.toString()

        /**
         * Item equality is important so that we can take advantage of set operations.
         */
        override fun compareTo(other: Item): Int = this.char.compareTo(other.char)

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Item) return false
            return this.compareTo(other) == 0
        }

        override fun hashCode(): Int {
            return char.hashCode()
        }

    }

}