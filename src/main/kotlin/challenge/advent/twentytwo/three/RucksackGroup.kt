package challenge.advent.twentytwo.three

import challenge.advent.twentytwo.three.Rucksack.Item

class RucksackGroup(val rucksacks: List<Rucksack>) {

    companion object {

        fun parse(strings: List<String>, numCompartments: Int): RucksackGroup {
            return RucksackGroup(strings.map { s -> Rucksack.parse(s, numCompartments) })
        }
    }

    fun findCommonItems(): List<Item> {
        return rucksacks.map { r -> r.items() }
            .fold(rucksacks[0].items().toSet()) { acc, rucksackItems -> acc.intersect(rucksackItems.toSet()) }
            .toList()
    }

}