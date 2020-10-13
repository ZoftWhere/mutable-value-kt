package app.zoftwhere.mutable.value

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test
import java.util.NoSuchElementException

internal class MutableValueCollectionTest {

    @Test
    fun testNull() {
        try {
            MutableValueCollection<String>().get()
            fail<Any>("This should throw an exception.")
        } catch (ignore: NoSuchElementException) {
        }
    }

    @Test
    fun testConstructor() {
        val value = mutableListOf<CharSequence>("one", "two", "three")
        val actual = MutableValueCollection(value)
        assertNotNull(value)
        assertNotNull(actual)
        assertNotNull(actual.get())
        assertEquals(value, actual.get())
    }

    @Test
    fun testAccept() {
        val value = mutableListOf<CharSequence>("one", "two", "three")
        val actual = MutableValueCollection<CharSequence>()
        actual.set(value)
        assertEquals(value, actual.get())
    }

    @Test
    fun testOptional() {
        val list = mutableListOf("one", "two", "three")
        val actual = MutableValueCollection(list)
        assertTrue(actual.optional().isPresent)
    }

    @Test
    fun testEmpty() {
        val actual = MutableValueCollection<String>()
        assertTrue(actual.isEmpty)
    }

    @Test
    fun testPresent() {
        val list = mutableListOf("one")
        val actual = MutableValueCollection(list)
        assertEquals(list[0], actual.get(0).get())
    }

    @Test
    fun testStream() {
        val list = mutableListOf("one")
        val actual = MutableValueCollection(list)
        assertEquals(1, actual.stream().count())
    }
}
