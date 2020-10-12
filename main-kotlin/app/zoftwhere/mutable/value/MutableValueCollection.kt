package app.zoftwhere.mutable.value

import java.util.Optional
import java.util.stream.Stream

open class MutableValueCollection<E> : MutableValue<Collection<E>> {

    private var value: Collection<E>? = null

    constructor()

    constructor(value: Collection<E>?) {
        this.value = value
    }

    override fun optional(): Optional<Collection<E>> {
        return Optional.ofNullable(value)
    }

    override fun get(): Collection<E> {
        return Optional.ofNullable(value).get()
    }

    fun get(index: Long): Optional<E> {
        val collection = Optional.ofNullable(value).get()
        return collection.stream().skip(index).findFirst()
    }

    fun stream(): Stream<E> {
        val collection = Optional.ofNullable(value).get()
        return collection.stream()
    }

    override fun accept(value: Collection<E>) {
        this.value = value
    }
}
