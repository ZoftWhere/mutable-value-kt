package app.zoftwhere.mutable

import app.zoftwhere.function.PlaceHolder
import java.util.Optional

class MutableValue<E> : PlaceHolder<E> {

    private var value: E? = null

    override val isPresent: Boolean
        get() = value != null

    constructor()

    constructor(value: E?) {
        this.value = value
    }

    fun optional(): Optional<E> {
        return Optional.ofNullable(value)
    }

    override fun get(): E {
        return Optional.ofNullable(value).get()
    }

    override fun accept(value: E) {
        this.value = value
    }
}
