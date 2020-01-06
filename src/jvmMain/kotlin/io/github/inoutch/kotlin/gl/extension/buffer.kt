package io.github.inoutch.kotlin.gl.extension

import org.lwjgl.BufferUtils
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer
import kotlin.math.min

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

fun ByteBuffer.toByteArray(length: Int): ByteArray {
    val byteArray = ByteArray(capacity())
    get(byteArray, 0, min(length, byteArray.size))
    return byteArray
}

fun IntArray.toIntBuffer(): IntBuffer {
    val intBuffer = BufferUtils.createIntBuffer(size)
    forEach { intBuffer.put(it) }
    intBuffer.flip()
    return intBuffer
}

fun FloatArray.toFloatBuffer(): FloatBuffer {
    val floatBuffer = BufferUtils.createFloatBuffer(size)
    forEach { floatBuffer.put(it) }
    floatBuffer.flip()
    return floatBuffer
}

fun ByteArray.toByteBuffer(): ByteBuffer {
    val byteBuffer = BufferUtils.createByteBuffer(size)
    forEach { byteBuffer.put(it) }
    byteBuffer.flip()
    return byteBuffer
}
