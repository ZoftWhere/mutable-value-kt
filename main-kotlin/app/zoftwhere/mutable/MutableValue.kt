package app.zoftwhere.mutable

import app.zoftwhere.function.PlaceHolder
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

    open fun optional(): Optional<E> {
        return Optional.ofNullable(value)
    }

    override fun get(): E {
        return Optional.ofNullable(value).get()
    }

    override fun accept(value: E) {
        this.value = value
    }
}
