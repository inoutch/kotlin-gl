package io.github.inoutch.kotlin.gl.example.triangle

import io.github.inoutch.kotlin.gl.api.GL_ARRAY_BUFFER
import io.github.inoutch.kotlin.gl.api.GL_COLOR_BUFFER_BIT
import io.github.inoutch.kotlin.gl.api.GL_FLOAT
import io.github.inoutch.kotlin.gl.api.GL_FRAGMENT_SHADER
import io.github.inoutch.kotlin.gl.api.GL_STATIC_DRAW
import io.github.inoutch.kotlin.gl.api.GL_TRIANGLES
import io.github.inoutch.kotlin.gl.api.GL_VERTEX_SHADER
import io.github.inoutch.kotlin.gl.api.GLenum
import io.github.inoutch.kotlin.gl.api.GLuint
import io.github.inoutch.kotlin.gl.api.gl

class Triangle(
    private val windowWidth: Int,
    private val windowHeight: Int,
    private val viewportWidth: Int,
    private val viewportHeight: Int
) {
    private val destroyers = mutableListOf<() -> Unit>()

    private val program: GLuint

    private val triangleVertexBuffer: GLuint

    init {
        try {
            val vertShader = loadShader(GL_VERTEX_SHADER, vertShaderSource)
            destroyers.add { gl.deleteShader(vertShader) }

            val fragShader = loadShader(GL_FRAGMENT_SHADER, fragShaderSource)
            destroyers.add { gl.deleteShader(fragShader) }

            program = gl.createProgram()
            check(program != 0) { "Unable to create program" }
            destroyers.add { gl.deleteProgram(program) }

            gl.attachShader(program, vertShader)
            gl.attachShader(program, fragShader)

            gl.bindAttribLocation(program, 0, "vPosition")

            linkShader(program)

            triangleVertexBuffer = gl.genBuffers(1).first()
            gl.bindBuffer(GL_ARRAY_BUFFER, triangleVertexBuffer)
            gl.bufferData(GL_ARRAY_BUFFER, triangleVertices, GL_STATIC_DRAW)
        } catch (e: IllegalStateException) {
            destroy()
            throw e
        }
    }

    fun render() {
        gl.viewport(0, 0, viewportWidth, viewportHeight)
        gl.clearColor(0.0f, 0.0f, 0.0f, 1.0f)
        gl.clear(GL_COLOR_BUFFER_BIT)
        gl.useProgram(program)

        gl.vertexAttribPointer(0, 3, GL_FLOAT, false, 0)
        gl.enableVertexAttribArray(0)

        gl.drawArrays(GL_TRIANGLES, 0, 3)
    }

    fun destroy() {
        destroyers.reversed().forEach { it.invoke() }
    }

    private fun loadShader(type: GLenum, source: String): GLuint {
        val shader = gl.createShader(type)
        check(shader != 0) { "Unable to create shader" }
        try {
            gl.shaderSource(shader, source)
            gl.compileShader(shader)
            val shaderInfoLog = gl.getShaderInfoLog(shader)
            if (shaderInfoLog != null) {
                throw IllegalStateException(shaderInfoLog)
            }
        } catch (e: IllegalStateException) {
            gl.deleteShader(shader)
            throw e
        }
        return shader
    }

    private fun linkShader(program: GLuint) {
        gl.linkProgram(program)
        val programInfoLog = gl.getProgramInfoLog(program)
        if (programInfoLog != null) {
            throw IllegalStateException(programInfoLog)
        }
    }
}
