package io.github.inoutch.kotlin.gl.utility

class WebGLMap<T> {
    private val map = mutableMapOf<Int, T>()

    private var current = 0

    fun create(value: T): Int {
        val next = current++
        map[current] = value
        return next
    }

    fun destroy(id: Int): T {
        val value = get(id)
        map.remove(id)
        return value
    }

    operator fun get(id: Int): T = map.getValue(id)

    fun search(value: T) = map.filter { it.value === value }.keys.first()
}
