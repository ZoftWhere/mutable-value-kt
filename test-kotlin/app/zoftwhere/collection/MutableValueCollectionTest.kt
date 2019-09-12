package app.zoftwhere.collection

import app.zoftwhere.mutable.MutableValueCollection
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
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
}