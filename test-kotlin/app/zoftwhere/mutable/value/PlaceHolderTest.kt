package app.zoftwhere.mutable.value

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Optional

internal class PlaceHolderTest {

    @Test
    fun testDefaultEmpty() {
        val handler = object : PlaceHolder<String> {

            private var value: String? = null

            override val isPresent: Boolean
                get() = value != null

            override fun clear() {
                value = null
            }

            override fun accept(value: String) {
                this.value = value
            }

            override fun get(): String {
                return Optional.ofNullable(value).get()
            }
        }

        handler.set("")
        assertEquals("", handler.get())
        assertTrue(handler.isPresent)

        handler.clear()
        assertTrue(handler.isEmpty)
    }
}
