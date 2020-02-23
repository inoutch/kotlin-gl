package io.github.inoutch.kotlin.gl.example.triangle

import io.github.inoutch.kotlin.gl.api.GL_ARRAY_BUFFER
import io.github.inoutch.kotlin.gl.api.GL_CLAMP_TO_EDGE
import io.github.inoutch.kotlin.gl.api.GL_COLOR_BUFFER_BIT
import io.github.inoutch.kotlin.gl.api.GL_FLOAT
import io.github.inoutch.kotlin.gl.api.GL_FRAGMENT_SHADER
import io.github.inoutch.kotlin.gl.api.GL_NEAREST
import io.github.inoutch.kotlin.gl.api.GL_RGBA
import io.github.inoutch.kotlin.gl.api.GL_STATIC_DRAW
import io.github.inoutch.kotlin.gl.api.GL_TEXTURE0
import io.github.inoutch.kotlin.gl.api.GL_TEXTURE_2D
import io.github.inoutch.kotlin.gl.api.GL_TEXTURE_MAG_FILTER
import io.github.inoutch.kotlin.gl.api.GL_TEXTURE_MIN_FILTER
import io.github.inoutch.kotlin.gl.api.GL_TEXTURE_WRAP_S
import io.github.inoutch.kotlin.gl.api.GL_TEXTURE_WRAP_T
import io.github.inoutch.kotlin.gl.api.GL_TRIANGLES
import io.github.inoutch.kotlin.gl.api.GL_UNPACK_ALIGNMENT
import io.github.inoutch.kotlin.gl.api.GL_UNSIGNED_BYTE
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

    private val textureId: GLuint

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

            gl.bindAttribLocation(program, 0, "position")
            gl.bindAttribLocation(program, 1, "texcoord")

            linkShader(program)

            triangleVertexBuffer = gl.genBuffers(1).first()
            gl.bindBuffer(GL_ARRAY_BUFFER, triangleVertexBuffer)
            gl.bufferData(GL_ARRAY_BUFFER, triangleVertices, GL_STATIC_DRAW)

            val texWidth = 256
            val texHeight = 256
            val pixels = ByteArray(texWidth * texHeight * 4)
            for (y in 0 until texHeight) {
                for (x in 0 until texWidth) {
                    pixels[(y * texWidth + x) * 4 + 0] = (255.0f * y / texHeight).toByte()
                    pixels[(y * texWidth + x) * 4 + 1] = (255.0f * x / texWidth).toByte()
                    pixels[(y * texWidth + x) * 4 + 2] = 255.toByte()
                    pixels[(y * texWidth + x) * 4 + 3] = 255.toByte()
                }
            }
            textureId = gl.genTextures(1).first()
            gl.bindTexture(GL_TEXTURE_2D, textureId)
            gl.pixelStorei(GL_UNPACK_ALIGNMENT, 1)
            gl.texImage2D(GL_TEXTURE_2D, 0, GL_RGBA, texWidth, texHeight, 0, GL_RGBA, GL_UNSIGNED_BYTE, pixels)

            gl.texParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST)
            gl.texParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST)
            gl.texParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE)
            gl.texParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE)
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

        gl.bindTexture(GL_TEXTURE_2D, textureId)
        gl.activeTexture(GL_TEXTURE0)
        gl.uniform1i(gl.getUniformLocation(program, "uTexture0"), 0)

        gl.vertexAttribPointer(0, 3, GL_FLOAT, false, 20, 0)
        gl.enableVertexAttribArray(0)
        gl.vertexAttribPointer(1, 2, GL_FLOAT, false, 20, 12)
        gl.enableVertexAttribArray(1)

        gl.drawArrays(GL_TRIANGLES, 0, 3)

        gl.bindTexture(GL_TEXTURE_2D, 0)
        gl.useProgram(0)
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
