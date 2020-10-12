package example;

import java.util.Objects;

import app.zoftwhere.mutable.value.PlaceHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FunctionExample {

    @Test
    void nullableExample() {
        final var mutable = new MutableString();
        Assertions.assertNull(mutable.get());

        mutable.accept("Hello World!");
        Assertions.assertEquals("Hello World!", mutable.get());
    }

    private static class MutableString implements PlaceHolder<String> {

        private String value;

        @Override
        public boolean isPresent() {
            return value != null;
        }

        @Override
        public void accept(String value) {
            this.value = value;
        }

        @Override
        public String get() {
            return value;
        }

        @Override
        public boolean isEmpty() {
            return value == null;
        }

        @Override
        public void clear() {
            this.value = null;
        }

        @Override
        public void set(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return Objects.toString(value);
        }
    }
}
