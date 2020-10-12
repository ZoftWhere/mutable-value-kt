package app.zoftwhere.mutable.value

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test
import java.util.NoSuchElementException

internal class MutableValueTest {

    @Test
    fun testNull() {
        try {
            MutableValue<String>().get()
            fail<Any>("This should throw an exception.")
        } catch (ignore: NoSuchElementException) {
        }
    }

    @Test
    fun testOptional() {
        assertFalse(MutableValue<String>().optional().isPresent)
        assertTrue(MutableValue("").optional().isPresent)

        val input = "Mutator"
        val fixed = MutableValue<String>()
        fixed.accept(input)
        assertTrue(fixed.optional().isPresent)
        assertEquals(input, fixed.optional().get())
    }

    @Test
    fun testIsPresent() {
        assertFalse(MutableValue<String>().isPresent)
        assertTrue(MutableValue("").isPresent)
    }

    @Test
    fun testIsEmpty() {
        assertTrue(MutableValue<String>().isEmpty)
        assertFalse(MutableValue("").isEmpty)
    }

    @Test
    fun testConstructor() {
        val value = "new value"
        val actual = MutableValue(value)
        assertNotNull(value)
        assertNotNull(actual)
        assertNotNull(actual.get())
        assertEquals(value, actual.get())
    }

    @Test
    fun testClear() {
        val actual = MutableValue("string")
        actual.clear()
        val empty = MutableValue<Int>()
        assertEquals(actual, empty)
    }

    @Test
    fun testHashCode() {
        val actual = MutableValue<Any>()
        assertEquals(0, actual.hashCode())

        actual.set("non-zero")
        assertNotEquals(0, actual.hashCode())
    }

    @Test
    fun testNullEquals() {
        val actual = MutableValue("string")
        val empty = MutableValue<Int>()
        assertNotEquals(actual, empty)
        assertNotEquals(actual, null)
    }
}
