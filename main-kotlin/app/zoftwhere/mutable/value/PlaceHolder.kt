package app.zoftwhere.mutable.value

import java.util.function.Consumer
import java.util.function.Supplier

interface PlaceHolder<I> : Consumer<I>, Supplier<I> {

    val isPresent: Boolean

    val isEmpty: Boolean
        get() = !isPresent
}