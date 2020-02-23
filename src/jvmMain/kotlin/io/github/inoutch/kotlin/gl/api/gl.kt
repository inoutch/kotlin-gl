package io.github.inoutch.kotlin.gl.api

import io.github.inoutch.kotlin.gl.extension.toByteBuffer
import io.github.inoutch.kotlin.gl.extension.toFloatArray
import io.github.inoutch.kotlin.gl.extension.toFloatBuffer
import io.github.inoutch.kotlin.gl.extension.toIntArray
import io.github.inoutch.kotlin.gl.extension.toIntBuffer
import org.lwjgl.BufferUtils
import org.lwjgl.opengl.GL46
import org.lwjgl.system.MemoryUtil.NULL

actual object gl {
    actual fun activeTexture(texture: GLenum) {
        GL46.glActiveTexture(texture)
    }

    actual fun attachShader(program: GLuint, shader: GLuint) {
        GL46.glAttachShader(program, shader)
    }

    actual fun bindAttribLocation(program: GLuint, index: GLuint, name: String) {
        GL46.glBindAttribLocation(program, index, name)
    }

    actual fun bindBuffer(target: GLenum, buffer: GLuint) {
        GL46.glBindBuffer(target, buffer)
    }

    actual fun bindFramebuffer(target: GLenum, framebuffer: GLuint) {
        GL46.glBindFramebuffer(target, framebuffer)
    }

    actual fun bindRenderbuffer(target: GLenum, renderbuffer: GLuint) {
        GL46.glBindRenderbuffer(target, renderbuffer)
    }

    actual fun bindTexture(target: GLenum, texture: GLuint) {
        GL46.glBindTexture(target, texture)
    }

    actual fun blendColor(red: GLfloat, green: GLfloat, blue: GLfloat, alpha: GLfloat) {
        GL46.glBlendColor(red, green, blue, alpha)
    }

    actual fun blendEquation(mode: GLenum) {
        GL46.glBlendEquation(mode)
    }

    actual fun blendEquationSeparate(modeRGB: GLenum, modeAlpha: GLenum) {
        GL46.glBlendEquationSeparate(modeRGB, modeAlpha)
    }

    actual fun blendFunc(sfactor: GLenum, dfactor: GLenum) {
        GL46.glBlendFunc(sfactor, dfactor)
    }

    actual fun blendFuncSeparate(sfactorRGB: GLenum, dfactorRGB: GLenum, sfactorAlpha: GLenum, dfactorAlpha: GLenum) {
        GL46.glBlendFuncSeparate(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha)
    }

    actual fun bufferData(target: GLenum, data: IntArray, usage: GLenum) {
        GL46.glBufferData(target, data.toIntBuffer(), usage)
    }

    actual fun bufferData(target: GLenum, data: IntArray, size: GLint, usage: GLenum) {
        GL46.glBufferData(target, data.sliceArray(IntRange(0, size)).toIntBuffer(), usage)
    }

    actual fun bufferData(target: GLenum, data: FloatArray, usage: GLenum) {
        GL46.glBufferData(target, data.toFloatBuffer(), usage)
    }

    actual fun bufferData(target: GLenum, data: FloatArray, size: GLint, usage: GLenum) {
        GL46.glBufferData(target, data.sliceArray(IntRange(0, size)).toFloatBuffer(), usage)
    }

    actual fun bufferData(target: GLenum, data: ByteArray, usage: GLenum) {
        GL46.glBufferData(target, data.toByteBuffer(), usage)
    }

    actual fun bufferData(target: GLenum, data: ByteArray, size: GLint, usage: GLenum) {
        GL46.glBufferData(target, data.sliceArray(IntRange(0, size)).toByteBuffer(), usage)
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: IntArray) {
        GL46.glBufferSubData(target, offset, data)
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: IntArray, size: GLint) {
        GL46.glBufferSubData(target, offset, data.sliceArray(IntRange(0, size)))
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: FloatArray) {
        GL46.glBufferSubData(target, offset, data)
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: FloatArray, size: GLint) {
        GL46.glBufferSubData(target, offset, data.sliceArray(IntRange(0, size)))
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: ByteArray) {
        GL46.glBufferSubData(target, offset, data.toByteBuffer())
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: ByteArray, size: GLint) {
        GL46.glBufferSubData(target, offset, data.sliceArray(IntRange(0, size)).toByteBuffer())
    }

    actual fun checkFramebufferStatus(target: GLenum): GLenum {
        return GL46.glCheckFramebufferStatus(target)
    }

    actual fun clear(mask: GLbitfield) {
        GL46.glClear(mask)
    }

    actual fun clearColor(red: GLfloat, green: GLfloat, blue: GLfloat, alpha: GLfloat) {
        GL46.glClearColor(red, green, blue, alpha)
    }

    actual fun clearDepthf(d: GLfloat) {
        GL46.glClearDepthf(d)
    }

    actual fun clearStencil(s: GLint) {
        GL46.glClearStencil(s)
    }

    actual fun colorMask(red: GLboolean, green: GLboolean, blue: GLboolean, alpha: GLboolean) {
        GL46.glColorMask(red, green, blue, alpha)
    }

    actual fun compileShader(shader: GLuint) {
        GL46.glCompileShader(shader)
    }

    actual fun compressedTexImage2D(target: GLenum, level: GLint, internalformat: GLenum, width: GLsizei, height: GLsizei, border: GLint, data: ByteArray) {
        GL46.glCompressedTexImage2D(target, level, internalformat, width, height, border, data.toByteBuffer())
    }

    actual fun compressedTexSubImage2D(target: GLenum, level: GLint, xoffset: GLint, yoffset: GLint, width: GLsizei, height: GLsizei, format: GLenum, data: ByteArray) {
        GL46.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, data.toByteBuffer())
    }

    actual fun copyTexImage2D(target: GLenum, level: GLint, internalformat: GLenum, x: GLint, y: GLint, width: GLsizei, height: GLsizei, border: GLint) {
        GL46.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border)
    }

    actual fun copyTexSubImage2D(target: GLenum, level: GLint, xoffset: GLint, yoffset: GLint, x: GLint, y: GLint, width: GLsizei, height: GLsizei) {
        GL46.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height)
    }

    actual fun createProgram(): GLuint {
        return GL46.glCreateProgram()
    }

    actual fun createShader(type: GLenum): GLuint {
        return GL46.glCreateShader(type)
    }

    actual fun cullFace(mode: GLenum) {
        GL46.glCullFace(mode)
    }

    actual fun deleteBuffers(buffers: IntArray) {
        GL46.glDeleteBuffers(buffers)
    }

    actual fun deleteFramebuffers(framebuffers: IntArray) {
        GL46.glDeleteFramebuffers(framebuffers)
    }

    actual fun deleteProgram(program: GLuint) {
        GL46.glDeleteProgram(program)
    }

    actual fun deleteRenderbuffers(renderbuffers: IntArray) {
        GL46.glDeleteRenderbuffers(renderbuffers)
    }

    actual fun deleteShader(shader: GLuint) {
        GL46.glDeleteShader(shader)
    }

    actual fun deleteTextures(textures: IntArray) {
        GL46.glDeleteTextures(textures)
    }

    actual fun depthFunc(func: GLenum) {
        GL46.glDepthFunc(func)
    }

    actual fun depthMask(flag: GLboolean) {
        GL46.glDepthMask(flag)
    }

    actual fun depthRangef(n: GLfloat, f: GLfloat) {
        GL46.glDepthRangef(n, f)
    }

    actual fun detachShader(program: GLuint, shader: GLuint) {
        GL46.glDetachShader(program, shader)
    }

    actual fun disable(cap: GLenum) {
        GL46.glDisable(cap)
    }

    actual fun disableVertexAttribArray(index: GLuint) {
        GL46.glDisableVertexAttribArray(index)
    }

    actual fun drawArrays(mode: GLenum, first: GLint, count: GLsizei) {
        GL46.glDrawArrays(mode, first, count)
    }

    actual fun drawElements(mode: GLenum, indices: IntArray) {
        GL46.glDrawElements(mode, indices.toIntBuffer())
    }

    actual fun enable(cap: GLenum) {
        GL46.glEnable(cap)
    }

    actual fun enableVertexAttribArray(index: GLuint) {
        GL46.glEnableVertexAttribArray(index)
    }

    actual fun finish() {
        GL46.glFinish()
    }

    actual fun flush() {
        GL46.glFlush()
    }

    actual fun framebufferRenderbuffer(target: GLenum, attachment: GLenum, renderbuffertarget: GLenum, renderbuffer: GLuint) {
        GL46.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer)
    }

    actual fun framebufferTexture2D(target: GLenum, attachment: GLenum, textarget: GLenum, texture: GLuint, level: GLint) {
        GL46.glFramebufferTexture2D(target, attachment, textarget, texture, level)
    }

    actual fun frontFace(mode: GLenum) {
        GL46.glFrontFace(mode)
    }

    actual fun genBuffers(n: GLsizei): IntArray {
        val buffers = IntArray(n)
        GL46.glGenBuffers(buffers)
        return buffers
    }

    actual fun generateMipmap(target: GLenum) {
        GL46.glGenerateMipmap(target)
    }

    actual fun genFramebuffers(n: GLsizei): IntArray {
        val framebuffers = IntArray(n)
        GL46.glGenFramebuffers(framebuffers)
        return framebuffers
    }

    actual fun genRenderbuffers(n: GLsizei): IntArray {
        val renderbuffers = IntArray(n)
        GL46.glGenRenderbuffers(renderbuffers)
        return renderbuffers
    }

    actual fun genTextures(n: GLsizei): IntArray {
        val textures = IntArray(n)
        GL46.glGenTextures(textures)
        return textures
    }

    actual fun getActiveAttribSize(program: GLuint): GLint {
        val size = BufferUtils.createIntBuffer(1)
        val type = BufferUtils.createIntBuffer(1)
        GL46.glGetActiveAttrib(program, 0, size, type)
        return size[0]
    }

    actual fun getActiveAttrib(program: GLuint, index: GLuint): Pair<String, GLint> {
        val size = BufferUtils.createIntBuffer(1) // Ignore
        val type = BufferUtils.createIntBuffer(1)
        val name = GL46.glGetActiveAttrib(program, index, size, type)
        return name to type[0]
    }

    actual fun getActiveUniformSize(program: GLuint): GLint {
        val size = BufferUtils.createIntBuffer(1)
        val type = BufferUtils.createIntBuffer(1)
        GL46.glGetActiveUniform(program, 0, size, type)
        return size[0]
    }

    actual fun getActiveUniform(program: GLuint, index: GLuint): Pair<String, GLint> {
        val size = BufferUtils.createIntBuffer(1)
        val type = BufferUtils.createIntBuffer(1)
        val name = GL46.glGetActiveUniform(program, index, size, type)
        return name to type[0]
    }

    actual fun getAttachedShaders(program: GLuint): IntArray {
        val count = BufferUtils.createIntBuffer(1)
        var shaders = BufferUtils.createIntBuffer(1)
        GL46.glGetAttachedShaders(program, count, shaders)

        shaders = BufferUtils.createIntBuffer(count[0])
        GL46.glGetAttachedShaders(program, count, shaders)
        return shaders.toIntArray()
    }

    actual fun getAttribLocation(program: GLuint, name: String): GLint {
        return GL46.glGetAttribLocation(program, name)
    }

    actual fun getBooleanv(pname: GLenum): Boolean {
        return GL46.glGetBoolean(pname)
    }

    actual fun getBufferParameteriv(target: GLenum, pname: GLenum): GLint {
        val bufferParameter = BufferUtils.createIntBuffer(1)
        GL46.glGetBufferParameteriv(target, pname, bufferParameter)
        return bufferParameter[0]
    }

    actual fun getError(): GLenum {
        return GL46.glGetError()
    }

    actual fun getFloatv(pname: GLenum): Float {
        val floatBuffer = BufferUtils.createFloatBuffer(1)
        GL46.glGetFloatv(pname, floatBuffer)
        return floatBuffer.get(0)
    }

    actual fun getFramebufferAttachmentParameteriv(target: GLenum, attachment: GLenum, pname: GLenum): GLint {
        val intBuffer = BufferUtils.createIntBuffer(1)
        GL46.glGetFramebufferAttachmentParameteriv(target, attachment, pname, intBuffer)
        return intBuffer[0]
    }

    actual fun getIntegerv(pname: GLenum): GLint {
        val intBuffer = BufferUtils.createIntBuffer(1)
        GL46.glGetIntegerv(pname, intBuffer)
        return intBuffer[0]
    }

    actual fun getProgramiv(program: GLuint, pname: GLenum): GLint {
        val intBuffer = BufferUtils.createIntBuffer(1)
        GL46.glGetProgramiv(program, pname, intBuffer)
        return intBuffer[0]
    }

    actual fun getProgramInfoLog(program: GLuint): String? {
        val infoLog = GL46.glGetProgramInfoLog(program)
        if (infoLog.isBlank()) {
            return null
        }
        return infoLog
    }

    actual fun getRenderbufferParameteriv(target: GLenum, pname: GLenum): GLint {
        val intBuffer = BufferUtils.createIntBuffer(1)
        GL46.glGetRenderbufferParameteriv(target, pname, intBuffer)
        return intBuffer[0]
    }

    actual fun getShaderiv(shader: GLuint, pname: GLenum): GLint {
        val intBuffer = BufferUtils.createIntBuffer(1)
        GL46.glGetShaderiv(shader, pname, intBuffer)
        return intBuffer[0]
    }

    actual fun getShaderInfoLog(shader: GLuint): String? {
        val infoLog = GL46.glGetShaderInfoLog(shader)
        if (infoLog.isBlank()) {
            return null
        }
        return infoLog
    }

    actual fun getShaderPrecisionFormat(shadertype: GLenum, precisiontype: GLenum): Pair<GLint, GLint> {
        val range = BufferUtils.createIntBuffer(1)
        val precision = BufferUtils.createIntBuffer(1)
        GL46.glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision)
        return range[0] to precision[0]
    }

    actual fun getShaderSource(shader: GLuint): String {
        return GL46.glGetShaderSource(shader)
    }

    actual fun getString(name: GLenum): String? {
        return GL46.glGetString(name)
    }

    actual fun getTexParameterfv(target: GLenum, pname: GLenum): GLfloat {
        val floatBuffer = BufferUtils.createFloatBuffer(1)
        GL46.glGetTexParameterfv(target, pname, floatBuffer)
        return floatBuffer[0]
    }

    actual fun getTexParameteriv(target: GLenum, pname: GLenum): GLint {
        val intBuffer = BufferUtils.createIntBuffer(1)
        GL46.glGetTexParameteriv(target, pname, intBuffer)
        return intBuffer[0]
    }

    actual fun getUniformfv(program: GLuint, location: GLint): GLfloat {
        val floatBuffer = BufferUtils.createFloatBuffer(1)
        GL46.glGetUniformfv(program, location, floatBuffer)
        return floatBuffer[0]
    }

    actual fun getUniformiv(program: GLuint, location: GLint): GLint {
        val intBuffer = BufferUtils.createIntBuffer(1)
        GL46.glGetUniformiv(program, location, intBuffer)
        return intBuffer[0]
    }

    actual fun getUniformLocation(program: GLuint, name: String): GLint {
        return GL46.glGetUniformLocation(program, name)
    }

    actual fun getVertexAttribfv(index: GLuint, pname: GLenum): GLfloat {
        val floatBuffer = BufferUtils.createFloatBuffer(1)
        GL46.glGetVertexAttribfv(index, pname, floatBuffer)
        return floatBuffer[0]
    }

    actual fun getVertexAttribiv(index: GLuint, pname: GLenum): GLint {
        val intBuffer = BufferUtils.createIntBuffer(1)
        GL46.glGetVertexAttribiv(index, pname, intBuffer)
        return intBuffer[0]
    }

    actual fun hint(target: GLenum, mode: GLenum) {
        GL46.glHint(target, mode)
    }

    actual fun isBuffer(buffer: GLuint): GLboolean {
        return GL46.glIsBuffer(buffer)
    }

    actual fun isEnabled(cap: GLenum): GLboolean {
        return GL46.glIsEnabled(cap)
    }

    actual fun isFramebuffer(framebuffer: GLuint): GLboolean {
        return GL46.glIsFramebuffer(framebuffer)
    }

    actual fun isProgram(program: GLuint): GLboolean {
        return GL46.glIsProgram(program)
    }

    actual fun isRenderbuffer(renderbuffer: GLuint): GLboolean {
        return GL46.glIsRenderbuffer(renderbuffer)
    }

    actual fun isShader(shader: GLuint): GLboolean {
        return GL46.glIsShader(shader)
    }

    actual fun isTexture(texture: GLuint): GLboolean {
        return GL46.glIsTexture(texture)
    }

    actual fun lineWidth(width: GLfloat) {
        GL46.glLineWidth(width)
    }

    actual fun linkProgram(program: GLuint) {
        GL46.glLinkProgram(program)
    }

    actual fun pixelStorei(pname: GLenum, param: GLint) {
        GL46.glPixelStorei(pname, param)
    }

    actual fun polygonOffset(factor: GLfloat, units: GLfloat) {
        GL46.glPolygonOffset(factor, units)
    }

    actual fun readPixelsi(x: GLint, y: GLint, width: GLsizei, height: GLsizei, format: GLenum, type: GLenum): IntArray {
        val intBuffer = BufferUtils.createIntBuffer(width * height)
        GL46.glReadPixels(x, y, width, height, format, type, intBuffer)
        return intBuffer.toIntArray()
    }

    actual fun readPixelsf(x: GLint, y: GLint, width: GLsizei, height: GLsizei, format: GLenum, type: GLenum): FloatArray {
        val floatBuffer = BufferUtils.createFloatBuffer(width * height)
        GL46.glReadPixels(x, y, width, height, format, type, floatBuffer)
        return floatBuffer.toFloatArray()
    }

    actual fun releaseShaderCompiler() {
        GL46.glReleaseShaderCompiler()
    }

    actual fun renderbufferStorage(target: GLenum, internalformat: GLenum, width: GLsizei, height: GLsizei) {
        GL46.glRenderbufferStorage(target, internalformat, width, height)
    }

    actual fun sampleCoverage(value: GLfloat, invert: GLboolean) {
        GL46.glSampleCoverage(value, invert)
    }

    actual fun scissor(x: GLint, y: GLint, width: GLsizei, height: GLsizei) {
        GL46.glScissor(x, y, width, height)
    }

    actual fun shaderBinary(shaders: IntArray, binaryformat: GLenum, binary: ByteArray) {
        GL46.glShaderBinary(shaders.toIntBuffer(), binaryformat, binary.toByteBuffer())
    }

    actual fun shaderSource(shader: GLuint, string: String) {
        GL46.glShaderSource(shader, string)
    }

    actual fun stencilFunc(func: GLenum, ref: GLint, mask: GLuint) {
        GL46.glStencilFunc(func, ref, mask)
    }

    actual fun stencilFuncSeparate(face: GLenum, func: GLenum, ref: GLint, mask: GLuint) {
        GL46.glStencilFunc(func, ref, mask)
    }

    actual fun stencilMask(mask: GLuint) {
        GL46.glStencilMask(mask)
    }

    actual fun stencilMaskSeparate(face: GLenum, mask: GLuint) {
        GL46.glStencilMaskSeparate(face, mask)
    }

    actual fun stencilOp(fail: GLenum, zfail: GLenum, zpass: GLenum) {
        GL46.glStencilOp(fail, zfail, zpass)
    }

    actual fun stencilOpSeparate(face: GLenum, sfail: GLenum, dpfail: GLenum, dppass: GLenum) {
        GL46.glStencilOpSeparate(face, sfail, dpfail, dppass)
    }

    actual fun texImage2D(target: GLenum, level: GLint, internalformat: GLint, width: GLsizei, height: GLsizei, border: GLint, format: GLenum, type: GLenum, pixels: ByteArray) {
        GL46.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels.toByteBuffer())
    }

    actual fun texParameterf(target: GLenum, pname: GLenum, param: GLfloat) {
        GL46.glTexParameterf(target, pname, param)
    }

    actual fun texParameterfv(target: GLenum, pname: GLenum, params: FloatArray) {
        GL46.glTexParameterfv(target, pname, params)
    }

    actual fun texParameteri(target: GLenum, pname: GLenum, param: GLint) {
        GL46.glTexParameteri(target, pname, param)
    }

    actual fun texParameteriv(target: GLenum, pname: GLenum, params: IntArray) {
        GL46.glTexParameteriv(target, pname, params)
    }

    actual fun texSubImage2D(target: GLenum, level: GLint, xoffset: GLint, yoffset: GLint, width: GLsizei, height: GLsizei, format: GLenum, type: GLenum, pixels: ByteArray) {
        GL46.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels.toByteBuffer())
    }

    actual fun uniform1f(location: GLint, v0: GLfloat) {
        GL46.glUniform1f(location, v0)
    }

    actual fun uniform1fv(location: GLint, value: FloatArray) {
        GL46.glUniform1fv(location, value)
    }

    actual fun uniform1i(location: GLint, v0: GLint) {
        GL46.glUniform1i(location, v0)
    }

    actual fun uniform1iv(location: GLint, value: IntArray) {
        GL46.glUniform1iv(location, value)
    }

    actual fun uniform2f(location: GLint, v0: GLfloat, v1: GLfloat) {
        GL46.glUniform2f(location, v0, v1)
    }

    actual fun uniform2fv(location: GLint, value: FloatArray) {
        GL46.glUniform2fv(location, value)
    }

    actual fun uniform2i(location: GLint, v0: GLint, v1: GLint) {
        GL46.glUniform2i(location, v0, v1)
    }

    actual fun uniform2iv(location: GLint, value: IntArray) {
        GL46.glUniform2iv(location, value)
    }

    actual fun uniform3f(location: GLint, v0: GLfloat, v1: GLfloat, v2: GLfloat) {
        GL46.glUniform3f(location, v0, v1, v2)
    }

    actual fun uniform3fv(location: GLint, value: FloatArray) {
        GL46.glUniform3fv(location, value)
    }

    actual fun uniform3i(location: GLint, v0: GLint, v1: GLint, v2: GLint) {
        GL46.glUniform3i(location, v0, v1, v2)
    }

    actual fun uniform3iv(location: GLint, value: IntArray) {
        GL46.glUniform3iv(location, value)
    }

    actual fun uniform4f(location: GLint, v0: GLfloat, v1: GLfloat, v2: GLfloat, v3: GLfloat) {
        GL46.glUniform4f(location, v0, v1, v2, v3)
    }

    actual fun uniform4fv(location: GLint, value: FloatArray) {
        GL46.glUniform4fv(location, value)
    }

    actual fun uniform4i(location: GLint, v0: GLint, v1: GLint, v2: GLint, v3: GLint) {
        GL46.glUniform4i(location, v0, v1, v2, v3)
    }

    actual fun uniform4iv(location: GLint, value: IntArray) {
        GL46.glUniform4iv(location, value)
    }

    actual fun uniformMatrix2fv(location: GLint, transpose: GLboolean, value: FloatArray) {
        GL46.glUniformMatrix2fv(location, transpose, value)
    }

    actual fun uniformMatrix3fv(location: GLint, transpose: GLboolean, value: FloatArray) {
        GL46.glUniformMatrix3fv(location, transpose, value)
    }

    actual fun uniformMatrix4fv(location: GLint, transpose: GLboolean, value: FloatArray) {
        GL46.glUniformMatrix4fv(location, transpose, value)
    }

    actual fun useProgram(program: GLuint) {
        GL46.glUseProgram(program)
    }

    actual fun validateProgram(program: GLuint) {
        GL46.glValidateProgram(program)
    }

    actual fun vertexAttrib1f(index: GLuint, x: GLfloat) {
        GL46.glVertexAttrib1f(index, x)
    }

    actual fun vertexAttrib1fv(index: GLuint, v: FloatArray) {
        GL46.glVertexAttrib1fv(index, v)
    }

    actual fun vertexAttrib2f(index: GLuint, x: GLfloat, y: GLfloat) {
        GL46.glVertexAttrib2f(index, x, y)
    }

    actual fun vertexAttrib2fv(index: GLuint, v: FloatArray) {
        GL46.glVertexAttrib2fv(index, v)
    }

    actual fun vertexAttrib3f(index: GLuint, x: GLfloat, y: GLfloat, z: GLfloat) {
        GL46.glVertexAttrib3f(index, x, y, z)
    }

    actual fun vertexAttrib3fv(index: GLuint, v: FloatArray) {
        GL46.glVertexAttrib3fv(index, v)
    }

    actual fun vertexAttrib4f(index: GLuint, x: GLfloat, y: GLfloat, z: GLfloat, w: GLfloat) {
        GL46.glVertexAttrib4f(index, x, y, z, w)
    }

    actual fun vertexAttrib4fv(index: GLuint, v: FloatArray) {
        GL46.glVertexAttrib4fv(index, v)
    }

    actual fun vertexAttribPointer(index: GLuint, size: GLint, type: GLenum, normalized: GLboolean, stride: GLsizei) {
        GL46.glVertexAttribPointer(index, size, type, normalized, stride, NULL)
    }

    actual fun vertexAttribPointer(index: GLuint, size: GLint, type: GLenum, normalized: GLboolean, stride: GLsizei, offset: GLsizei) {
        GL46.glVertexAttribPointer(index, size, type, normalized, stride, offset.toLong())
    }

    actual fun viewport(x: GLint, y: GLint, width: GLsizei, height: GLsizei) {
        GL46.glViewport(x, y, width, height)
    }
}
