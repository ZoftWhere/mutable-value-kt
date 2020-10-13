package app.zoftwhere.mutable.value

import java.util.Optional

open class MutableValue<E> : PlaceHolder<E> {

    private var value: E? = null

    constructor()

    constructor(value: E?) {
        this.value = value
    }

    override val isPresent: Boolean
        get() = value != null

    override val isEmpty: Boolean
        get() = value == null

    override fun clear() {
        value = null
    }

    open fun optional(): Optional<E> {
        return Optional.ofNullable(value)
    }

    override fun get(): E {
        return Optional.ofNullable(value).get()
    }

    override fun accept(value: E) {
        this.value = value
    }

    override fun hashCode(): Int {
        return when (value) {
            null -> 0
            else -> value.hashCode()
        }
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            null -> false
            !is MutableValue<*> -> false
            else -> this.value == other.value
        }
    }
}
