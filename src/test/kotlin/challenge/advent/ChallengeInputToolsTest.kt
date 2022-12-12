package challenge.advent

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ChallengeInputToolsTest {

  @Test
  fun parse() {
    assertEquals(listOf("1", "2", "3"), ChallengeInputTools.parse("1 2 3"))
    assertEquals(listOf("1", "2", "3"), ChallengeInputTools.parse("1\n2\n3"))
  }

  @Test
  fun parseGroups() {
    assertEquals(
      listOf(listOf("1", "2", "3"), listOf("4", "5", "6")),
      ChallengeInputTools.parseGroups("1\n2\n3\n\n4\n5\n6")
    )
  }

  @Test
  fun parseResourceIntoGroups() {
    assertEquals(
      listOf(
        listOf("1000", "2000", "3000"), listOf("4000"), listOf("5000", "6000"), listOf("7000", "8000", "9000"),
        listOf("10000")
      ),
      ChallengeInputTools.parseResourceIntoGroups("/challenge/advent/2022/01/short-input-1a.txt")
    )
  }

}
