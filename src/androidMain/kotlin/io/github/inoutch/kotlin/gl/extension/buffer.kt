package io.github.inoutch.kotlin.gl.extension

import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer

fun IntBuffer.toIntArray(): IntArray {
    val intArray = IntArray(capacity())
    get(intArray, 0, intArray.size)
    return intArray
}

fun FloatBuffer.toFloatArray(): FloatArray {
    val floatArray = FloatArray(capacity())
    get(floatArray, 0, floatArray.size)
    return floatArray
}

fun ByteBuffer.toByteArray(): ByteArray {
    val byteArray = ByteArray(capacity())
    get(byteArray, 0, byteArray.size)
    return byteArray
}

fun IntArray.toIntBuffer(): IntBuffer {
    return IntBuffer.wrap(this)
}

fun FloatArray.toFloatBuffer(): FloatBuffer {
    return FloatBuffer.wrap(this)
}

fun ByteArray.toByteBuffer(): ByteBuffer {
    return ByteBuffer.wrap(this)
}
