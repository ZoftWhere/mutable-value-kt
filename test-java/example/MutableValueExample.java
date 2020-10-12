package example;

import app.zoftwhere.mutable.value.MutableValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MutableValueExample {

    @Test
    void testString() {
        final var mutable = new MutableValue<String>();
        assertTrue(mutable.isEmpty());

        mutable.accept("newValue");
        assertEquals("newValue", mutable.get());

        final var copy = new MutableValue<>("newValue");
        assertEquals(mutable, copy);
    }

}
