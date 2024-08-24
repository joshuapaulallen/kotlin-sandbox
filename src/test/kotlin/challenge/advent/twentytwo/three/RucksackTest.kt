package challenge.advent.twentytwo.three

import challenge.advent.ChallengeInputTools
import challenge.advent.ListTools
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class RucksackTest {

    @Test
    fun rucksackItem() {
        assertEquals(1, Rucksack.Item('a').priority())
        assertEquals(2, Rucksack.Item('b').priority())
        assertEquals(26, Rucksack.Item('z').priority())
        assertEquals(27, Rucksack.Item('A').priority())
        assertEquals(28, Rucksack.Item('B').priority())
        assertEquals(38, Rucksack.Item('L').priority())
        assertEquals(52, Rucksack.Item('Z').priority())
    }

    @Test
    fun rucksackParse() {
        val rucksack = Rucksack.parse("vJrwpWtwJgWrhcsFMMfFFhFp", 2)
        assertEquals("vJrwpWtwJgWr", rucksack.compartments.get(0).toString())
        assertEquals("hcsFMMfFFhFp", rucksack.compartments.get(1).toString())
    }

    @Test
    fun rucksackItemEquals() {
        assertEquals(Rucksack.Item('a'), Rucksack.Item('a'))
        assertEquals(setOf(Rucksack.Item('a')), setOf(Rucksack.Item('a')))
        assertEquals(
            setOf(Rucksack.Item('a'), Rucksack.Item('a')),
            setOf(Rucksack.Item('a'))
        )
        assertEquals(
            setOf(Rucksack.Item('b')),
            setOf(Rucksack.Item('a'), Rucksack.Item('b')).intersect(setOf(Rucksack.Item('b'), Rucksack.Item('c')))
        )
    }

    @Test
    fun rucksackSimple() {
        val rucksacks = ChallengeInputTools.parseResource("/challenge/advent/2022/03/input-small.txt")
            .map { s -> Rucksack.parse(s, 2) }

        assertEquals(
            157,
            rucksacks.sumOf { r -> r.findCommonItems().sumOf { i -> i.priority() } }
        )
    }

    @Test
    fun rucksackCumulativeValueOfDuplicateItems() {
        val rucksacks = ChallengeInputTools.parseResource("/challenge/advent/2022/03/input-3a.txt")
            .map { s -> Rucksack.parse(s, 2) }
        println(rucksacks.sumOf { r -> r.findCommonItems().sumOf { i -> i.priority() } })
    }

    @Test
    fun rucksackGroupsCommonItemsSmall() {
        val rucksacks = ChallengeInputTools.parseResource("/challenge/advent/2022/03/input-3b-small.txt")
            .map { s -> Rucksack.parse(s, 2) }
        val rucksackGroups = ListTools.split(rucksacks, 3).map { rucksackList -> RucksackGroup(rucksackList)}
        assertEquals(
            70,
            rucksackGroups.sumOf { group -> group.findCommonItems().sumOf { i -> i.priority() } }
        )
    }

    @Test
    fun rucksackGroupsCommonItems() {
        val rucksacks = ChallengeInputTools.parseResource("/challenge/advent/2022/03/input-3b.txt")
            .map { s -> Rucksack.parse(s, 2) }
        val rucksackGroups = ListTools.split(rucksacks, 3).map { rucksackList -> RucksackGroup(rucksackList)}
        println(rucksackGroups.sumOf { group -> group.findCommonItems().sumOf { i -> i.priority() } })
    }

}