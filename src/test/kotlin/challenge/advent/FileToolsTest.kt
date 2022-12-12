package challenge.advent

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FileToolsTest {

    @Test
    fun readEntireFileFromResource() {
        assertEquals("""
                1000
                2000
                3000

                4000

                5000
                6000

                7000
                8000
                9000

                10000
            """.trimIndent(),
            FileTools.readEntireFileFromResource("/challenge/advent/2022/01/short-input-1a.txt")
        )
    }
}