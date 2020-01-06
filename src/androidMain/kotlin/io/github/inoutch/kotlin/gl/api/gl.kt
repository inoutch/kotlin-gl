package io.github.inoutch.kotlin.gl.api

import android.opengl.GLES20
import io.github.inoutch.kotlin.gl.constant.FLOAT_BYTE_SIZE
import io.github.inoutch.kotlin.gl.constant.INT_BYTE_SIZE
import io.github.inoutch.kotlin.gl.extension.toByteBuffer
import io.github.inoutch.kotlin.gl.extension.toFloatArray
import io.github.inoutch.kotlin.gl.extension.toFloatBuffer
import io.github.inoutch.kotlin.gl.extension.toIntArray
import io.github.inoutch.kotlin.gl.extension.toIntBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer

actual object gl {

    actual fun activeTexture(texture: GLenum) {
        GLES20.glActiveTexture(texture)
    }

    actual fun attachShader(program: GLuint, shader: GLuint) {
        GLES20.glAttachShader(program, shader)
    }

    actual fun bindAttribLocation(program: GLuint, index: GLuint, name: String) {
        GLES20.glBindAttribLocation(program, index, name)
    }

    actual fun bindBuffer(target: GLenum, buffer: GLuint) {
        GLES20.glBindBuffer(target, buffer)
    }

    actual fun bindFramebuffer(target: GLenum, framebuffer: GLuint) {
        GLES20.glBindFramebuffer(target, framebuffer)
    }

    actual fun bindRenderbuffer(target: GLenum, renderbuffer: GLuint) {
        GLES20.glBindRenderbuffer(target, renderbuffer)
    }

    actual fun bindTexture(target: GLenum, texture: GLuint) {
        GLES20.glBindTexture(target, texture)
    }

    actual fun blendColor(red: GLfloat, green: GLfloat, blue: GLfloat, alpha: GLfloat) {
        GLES20.glBlendColor(red, green, blue, alpha)
    }

    actual fun blendEquation(mode: GLenum) {
        GLES20.glBlendEquation(mode)
    }

    actual fun blendEquationSeparate(modeRGB: GLenum, modeAlpha: GLenum) {
        GLES20.glBlendEquationSeparate(modeRGB, modeAlpha)
    }

    actual fun blendFunc(sfactor: GLenum, dfactor: GLenum) {
        GLES20.glBlendFunc(sfactor, dfactor)
    }

    actual fun blendFuncSeparate(sfactorRGB: GLenum, dfactorRGB: GLenum, sfactorAlpha: GLenum, dfactorAlpha: GLenum) {
        GLES20.glBlendFuncSeparate(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha)
    }

    actual fun bufferData(target: GLenum, data: IntArray, usage: GLenum) {
        GLES20.glBufferData(target, data.size * INT_BYTE_SIZE, data.toIntBuffer(), usage)
    }

    actual fun bufferData(target: GLenum, data: FloatArray, usage: GLenum) {
        GLES20.glBufferData(target, data.size * FLOAT_BYTE_SIZE, data.toFloatBuffer(), usage)
    }

    actual fun bufferData(target: GLenum, data: ByteArray, usage: GLenum) {
        GLES20.glBufferData(target, data.size, data.toByteBuffer(), usage)
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: IntArray) {
        GLES20.glBufferSubData(target, offset.toInt() * INT_BYTE_SIZE, data.size * INT_BYTE_SIZE, data.toIntBuffer())
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: FloatArray) {
        GLES20.glBufferSubData(target, offset.toInt() * FLOAT_BYTE_SIZE, data.size * FLOAT_BYTE_SIZE, data.toFloatBuffer())
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: ByteArray) {
        GLES20.glBufferSubData(target, offset.toInt(), data.size, data.toByteBuffer())
    }

    actual fun checkFramebufferStatus(target: GLenum): GLenum {
        return GLES20.glCheckFramebufferStatus(target)
    }

    actual fun clear(mask: GLbitfield) {
        GLES20.glClear(mask)
    }

    actual fun clearColor(red: GLfloat, green: GLfloat, blue: GLfloat, alpha: GLfloat) {
        GLES20.glClearColor(red, green, blue, alpha)
    }

    actual fun clearDepthf(d: GLfloat) {
        GLES20.glClearDepthf(d)
    }

    actual fun clearStencil(s: GLint) {
        GLES20.glClearStencil(s)
    }

    actual fun colorMask(red: GLboolean, green: GLboolean, blue: GLboolean, alpha: GLboolean) {
        GLES20.glColorMask(red, green, blue, alpha)
    }

    actual fun compileShader(shader: GLuint) {
        GLES20.glCompileShader(shader)
    }

    actual fun compressedTexImage2D(target: GLenum, level: GLint, internalformat: GLenum, width: GLsizei, height: GLsizei, border: GLint, data: ByteArray) {
        GLES20.glCompressedTexImage2D(target, level, internalformat, width, height, border, data.size, data.toByteBuffer())
    }

    actual fun compressedTexSubImage2D(target: GLenum, level: GLint, xoffset: GLint, yoffset: GLint, width: GLsizei, height: GLsizei, format: GLenum, data: ByteArray) {
        GLES20.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, data.size, data.toByteBuffer())
    }

    actual fun copyTexImage2D(target: GLenum, level: GLint, internalformat: GLenum, x: GLint, y: GLint, width: GLsizei, height: GLsizei, border: GLint) {
        GLES20.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border)
    }

    actual fun copyTexSubImage2D(target: GLenum, level: GLint, xoffset: GLint, yoffset: GLint, x: GLint, y: GLint, width: GLsizei, height: GLsizei) {
        GLES20.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height)
    }

    actual fun createProgram(): GLuint {
        return GLES20.glCreateProgram()
    }

    actual fun createShader(type: GLenum): GLuint {
        return GLES20.glCreateShader(type)
    }

    actual fun cullFace(mode: GLenum) {
        GLES20.glCullFace(mode)
    }

    actual fun deleteBuffers(buffers: IntArray) {
        GLES20.glDeleteBuffers(buffers.size, buffers.toIntBuffer())
    }

    actual fun deleteFramebuffers(framebuffers: IntArray) {
        GLES20.glDeleteFramebuffers(framebuffers.size, framebuffers.toIntBuffer())
    }

    actual fun deleteProgram(program: GLuint) {
        GLES20.glDeleteProgram(program)
    }

    actual fun deleteRenderbuffers(renderbuffers: IntArray) {
        GLES20.glDeleteRenderbuffers(renderbuffers.size, renderbuffers.toIntBuffer())
    }

    actual fun deleteShader(shader: GLuint) {
        GLES20.glDeleteShader(shader)
    }

    actual fun deleteTextures(textures: IntArray) {
        GLES20.glDeleteTextures(textures.size, textures.toIntBuffer())
    }

    actual fun depthFunc(func: GLenum) {
        GLES20.glDepthFunc(func)
    }

    actual fun depthMask(flag: GLboolean) {
        GLES20.glDepthMask(flag)
    }

    actual fun depthRangef(n: GLfloat, f: GLfloat) {
        GLES20.glDepthRangef(n, f)
    }

    actual fun detachShader(program: GLuint, shader: GLuint) {
        GLES20.glDetachShader(program, shader)
    }

    actual fun disable(cap: GLenum) {
        GLES20.glDisable(cap)
    }

    actual fun disableVertexAttribArray(index: GLuint) {
        GLES20.glDisableVertexAttribArray(index)
    }

    actual fun drawArrays(mode: GLenum, first: GLint, count: GLsizei) {
        GLES20.glDrawArrays(mode, first, count)
    }

    actual fun drawElements(mode: GLenum, indices: IntArray) {
        GLES20.glDrawElements(mode, GL_INT, indices.size, indices.toIntBuffer())
    }

    actual fun enable(cap: GLenum) {
        GLES20.glEnable(cap)
    }

    actual fun enableVertexAttribArray(index: GLuint) {
        GLES20.glEnableVertexAttribArray(index)
    }

    actual fun finish() {
        GLES20.glFinish()
    }

    actual fun flush() {
        GLES20.glFlush()
    }

    actual fun framebufferRenderbuffer(target: GLenum, attachment: GLenum, renderbuffertarget: GLenum, renderbuffer: GLuint) {
        GLES20.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer)
    }

    actual fun framebufferTexture2D(target: GLenum, attachment: GLenum, textarget: GLenum, texture: GLuint, level: GLint) {
        GLES20.glFramebufferTexture2D(target, attachment, textarget, texture, level)
    }

    actual fun frontFace(mode: GLenum) {
        GLES20.glFrontFace(mode)
    }

    actual fun genBuffers(n: GLsizei): IntArray {
        val buffers = IntArray(n)
        GLES20.glGenBuffers(buffers.size, buffers.toIntBuffer())
        return buffers
    }

    actual fun generateMipmap(target: GLenum) {
        GLES20.glGenerateMipmap(target)
    }

    actual fun genFramebuffers(n: GLsizei): IntArray {
        val framebuffers = IntArray(n)
        GLES20.glGenFramebuffers(framebuffers.size, framebuffers.toIntBuffer())
        return framebuffers
    }

    actual fun genRenderbuffers(n: GLsizei): IntArray {
        val renderbuffers = IntArray(n)
        GLES20.glGenRenderbuffers(renderbuffers.size, renderbuffers.toIntBuffer())
        return renderbuffers
    }

    actual fun genTextures(n: GLsizei): IntArray {
        val textures = IntArray(n)
        GLES20.glGenTextures(textures.size, textures.toIntBuffer())
        return textures
    }

    actual fun getActiveAttribSize(program: GLuint): GLint {
        val size = IntBuffer.allocate(1)
        val type = IntBuffer.allocate(1)
        GLES20.glGetActiveAttrib(program, 0, size, type)
        return size[0]
    }

    actual fun getActiveAttrib(program: GLuint, index: GLuint): Pair<String, GLint> {
        val size = IntBuffer.allocate(1)
        val type = IntBuffer.allocate(1)
        val name = GLES20.glGetActiveAttrib(program, index, size, type)
        return name to type[0]
    }

    actual fun getActiveUniformSize(program: GLuint): GLint {
        val size = IntBuffer.allocate(1)
        val type = IntBuffer.allocate(1)
        GLES20.glGetActiveUniform(program, 0, size, type)
        return size[0]
    }

    actual fun getActiveUniform(program: GLuint, index: GLuint): Pair<String, GLint> {
        val size = IntBuffer.allocate(1)
        val type = IntBuffer.allocate(1)
        val name = GLES20.glGetActiveUniform(program, index, size, type)
        return name to type[0]
    }

    actual fun getAttachedShaders(program: GLuint): IntArray {
        val count = IntBuffer.allocate(1)
        var shaders = IntBuffer.allocate(1)
        GLES20.glGetAttachedShaders(program, 1, count, shaders)

        shaders = IntBuffer.allocate(count[0])
        GLES20.glGetAttachedShaders(program, count[0], count, shaders)
        return shaders.toIntArray()
    }

    actual fun getAttribLocation(program: GLuint, name: String): GLint {
        return GLES20.glGetAttribLocation(program, name)
    }

    actual fun getBooleanv(pname: GLenum): Boolean {
        val intBuffer = IntBuffer.allocate(1)
        GLES20.glGetBooleanv(pname, intBuffer)
        return intBuffer[0] == GL_TRUE
    }

    actual fun getBufferParameteriv(target: GLenum, pname: GLenum): GLint {
        val bufferParameter = IntBuffer.allocate(1)
        GLES20.glGetBufferParameteriv(target, pname, bufferParameter)
        return bufferParameter[0]
    }

    actual fun getError(): GLenum {
        return GLES20.glGetError()
    }

    actual fun getFloatv(pname: GLenum): Float {
        val floatBuffer = FloatBuffer.allocate(1)
        GLES20.glGetFloatv(pname, floatBuffer)
        return floatBuffer.get(0)
    }

    actual fun getFramebufferAttachmentParameteriv(target: GLenum, attachment: GLenum, pname: GLenum): GLint {
        val intBuffer = IntBuffer.allocate(1)
        GLES20.glGetFramebufferAttachmentParameteriv(target, attachment, pname, intBuffer)
        return intBuffer[0]
    }

    actual fun getIntegerv(pname: GLenum): GLint {
        val intBuffer = IntBuffer.allocate(1)
        GLES20.glGetIntegerv(pname, intBuffer)
        return intBuffer[0]
    }

    actual fun getProgramiv(program: GLuint, pname: GLenum): GLint {
        val intBuffer = IntBuffer.allocate(1)
        GLES20.glGetProgramiv(program, pname, intBuffer)
        return intBuffer[0]
    }

    actual fun getProgramInfoLog(program: GLuint): String? {
        val infoLog = GLES20.glGetProgramInfoLog(program)
        if (infoLog.isBlank()) {
            return null
        }
        return infoLog
    }

    actual fun getRenderbufferParameteriv(target: GLenum, pname: GLenum): GLint {
        val intBuffer = IntBuffer.allocate(1)
        GLES20.glGetRenderbufferParameteriv(target, pname, intBuffer)
        return intBuffer[0]
    }

    actual fun getShaderiv(shader: GLuint, pname: GLenum): GLint {
        val intBuffer = IntBuffer.allocate(1)
        GLES20.glGetShaderiv(shader, pname, intBuffer)
        return intBuffer[0]
    }

    actual fun getShaderInfoLog(shader: GLuint): String? {
        val infoLog = GLES20.glGetShaderInfoLog(shader)
        if (infoLog.isBlank()) {
            return null
        }
        return infoLog
    }

    actual fun getShaderPrecisionFormat(shadertype: GLenum, precisiontype: GLenum): Pair<GLint, GLint> {
        val range = IntBuffer.allocate(1)
        val precision = IntBuffer.allocate(1)
        GLES20.glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision)
        return range[0] to precision[0]
    }

    actual fun getShaderSource(shader: GLuint): String {
        return GLES20.glGetShaderSource(shader)
    }

    actual fun getString(name: GLenum): String? {
        return GLES20.glGetString(name)
    }

    actual fun getTexParameterfv(target: GLenum, pname: GLenum): GLfloat {
        val floatBuffer = FloatBuffer.allocate(1)
        GLES20.glGetTexParameterfv(target, pname, floatBuffer)
        return floatBuffer[0]
    }

    actual fun getTexParameteriv(target: GLenum, pname: GLenum): GLint {
        val intBuffer = IntBuffer.allocate(1)
        GLES20.glGetTexParameteriv(target, pname, intBuffer)
        return intBuffer[0]
    }

    actual fun getUniformfv(program: GLuint, location: GLint): GLfloat {
        val floatBuffer = FloatBuffer.allocate(1)
        GLES20.glGetUniformfv(program, location, floatBuffer)
        return floatBuffer[0]
    }

    actual fun getUniformiv(program: GLuint, location: GLint): GLint {
        val intBuffer = IntBuffer.allocate(1)
        GLES20.glGetUniformiv(program, location, intBuffer)
        return intBuffer[0]
    }

    actual fun getUniformLocation(program: GLuint, name: String): GLint {
        return GLES20.glGetUniformLocation(program, name)
    }

    actual fun getVertexAttribfv(index: GLuint, pname: GLenum): GLfloat {
        val floatBuffer = FloatBuffer.allocate(1)
        GLES20.glGetVertexAttribfv(index, pname, floatBuffer)
        return floatBuffer[0]
    }

    actual fun getVertexAttribiv(index: GLuint, pname: GLenum): GLint {
        val intBuffer = IntBuffer.allocate(1)
        GLES20.glGetVertexAttribiv(index, pname, intBuffer)
        return intBuffer[0]
    }

    actual fun hint(target: GLenum, mode: GLenum) {
        GLES20.glHint(target, mode)
    }

    actual fun isBuffer(buffer: GLuint): GLboolean {
        return GLES20.glIsBuffer(buffer)
    }

    actual fun isEnabled(cap: GLenum): GLboolean {
        return GLES20.glIsEnabled(cap)
    }

    actual fun isFramebuffer(framebuffer: GLuint): GLboolean {
        return GLES20.glIsFramebuffer(framebuffer)
    }

    actual fun isProgram(program: GLuint): GLboolean {
        return GLES20.glIsProgram(program)
    }

    actual fun isRenderbuffer(renderbuffer: GLuint): GLboolean {
        return GLES20.glIsRenderbuffer(renderbuffer)
    }

    actual fun isShader(shader: GLuint): GLboolean {
        return GLES20.glIsShader(shader)
    }

    actual fun isTexture(texture: GLuint): GLboolean {
        return GLES20.glIsTexture(texture)
    }

    actual fun lineWidth(width: GLfloat) {
        GLES20.glLineWidth(width)
    }

    actual fun linkProgram(program: GLuint) {
        GLES20.glLinkProgram(program)
    }

    actual fun pixelStorei(pname: GLenum, param: GLint) {
        GLES20.glPixelStorei(pname, param)
    }

    actual fun polygonOffset(factor: GLfloat, units: GLfloat) {
        GLES20.glPolygonOffset(factor, units)
    }

    actual fun readPixelsi(x: GLint, y: GLint, width: GLsizei, height: GLsizei, format: GLenum, type: GLenum): IntArray {
        val intBuffer = IntBuffer.allocate(width * height)
        GLES20.glReadPixels(x, y, width, height, format, type, intBuffer)
        return intBuffer.toIntArray()
    }

    actual fun readPixelsf(x: GLint, y: GLint, width: GLsizei, height: GLsizei, format: GLenum, type: GLenum): FloatArray {
        val floatBuffer = FloatBuffer.allocate(width * height)
        GLES20.glReadPixels(x, y, width, height, format, type, floatBuffer)
        return floatBuffer.toFloatArray()
    }

    actual fun releaseShaderCompiler() {
        GLES20.glReleaseShaderCompiler()
    }

    actual fun renderbufferStorage(target: GLenum, internalformat: GLenum, width: GLsizei, height: GLsizei) {
        GLES20.glRenderbufferStorage(target, internalformat, width, height)
    }

    actual fun sampleCoverage(value: GLfloat, invert: GLboolean) {
        GLES20.glSampleCoverage(value, invert)
    }

    actual fun scissor(x: GLint, y: GLint, width: GLsizei, height: GLsizei) {
        GLES20.glScissor(x, y, width, height)
    }

    actual fun shaderBinary(shaders: IntArray, binaryformat: GLenum, binary: ByteArray) {
        GLES20.glShaderBinary(shaders.size, shaders.toIntBuffer(), binaryformat, binary.toByteBuffer(), binary.size)
    }

    actual fun shaderSource(shader: GLuint, string: String) {
        GLES20.glShaderSource(shader, string)
    }

    actual fun stencilFunc(func: GLenum, ref: GLint, mask: GLuint) {
        GLES20.glStencilFunc(func, ref, mask)
    }

    actual fun stencilFuncSeparate(face: GLenum, func: GLenum, ref: GLint, mask: GLuint) {
        GLES20.glStencilFunc(func, ref, mask)
    }

    actual fun stencilMask(mask: GLuint) {
        GLES20.glStencilMask(mask)
    }

    actual fun stencilMaskSeparate(face: GLenum, mask: GLuint) {
        GLES20.glStencilMaskSeparate(face, mask)
    }

    actual fun stencilOp(fail: GLenum, zfail: GLenum, zpass: GLenum) {
        GLES20.glStencilOp(fail, zfail, zpass)
    }

    actual fun stencilOpSeparate(face: GLenum, sfail: GLenum, dpfail: GLenum, dppass: GLenum) {
        GLES20.glStencilOpSeparate(face, sfail, dpfail, dppass)
    }

    actual fun texImage2D(target: GLenum, level: GLint, internalformat: GLint, width: GLsizei, height: GLsizei, border: GLint, format: GLenum, type: GLenum, pixels: ByteArray) {
        GLES20.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels.toByteBuffer())
    }

    actual fun texParameterf(target: GLenum, pname: GLenum, param: GLfloat) {
        GLES20.glTexParameterf(target, pname, param)
    }

    actual fun texParameterfv(target: GLenum, pname: GLenum, params: FloatArray) {
        GLES20.glTexParameterfv(target, pname, params.toFloatBuffer())
    }

    actual fun texParameteri(target: GLenum, pname: GLenum, param: GLint) {
        GLES20.glTexParameteri(target, pname, param)
    }

    actual fun texParameteriv(target: GLenum, pname: GLenum, params: IntArray) {
        GLES20.glTexParameteriv(target, pname, params.toIntBuffer())
    }

    actual fun texSubImage2D(target: GLenum, level: GLint, xoffset: GLint, yoffset: GLint, width: GLsizei, height: GLsizei, format: GLenum, type: GLenum, pixels: ByteArray) {
        GLES20.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels.toByteBuffer())
    }

    actual fun uniform1f(location: GLint, v0: GLfloat) {
        GLES20.glUniform1f(location, v0)
    }

    actual fun uniform1fv(location: GLint, value: FloatArray) {
        GLES20.glUniform1fv(location, value.size, value.toFloatBuffer())
    }

    actual fun uniform1i(location: GLint, v0: GLint) {
        GLES20.glUniform1i(location, v0)
    }

    actual fun uniform1iv(location: GLint, value: IntArray) {
        GLES20.glUniform1iv(location, value.size, value.toIntBuffer())
    }

    actual fun uniform2f(location: GLint, v0: GLfloat, v1: GLfloat) {
        GLES20.glUniform2f(location, v0, v1)
    }

    actual fun uniform2fv(location: GLint, value: FloatArray) {
        GLES20.glUniform2fv(location, value.size, value.toFloatBuffer())
    }

    actual fun uniform2i(location: GLint, v0: GLint, v1: GLint) {
        GLES20.glUniform2i(location, v0, v1)
    }

    actual fun uniform2iv(location: GLint, value: IntArray) {
        GLES20.glUniform2iv(location, value.size, value.toIntBuffer())
    }

    actual fun uniform3f(location: GLint, v0: GLfloat, v1: GLfloat, v2: GLfloat) {
        GLES20.glUniform3f(location, v0, v1, v2)
    }

    actual fun uniform3fv(location: GLint, value: FloatArray) {
        GLES20.glUniform3fv(location, value.size, value.toFloatBuffer())
    }

    actual fun uniform3i(location: GLint, v0: GLint, v1: GLint, v2: GLint) {
        GLES20.glUniform3i(location, v0, v1, v2)
    }

    actual fun uniform3iv(location: GLint, value: IntArray) {
        GLES20.glUniform3iv(location, value.size, value.toIntBuffer())
    }

    actual fun uniform4f(location: GLint, v0: GLfloat, v1: GLfloat, v2: GLfloat, v3: GLfloat) {
        GLES20.glUniform4f(location, v0, v1, v2, v3)
    }

    actual fun uniform4fv(location: GLint, value: FloatArray) {
        GLES20.glUniform4fv(location, value.size, value.toFloatBuffer())
    }

    actual fun uniform4i(location: GLint, v0: GLint, v1: GLint, v2: GLint, v3: GLint) {
        GLES20.glUniform4i(location, v0, v1, v2, v3)
    }

    actual fun uniform4iv(location: GLint, value: IntArray) {
        GLES20.glUniform4iv(location, value.size, value.toIntBuffer())
    }

    actual fun uniformMatrix2fv(location: GLint, transpose: GLboolean, value: FloatArray) {
        GLES20.glUniformMatrix2fv(location, value.size, transpose, value.toFloatBuffer())
    }

    actual fun uniformMatrix3fv(location: GLint, transpose: GLboolean, value: FloatArray) {
        GLES20.glUniformMatrix3fv(location, value.size, transpose, value.toFloatBuffer())
    }

    actual fun uniformMatrix4fv(location: GLint, transpose: GLboolean, value: FloatArray) {
        GLES20.glUniformMatrix4fv(location, value.size, transpose, value.toFloatBuffer())
    }

    actual fun useProgram(program: GLuint) {
        GLES20.glUseProgram(program)
    }

    actual fun validateProgram(program: GLuint) {
        GLES20.glValidateProgram(program)
    }

    actual fun vertexAttrib1f(index: GLuint, x: GLfloat) {
        GLES20.glVertexAttrib1f(index, x)
    }

    actual fun vertexAttrib1fv(index: GLuint, v: FloatArray) {
        GLES20.glVertexAttrib1fv(index, v.toFloatBuffer())
    }

    actual fun vertexAttrib2f(index: GLuint, x: GLfloat, y: GLfloat) {
        GLES20.glVertexAttrib2f(index, x, y)
    }

    actual fun vertexAttrib2fv(index: GLuint, v: FloatArray) {
        GLES20.glVertexAttrib2fv(index, v.toFloatBuffer())
    }

    actual fun vertexAttrib3f(index: GLuint, x: GLfloat, y: GLfloat, z: GLfloat) {
        GLES20.glVertexAttrib3f(index, x, y, z)
    }

    actual fun vertexAttrib3fv(index: GLuint, v: FloatArray) {
        GLES20.glVertexAttrib3fv(index, v.toFloatBuffer())
    }

    actual fun vertexAttrib4f(index: GLuint, x: GLfloat, y: GLfloat, z: GLfloat, w: GLfloat) {
        GLES20.glVertexAttrib4f(index, x, y, z, w)
    }

    actual fun vertexAttrib4fv(index: GLuint, v: FloatArray) {
        GLES20.glVertexAttrib4fv(index, v.toFloatBuffer())
    }

    actual fun vertexAttribPointer(index: GLuint, size: GLint, type: GLenum, normalized: GLboolean, stride: GLsizei) {
        GLES20.glVertexAttribPointer(index, size, type, normalized, stride, 0)
    }

    actual fun vertexAttribPointer(index: GLuint, size: GLint, type: GLenum, normalized: GLboolean, stride: GLsizei, pointer: IntArray) {
        GLES20.glVertexAttribPointer(index, size * INT_BYTE_SIZE, type, normalized, stride, pointer.toIntBuffer())
    }

    actual fun vertexAttribPointer(index: GLuint, size: GLint, type: GLenum, normalized: GLboolean, stride: GLsizei, pointer: FloatArray) {
        GLES20.glVertexAttribPointer(index, size * FLOAT_BYTE_SIZE, type, normalized, stride, pointer.toFloatBuffer())
    }

    actual fun vertexAttribPointer(index: GLuint, size: GLint, type: GLenum, normalized: GLboolean, stride: GLsizei, pointer: ByteArray) {
        GLES20.glVertexAttribPointer(index, size, type, normalized, stride, pointer.toByteBuffer())
    }

    actual fun viewport(x: GLint, y: GLint, width: GLsizei, height: GLsizei) {
        GLES20.glViewport(x, y, width, height)
    }
}
