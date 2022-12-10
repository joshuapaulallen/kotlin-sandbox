package sample

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ArithmeticTest {

    @Test
    fun sum() {
        assertEquals(3, Arithmetic.sum(1, 2))
    }

}