package io.github.inoutch.kotlin.gl.extension

import org.khronos.webgl.Float32Array
import org.khronos.webgl.Int32Array
import org.khronos.webgl.Uint32Array
import org.khronos.webgl.get

fun ByteArray.toUint32Array(): Uint32Array {
    return Uint32Array(this.map { it.toInt() }.toTypedArray())
}

fun Int32Array.toIntArray(): IntArray {
    val intArray = IntArray(length)
    var i = 0
    while (i < length) {
        intArray[i] = get(i)
        i++
    }
    return intArray
}

fun Float32Array.toFloatArray(): FloatArray {
    val floatArray = FloatArray(length)
    var i = 0
    while (i < length) {
        floatArray[i] = get(i)
        i++
    }
    return floatArray
}
