package io.github.inoutch.kotlin.gl.api

import io.github.inoutch.kotlin.gl.constant.FLOAT_BYTE_SIZE
import io.github.inoutch.kotlin.gl.constant.INT_BYTE_SIZE
import io.github.inoutch.kotlin.gl.error.UnsupportedGLError
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointerVar
import kotlinx.cinterop.alloc
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.cstr
import kotlinx.cinterop.get
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.refTo
import kotlinx.cinterop.set
import kotlinx.cinterop.toByte
import kotlinx.cinterop.toCPointer
import kotlinx.cinterop.toKStringFromUtf8
import kotlinx.cinterop.value
import platform.gles2.glActiveTexture
import platform.gles2.glAttachShader
import platform.gles2.glBindAttribLocation
import platform.gles2.glBindBuffer
import platform.gles2.glBindFramebuffer
import platform.gles2.glBindRenderbuffer
import platform.gles2.glBindTexture
import platform.gles2.glBlendColor
import platform.gles2.glBlendEquation
import platform.gles2.glBlendEquationSeparate
import platform.gles2.glBlendFunc
import platform.gles2.glBlendFuncSeparate
import platform.gles2.glBufferData
import platform.gles2.glBufferSubData
import platform.gles2.glCheckFramebufferStatus
import platform.gles2.glClear
import platform.gles2.glClearColor
import platform.gles2.glClearDepthf
import platform.gles2.glClearStencil
import platform.gles2.glColorMask
import platform.gles2.glCompileShader
import platform.gles2.glCompressedTexImage2D
import platform.gles2.glCompressedTexSubImage2D
import platform.gles2.glCopyTexImage2D
import platform.gles2.glCopyTexSubImage2D
import platform.gles2.glCreateProgram
import platform.gles2.glCreateShader
import platform.gles2.glCullFace
import platform.gles2.glDeleteBuffers
import platform.gles2.glDeleteFramebuffers
import platform.gles2.glDeleteProgram
import platform.gles2.glDeleteRenderbuffers
import platform.gles2.glDeleteShader
import platform.gles2.glDeleteTextures
import platform.gles2.glDepthFunc
import platform.gles2.glDepthMask
import platform.gles2.glDepthRangef
import platform.gles2.glDetachShader
import platform.gles2.glDisable
import platform.gles2.glDisableVertexAttribArray
import platform.gles2.glDrawArrays
import platform.gles2.glDrawElements
import platform.gles2.glEnable
import platform.gles2.glEnableVertexAttribArray
import platform.gles2.glFinish
import platform.gles2.glFlush
import platform.gles2.glFramebufferRenderbuffer
import platform.gles2.glFramebufferTexture2D
import platform.gles2.glFrontFace
import platform.gles2.glGenBuffers
import platform.gles2.glGenFramebuffers
import platform.gles2.glGenRenderbuffers
import platform.gles2.glGenTextures
import platform.gles2.glGenerateMipmap
import platform.gles2.glGetActiveAttrib
import platform.gles2.glGetActiveUniform
import platform.gles2.glGetAttachedShaders
import platform.gles2.glGetAttribLocation
import platform.gles2.glGetBufferParameteriv
import platform.gles2.glGetError
import platform.gles2.glGetFramebufferAttachmentParameteriv
import platform.gles2.glGetIntegerv
import platform.gles2.glGetProgramInfoLog
import platform.gles2.glGetProgramiv
import platform.gles2.glGetRenderbufferParameteriv
import platform.gles2.glGetShaderInfoLog
import platform.gles2.glGetShaderPrecisionFormat
import platform.gles2.glGetShaderSource
import platform.gles2.glGetString
import platform.gles2.glGetTexParameterfv
import platform.gles2.glGetTexParameteriv
import platform.gles2.glGetUniformLocation
import platform.gles2.glGetUniformfv
import platform.gles2.glGetUniformiv
import platform.gles2.glGetVertexAttribfv
import platform.gles2.glGetVertexAttribiv
import platform.gles2.glHint
import platform.gles2.glIsBuffer
import platform.gles2.glIsEnabled
import platform.gles2.glIsFramebuffer
import platform.gles2.glIsProgram
import platform.gles2.glIsRenderbuffer
import platform.gles2.glIsShader
import platform.gles2.glIsTexture
import platform.gles2.glLineWidth
import platform.gles2.glLinkProgram
import platform.gles2.glPixelStorei
import platform.gles2.glPolygonOffset
import platform.gles2.glReadPixels
import platform.gles2.glReleaseShaderCompiler
import platform.gles2.glRenderbufferStorage
import platform.gles2.glSampleCoverage
import platform.gles2.glScissor
import platform.gles2.glShaderBinary
import platform.gles2.glShaderSource
import platform.gles2.glStencilFunc
import platform.gles2.glStencilMask
import platform.gles2.glStencilMaskSeparate
import platform.gles2.glStencilOp
import platform.gles2.glStencilOpSeparate
import platform.gles2.glTexImage2D
import platform.gles2.glTexParameterf
import platform.gles2.glTexParameterfv
import platform.gles2.glTexParameteri
import platform.gles2.glTexParameteriv
import platform.gles2.glTexSubImage2D
import platform.gles2.glUniform1f
import platform.gles2.glUniform1fv
import platform.gles2.glUniform1i
import platform.gles2.glUniform1iv
import platform.gles2.glUniform2f
import platform.gles2.glUniform2fv
import platform.gles2.glUniform2i
import platform.gles2.glUniform2iv
import platform.gles2.glUniform3f
import platform.gles2.glUniform3fv
import platform.gles2.glUniform3i
import platform.gles2.glUniform3iv
import platform.gles2.glUniform4f
import platform.gles2.glUniform4fv
import platform.gles2.glUniform4i
import platform.gles2.glUniform4iv
import platform.gles2.glUniformMatrix2fv
import platform.gles2.glUniformMatrix3fv
import platform.gles2.glUniformMatrix4fv
import platform.gles2.glUseProgram
import platform.gles2.glValidateProgram
import platform.gles2.glVertexAttrib1f
import platform.gles2.glVertexAttrib1fv
import platform.gles2.glVertexAttrib2f
import platform.gles2.glVertexAttrib2fv
import platform.gles2.glVertexAttrib3f
import platform.gles2.glVertexAttrib3fv
import platform.gles2.glVertexAttrib4f
import platform.gles2.glVertexAttrib4fv
import platform.gles2.glVertexAttribPointer
import platform.gles2.glViewport
import platform.glescommon.GLcharVar
import platform.glescommon.GLenumVar
import platform.glescommon.GLfloatVar
import platform.glescommon.GLintVar
import platform.glescommon.GLsizeiVar
import platform.glescommon.GLuintVar

@ExperimentalUnsignedTypes
actual object gl {

    actual fun activeTexture(texture: GLenum) {
        glActiveTexture(texture.toUInt())
    }

    actual fun attachShader(program: GLuint, shader: GLuint) {
        glAttachShader(program.toUInt(), shader.toUInt())
    }

    actual fun bindAttribLocation(program: GLuint, index: GLuint, name: String) {
        glBindAttribLocation(program.toUInt(), index.toUInt(), name)
    }

    actual fun bindBuffer(target: GLenum, buffer: GLuint) {
        glBindBuffer(target.toUInt(), buffer.toUInt())
    }

    actual fun bindFramebuffer(target: GLenum, framebuffer: GLuint) {
        glBindFramebuffer(target.toUInt(), framebuffer.toUInt())
    }

    actual fun bindRenderbuffer(target: GLenum, renderbuffer: GLuint) {
        glBindRenderbuffer(target.toUInt(), renderbuffer.toUInt())
    }

    actual fun bindTexture(target: GLenum, texture: GLuint) {
        glBindTexture(target.toUInt(), texture.toUInt())
    }

    actual fun blendColor(red: GLfloat, green: GLfloat, blue: GLfloat, alpha: GLfloat) {
        glBlendColor(red, green, blue, alpha)
    }

    actual fun blendEquation(mode: GLenum) {
        glBlendEquation(mode.toUInt())
    }

    actual fun blendEquationSeparate(modeRGB: GLenum, modeAlpha: GLenum) {
        glBlendEquationSeparate(modeRGB.toUInt(), modeAlpha.toUInt())
    }

    actual fun blendFunc(sfactor: GLenum, dfactor: GLenum) {
        glBlendFunc(sfactor.toUInt(), dfactor.toUInt())
    }

    actual fun blendFuncSeparate(sfactorRGB: GLenum, dfactorRGB: GLenum, sfactorAlpha: GLenum, dfactorAlpha: GLenum) {
        glBlendFuncSeparate(sfactorRGB.toUInt(), dfactorRGB.toUInt(), sfactorAlpha.toUInt(), dfactorAlpha.toUInt())
    }

    actual fun bufferData(target: GLenum, data: IntArray, usage: GLenum) {
        glBufferData(target.toUInt(), (data.size * INT_BYTE_SIZE).toLong(), data.refTo(0), usage.toUInt())
    }

    actual fun bufferData(target: GLenum, data: IntArray, size: GLint, usage: GLenum) {
        glBufferData(target.toUInt(), (size * INT_BYTE_SIZE).toLong(), data.refTo(0), usage.toUInt())
    }

    actual fun bufferData(target: GLenum, data: FloatArray, usage: GLenum) {
        glBufferData(target.toUInt(), (data.size * FLOAT_BYTE_SIZE).toLong(), data.refTo(0), usage.toUInt())
    }

    actual fun bufferData(target: GLenum, data: FloatArray, size: GLint, usage: GLenum) {
        glBufferData(target.toUInt(), (size * FLOAT_BYTE_SIZE).toLong(), data.refTo(0), usage.toUInt())
    }

    actual fun bufferData(target: GLenum, data: ByteArray, usage: GLenum) {
        glBufferData(target.toUInt(), data.size.toLong(), data.refTo(0), usage.toUInt())
    }

    actual fun bufferData(target: GLenum, data: ByteArray, size: GLint, usage: GLenum) {
        glBufferData(target.toUInt(), size.toLong(), data.refTo(0), usage.toUInt())
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: IntArray) {
        glBufferSubData(target.toUInt(), offset, (data.size * INT_BYTE_SIZE).toLong(), data.refTo(0))
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: IntArray, size: GLint) {
        glBufferSubData(target.toUInt(), offset, (size * INT_BYTE_SIZE).toLong(), data.refTo(0))
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: FloatArray) {
        glBufferSubData(target.toUInt(), offset, (data.size * FLOAT_BYTE_SIZE).toLong(), data.refTo(0))
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: FloatArray, size: GLint) {
        glBufferSubData(target.toUInt(), offset, (size * FLOAT_BYTE_SIZE).toLong(), data.refTo(0))
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: ByteArray) {
        glBufferSubData(target.toUInt(), offset, data.size.toLong(), data.refTo(0))
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: ByteArray, size: GLint) {
        glBufferSubData(target.toUInt(), offset, size.toLong(), data.refTo(0))
    }

    actual fun checkFramebufferStatus(target: GLenum): GLenum {
        return glCheckFramebufferStatus(target.toUInt()).toInt()
    }

    actual fun clear(mask: GLbitfield) {
        glClear(mask.toUInt())
    }

    actual fun clearColor(red: GLfloat, green: GLfloat, blue: GLfloat, alpha: GLfloat) {
        glClearColor(red, green, blue, alpha)
    }

    actual fun clearDepthf(d: GLfloat) {
        glClearDepthf(d)
    }

    actual fun clearStencil(s: GLint) {
        glClearStencil(s)
    }

    actual fun colorMask(red: GLboolean, green: GLboolean, blue: GLboolean, alpha: GLboolean) {
        glColorMask(red.toByte().toUByte(), green.toByte().toUByte(), blue.toByte().toUByte(), alpha.toByte().toUByte())
    }

    actual fun compileShader(shader: GLuint) {
        glCompileShader(shader.toUInt())
    }

    actual fun compressedTexImage2D(target: GLenum, level: GLint, internalformat: GLenum, width: GLsizei, height: GLsizei, border: GLint, data: ByteArray) {
        glCompressedTexImage2D(target.toUInt(), level, internalformat.toUInt(), width, height, border, data.size, data.refTo(0))
    }

    actual fun compressedTexSubImage2D(target: GLenum, level: GLint, xoffset: GLint, yoffset: GLint, width: GLsizei, height: GLsizei, format: GLenum, data: ByteArray) {
        glCompressedTexSubImage2D(target.toUInt(), level, xoffset, yoffset, width, height, format.toUInt(), data.size, data.refTo(0))
    }

    actual fun copyTexImage2D(target: GLenum, level: GLint, internalformat: GLenum, x: GLint, y: GLint, width: GLsizei, height: GLsizei, border: GLint) {
        glCopyTexImage2D(target.toUInt(), level, internalformat.toUInt(), x, y, width, height, border)
    }

    actual fun copyTexSubImage2D(target: GLenum, level: GLint, xoffset: GLint, yoffset: GLint, x: GLint, y: GLint, width: GLsizei, height: GLsizei) {
        glCopyTexSubImage2D(target.toUInt(), level, xoffset, yoffset, x, y, width, height)
    }

    actual fun createProgram(): GLuint {
        return glCreateProgram().toInt()
    }

    actual fun createShader(type: GLenum): GLuint {
        return glCreateShader(type.toUInt()).toInt()
    }

    actual fun cullFace(mode: GLenum) {
        glCullFace(mode.toUInt())
    }

    actual fun deleteBuffers(buffers: IntArray) {
        glDeleteBuffers(buffers.size, buffers.toUIntArray().refTo(0))
    }

    actual fun deleteFramebuffers(framebuffers: IntArray) {
        glDeleteFramebuffers(framebuffers.size, framebuffers.toUIntArray().refTo(0))
    }

    actual fun deleteProgram(program: GLuint) {
        glDeleteProgram(program.toUInt())
    }

    actual fun deleteRenderbuffers(renderbuffers: IntArray) {
        glDeleteRenderbuffers(renderbuffers.size, renderbuffers.toUIntArray().refTo(0))
    }

    actual fun deleteShader(shader: GLuint) {
        glDeleteShader(shader.toUInt())
    }

    actual fun deleteTextures(textures: IntArray) {
        glDeleteTextures(textures.size, textures.toUIntArray().refTo(0))
    }

    actual fun depthFunc(func: GLenum) {
        glDepthFunc(func.toUInt())
    }

    actual fun depthMask(flag: GLboolean) {
        glDepthMask(flag.toByte().toUByte())
    }

    actual fun depthRangef(n: GLfloat, f: GLfloat) {
        glDepthRangef(n, f)
    }

    actual fun detachShader(program: GLuint, shader: GLuint) {
        glDetachShader(program.toUInt(), shader.toUInt())
    }

    actual fun disable(cap: GLenum) {
        glDisable(cap.toUInt())
    }

    actual fun disableVertexAttribArray(index: GLuint) {
        glDisableVertexAttribArray(index.toUInt())
    }

    actual fun drawArrays(mode: GLenum, first: GLint, count: GLsizei) {
        glDrawArrays(mode.toUInt(), first, count)
    }

    actual fun drawElements(mode: GLenum, indices: IntArray) {
        glDrawElements(mode.toUInt(), indices.size, GL_INT.toUInt(), indices.refTo(0))
    }

    actual fun enable(cap: GLenum) {
        glEnable(cap.toUInt())
    }

    actual fun enableVertexAttribArray(index: GLuint) {
        glEnableVertexAttribArray(index.toUInt())
    }

    actual fun finish() {
        glFinish()
    }

    actual fun flush() {
        glFlush()
    }

    actual fun framebufferRenderbuffer(target: GLenum, attachment: GLenum, renderbuffertarget: GLenum, renderbuffer: GLuint) {
        glFramebufferRenderbuffer(target.toUInt(), attachment.toUInt(), renderbuffertarget.toUInt(), renderbuffer.toUInt())
    }

    actual fun framebufferTexture2D(target: GLenum, attachment: GLenum, textarget: GLenum, texture: GLuint, level: GLint) {
        glFramebufferTexture2D(target.toUInt(), attachment.toUInt(), textarget.toUInt(), texture.toUInt(), level)
    }

    actual fun frontFace(mode: GLenum) {
        glFrontFace(mode.toUInt())
    }

    actual fun genBuffers(n: GLsizei) = memScoped {
        val uintArray = allocArray<GLuintVar>(n)
        glGenBuffers(n, uintArray)
        (0 until n).map { uintArray[it].toInt() }.toIntArray()
    }

    actual fun generateMipmap(target: GLenum) {
        glGenerateMipmap(target.toUInt())
    }

    actual fun genFramebuffers(n: GLsizei) = memScoped {
        val uintArray = allocArray<GLuintVar>(n)
        glGenFramebuffers(n, uintArray)
        (0 until n).map { uintArray[it].toInt() }.toIntArray()
    }

    actual fun genRenderbuffers(n: GLsizei) = memScoped {
        val uintArray = allocArray<GLuintVar>(n)
        glGenRenderbuffers(n, uintArray)
        (0 until n).map { uintArray[it].toInt() }.toIntArray()
    }

    actual fun genTextures(n: GLsizei) = memScoped {
        val uintArray = allocArray<GLuintVar>(n)
        glGenTextures(n, uintArray)
        (0 until n).map { uintArray[it].toInt() }.toIntArray()
    }

    actual fun getActiveAttribSize(program: GLuint) = memScoped {
        val length = alloc<GLsizeiVar>()
        val size = alloc<GLintVar>()
        val type = alloc<GLenumVar>()
        val name = alloc<GLcharVar>()
        glGetActiveAttrib(program.toUInt(), 0, 0, length.ptr, size.ptr, type.ptr, name.ptr)
        size.value.toInt()
    }

    actual fun getActiveAttrib(program: GLuint, index: GLuint): Pair<String, GLint> = memScoped {
        val length = alloc<GLsizeiVar>()
        val size = alloc<GLintVar>()
        val type = alloc<GLenumVar>()
        var name = allocArray<GLcharVar>(1)

        glGetActiveAttrib(program.toUInt(), index.toUInt(), 0, length.ptr, size.ptr, type.ptr, name)
        name = allocArray(length.value)

        glGetActiveAttrib(program.toUInt(), index.toUInt(), length.value, length.ptr, size.ptr, type.ptr, name)
        name.toKStringFromUtf8() to type.value.toInt()
    }

    actual fun getActiveUniformSize(program: GLuint): GLint = memScoped {
        val length = alloc<GLsizeiVar>()
        val size = alloc<GLintVar>()
        val type = alloc<GLenumVar>()
        val name = alloc<GLcharVar>()
        glGetActiveUniform(program.toUInt(), 0, 0, length.ptr, size.ptr, type.ptr, name.ptr)
        size.value.toInt()
    }

    actual fun getActiveUniform(program: GLuint, index: GLuint): Pair<String, GLint> = memScoped {
        val length = alloc<GLsizeiVar>()
        val size = alloc<GLintVar>()
        val type = alloc<GLenumVar>()
        var name = allocArray<GLcharVar>(1)

        glGetActiveUniform(program.toUInt(), index.toUInt(), 0, length.ptr, size.ptr, type.ptr, name)
        name = allocArray(length.value)

        glGetActiveUniform(program.toUInt(), index.toUInt(), length.value, length.ptr, size.ptr, type.ptr, name)
        return name.toKStringFromUtf8() to type.value.toInt()
    }

    actual fun getAttachedShaders(program: GLuint): IntArray = memScoped {
        var uintArray = allocArray<GLuintVar>(1)
        val count = alloc<GLsizeiVar>()
        glGetAttachedShaders(program.toUInt(), 0, count.ptr, uintArray)

        uintArray = allocArray(count.value.toInt())
        glGetAttachedShaders(program.toUInt(), count.value, count.ptr, uintArray)
        (0 until count.value).map { uintArray[it].toInt() }.toIntArray()
    }

    actual fun getAttribLocation(program: GLuint, name: String): GLint {
        return glGetAttribLocation(program.toUInt(), name)
    }

    actual fun getBooleanv(pname: GLenum): Boolean {
        throw UnsupportedGLError()
    }

    actual fun getBufferParameteriv(target: GLenum, pname: GLenum): GLint = memScoped {
        val params = alloc<GLintVar>()
        glGetBufferParameteriv(target.toUInt(), pname.toUInt(), params.ptr)
        params.value
    }

    actual fun getError(): GLenum {
        return glGetError().toInt()
    }

    actual fun getFloatv(pname: GLenum): Float {
        throw UnsupportedGLError()
    }

    actual fun getFramebufferAttachmentParameteriv(target: GLenum, attachment: GLenum, pname: GLenum): GLint = memScoped {
        val params = alloc<GLintVar>()
        glGetFramebufferAttachmentParameteriv(target.toUInt(), attachment.toUInt(), pname.toUInt(), params.ptr)
        params.value
    }

    actual fun getIntegerv(pname: GLenum): GLint = memScoped {
        val params = alloc<GLintVar>()
        glGetIntegerv(pname.toUInt(), params.ptr)
        params.value
    }

    actual fun getProgramiv(program: GLuint, pname: GLenum): GLint = memScoped {
        val params = alloc<GLintVar>()
        glGetProgramiv(program.toUInt(), pname.toUInt(), params.ptr)
        params.value
    }

    actual fun getProgramInfoLog(program: GLuint): String? = memScoped {
        val length = alloc<GLsizeiVar>()
        var infolog = allocArray<GLcharVar>(1)

        glGetProgramInfoLog(program.toUInt(), 0, length.ptr, infolog)
        if (length.value == 0) {
            return@memScoped null
        }
        infolog = allocArray(length.value)

        glGetProgramInfoLog(program.toUInt(), length.value, length.ptr, infolog)
        infolog.toKStringFromUtf8()
    }

    actual fun getRenderbufferParameteriv(target: GLenum, pname: GLenum): GLint = memScoped {
        val params = alloc<GLintVar>()
        glGetRenderbufferParameteriv(target.toUInt(), pname.toUInt(), params.ptr)
        params.value
    }

    actual fun getShaderiv(shader: GLuint, pname: GLenum): GLint {
        throw UnsupportedGLError()
    }

    actual fun getShaderInfoLog(shader: GLuint): String? = memScoped {
        val length = alloc<GLsizeiVar>()
        var infolog = allocArray<GLcharVar>(1)

        glGetShaderInfoLog(shader.toUInt(), 0, length.ptr, infolog)
        if (length.value == 0) {
            return@memScoped null
        }
        infolog = allocArray(length.value)

        glGetShaderInfoLog(shader.toUInt(), length.value, length.ptr, infolog)
        infolog.toKStringFromUtf8()
    }

    actual fun getShaderPrecisionFormat(shadertype: GLenum, precisiontype: GLenum): Pair<GLint, GLint> = memScoped {
        val range = alloc<GLintVar>()
        val precision = alloc<GLintVar>()
        glGetShaderPrecisionFormat(shadertype.toUInt(), precisiontype.toUInt(), range.ptr, precision.ptr)
        range.value to precision.value
    }

    actual fun getShaderSource(shader: GLuint): String = memScoped {
        val length = alloc<GLsizeiVar>()
        var source = allocArray<GLcharVar>(1)
        glGetShaderSource(shader.toUInt(), 0, length.ptr, source)

        source = allocArray<GLcharVar>(length.value)
        glGetShaderSource(shader.toUInt(), length.value, length.ptr, source)
        source.toKStringFromUtf8()
    }

    actual fun getString(name: GLenum): String? {
        val result = glGetString(name.toUInt()) ?: return null
        val array = mutableListOf<Byte>()
        var i = 0
        while (result[i] == 0u.toUByte()) {
            array.add(result[i].toByte())
            i++
        }
        return array.toString()
    }

    actual fun getTexParameterfv(target: GLenum, pname: GLenum): GLfloat = memScoped {
        val params = alloc<GLfloatVar>()
        glGetTexParameterfv(target.toUInt(), pname.toUInt(), params.ptr)
        params.value
    }

    actual fun getTexParameteriv(target: GLenum, pname: GLenum): GLint = memScoped {
        val params = alloc<GLintVar>()
        glGetTexParameteriv(target.toUInt(), pname.toUInt(), params.ptr)
        params.value
    }

    actual fun getUniformfv(program: GLuint, location: GLint): GLfloat = memScoped {
        val params = alloc<GLfloatVar>()
        glGetUniformfv(program.toUInt(), location, params.ptr)
        params.value
    }

    actual fun getUniformiv(program: GLuint, location: GLint): GLint = memScoped {
        val params = alloc<GLintVar>()
        glGetUniformiv(program.toUInt(), location, params.ptr)
        params.value
    }

    actual fun getUniformLocation(program: GLuint, name: String): GLint {
        return glGetUniformLocation(program.toUInt(), name)
    }

    actual fun getVertexAttribfv(index: GLuint, pname: GLenum): GLfloat = memScoped {
        val params = alloc<GLfloatVar>()
        glGetVertexAttribfv(index.toUInt(), pname.toUInt(), params.ptr)
        params.value
    }

    actual fun getVertexAttribiv(index: GLuint, pname: GLenum): GLint = memScoped {
        val params = alloc<GLintVar>()
        glGetVertexAttribiv(index.toUInt(), pname.toUInt(), params.ptr)
        params.value
    }

    actual fun hint(target: GLenum, mode: GLenum) {
        glHint(target.toUInt(), mode.toUInt())
    }

    actual fun isBuffer(buffer: GLuint): GLboolean {
        return glIsBuffer(buffer.toUInt()) == 1.toUByte()
    }

    actual fun isEnabled(cap: GLenum): GLboolean {
        return glIsEnabled(cap.toUInt()) == 1.toUByte()
    }

    actual fun isFramebuffer(framebuffer: GLuint): GLboolean {
        return glIsFramebuffer(framebuffer.toUInt()) == 1.toUByte()
    }

    actual fun isProgram(program: GLuint): GLboolean {
        return glIsProgram(program.toUInt()) == 1.toUByte()
    }

    actual fun isRenderbuffer(renderbuffer: GLuint): GLboolean {
        return glIsRenderbuffer(renderbuffer.toUInt()) == 1.toUByte()
    }

    actual fun isShader(shader: GLuint): GLboolean {
        return glIsShader(shader.toUInt()) == 1.toUByte()
    }

    actual fun isTexture(texture: GLuint): GLboolean {
        return glIsTexture(texture.toUInt()) == 1.toUByte()
    }

    actual fun lineWidth(width: GLfloat) {
        glLineWidth(width)
    }

    actual fun linkProgram(program: GLuint) {
        glLinkProgram(program.toUInt())
    }

    actual fun pixelStorei(pname: GLenum, param: GLint) {
        glPixelStorei(pname.toUInt(), param)
    }

    actual fun polygonOffset(factor: GLfloat, units: GLfloat) {
        glPolygonOffset(factor, units)
    }

    actual fun readPixelsi(x: GLint, y: GLint, width: GLsizei, height: GLsizei, format: GLenum, type: GLenum): IntArray {
        val intArray = IntArray(width * height)
        glReadPixels(x, y, width, height, format.toUInt(), type.toUInt(), intArray.refTo(0))
        return intArray
    }

    actual fun readPixelsf(x: GLint, y: GLint, width: GLsizei, height: GLsizei, format: GLenum, type: GLenum): FloatArray {
        val floatArray = FloatArray(width * height)
        glReadPixels(x, y, width, height, format.toUInt(), type.toUInt(), floatArray.refTo(0))
        return floatArray
    }

    actual fun releaseShaderCompiler() {
        glReleaseShaderCompiler()
    }

    actual fun renderbufferStorage(target: GLenum, internalformat: GLenum, width: GLsizei, height: GLsizei) {
        glRenderbufferStorage(target.toUInt(), internalformat.toUInt(), width, height)
    }

    actual fun sampleCoverage(value: GLfloat, invert: GLboolean) {
        glSampleCoverage(value, invert.toByte().toUByte())
    }

    actual fun scissor(x: GLint, y: GLint, width: GLsizei, height: GLsizei) {
        glScissor(x, y, width, height)
    }

    actual fun shaderBinary(shaders: IntArray, binaryformat: GLenum, binary: ByteArray) {
        glShaderBinary(shaders.size, shaders.toUIntArray().refTo(0), binaryformat.toUInt(), binary.refTo(0), binary.size)
    }

    actual fun shaderSource(shader: GLuint, string: String) = memScoped {
        val strings = allocArray<CPointerVar<GLcharVar>>(1)
        val lengths = alloc<GLintVar>()
        strings[0] = string.cstr.ptr
        lengths.value = string.length
        glShaderSource(shader.toUInt(), 1, strings, lengths.ptr)
    }

    actual fun stencilFunc(func: GLenum, ref: GLint, mask: GLuint) {
        glStencilFunc(func.toUInt(), ref, mask.toUInt())
    }

    actual fun stencilFuncSeparate(face: GLenum, func: GLenum, ref: GLint, mask: GLuint) {
        glStencilFunc(func.toUInt(), ref, mask.toUInt())
    }

    actual fun stencilMask(mask: GLuint) {
        glStencilMask(mask.toUInt())
    }

    actual fun stencilMaskSeparate(face: GLenum, mask: GLuint) {
        glStencilMaskSeparate(face.toUInt(), mask.toUInt())
    }

    actual fun stencilOp(fail: GLenum, zfail: GLenum, zpass: GLenum) {
        glStencilOp(fail.toUInt(), zfail.toUInt(), zpass.toUInt())
    }

    actual fun stencilOpSeparate(face: GLenum, sfail: GLenum, dpfail: GLenum, dppass: GLenum) {
        glStencilOpSeparate(face.toUInt(), sfail.toUInt(), dpfail.toUInt(), dppass.toUInt())
    }

    actual fun texImage2D(target: GLenum, level: GLint, internalformat: GLint, width: GLsizei, height: GLsizei, border: GLint, format: GLenum, type: GLenum, pixels: ByteArray) {
        glTexImage2D(target.toUInt(), level, internalformat, width, height, border, format.toUInt(), type.toUInt(), pixels.refTo(0))
    }

    actual fun texParameterf(target: GLenum, pname: GLenum, param: GLfloat) {
        glTexParameterf(target.toUInt(), pname.toUInt(), param)
    }

    actual fun texParameterfv(target: GLenum, pname: GLenum, params: FloatArray) {
        glTexParameterfv(target.toUInt(), pname.toUInt(), params.refTo(0))
    }

    actual fun texParameteri(target: GLenum, pname: GLenum, param: GLint) {
        glTexParameteri(target.toUInt(), pname.toUInt(), param)
    }

    actual fun texParameteriv(target: GLenum, pname: GLenum, params: IntArray) {
        glTexParameteriv(target.toUInt(), pname.toUInt(), params.refTo(0))
    }

    actual fun texSubImage2D(target: GLenum, level: GLint, xoffset: GLint, yoffset: GLint, width: GLsizei, height: GLsizei, format: GLenum, type: GLenum, pixels: ByteArray) {
        glTexSubImage2D(target.toUInt(), level, xoffset, yoffset, width, height, format.toUInt(), type.toUInt(), pixels.refTo(0))
    }

    actual fun uniform1f(location: GLint, v0: GLfloat) {
        glUniform1f(location, v0)
    }

    actual fun uniform1fv(location: GLint, value: FloatArray) {
        glUniform1fv(location, value.size, value.refTo(0))
    }

    actual fun uniform1i(location: GLint, v0: GLint) {
        glUniform1i(location, v0)
    }

    actual fun uniform1iv(location: GLint, value: IntArray) {
        glUniform1iv(location, value.size, value.refTo(0))
    }

    actual fun uniform2f(location: GLint, v0: GLfloat, v1: GLfloat) {
        glUniform2f(location, v0, v1)
    }

    actual fun uniform2fv(location: GLint, value: FloatArray) {
        glUniform2fv(location, value.size, value.refTo(0))
    }

    actual fun uniform2i(location: GLint, v0: GLint, v1: GLint) {
        glUniform2i(location, v0, v1)
    }

    actual fun uniform2iv(location: GLint, value: IntArray) {
        glUniform2iv(location, value.size, value.refTo(0))
    }

    actual fun uniform3f(location: GLint, v0: GLfloat, v1: GLfloat, v2: GLfloat) {
        glUniform3f(location, v0, v1, v2)
    }

    actual fun uniform3fv(location: GLint, value: FloatArray) {
        glUniform3fv(location, value.size, value.refTo(0))
    }

    actual fun uniform3i(location: GLint, v0: GLint, v1: GLint, v2: GLint) {
        glUniform3i(location, v0, v1, v2)
    }

    actual fun uniform3iv(location: GLint, value: IntArray) {
        glUniform3iv(location, value.size, value.refTo(0))
    }

    actual fun uniform4f(location: GLint, v0: GLfloat, v1: GLfloat, v2: GLfloat, v3: GLfloat) {
        glUniform4f(location, v0, v1, v2, v3)
    }

    actual fun uniform4fv(location: GLint, value: FloatArray) {
        glUniform4fv(location, value.size, value.refTo(0))
    }

    actual fun uniform4i(location: GLint, v0: GLint, v1: GLint, v2: GLint, v3: GLint) {
        glUniform4i(location, v0, v1, v2, v3)
    }

    actual fun uniform4iv(location: GLint, value: IntArray) {
        glUniform4iv(location, value.size, value.refTo(0))
    }

    actual fun uniformMatrix2fv(location: GLint, transpose: GLboolean, value: FloatArray) {
        glUniformMatrix2fv(location, value.size, transpose.toByte().toUByte(), value.refTo(0))
    }

    actual fun uniformMatrix3fv(location: GLint, transpose: GLboolean, value: FloatArray) {
        glUniformMatrix3fv(location, value.size, transpose.toByte().toUByte(), value.refTo(0))
    }

    actual fun uniformMatrix4fv(location: GLint, transpose: GLboolean, value: FloatArray) {
        glUniformMatrix4fv(location, value.size, transpose.toByte().toUByte(), value.refTo(0))
    }

    actual fun useProgram(program: GLuint) {
        glUseProgram(program.toUInt())
    }

    actual fun validateProgram(program: GLuint) {
        glValidateProgram(program.toUInt())
    }

    actual fun vertexAttrib1f(index: GLuint, x: GLfloat) {
        glVertexAttrib1f(index.toUInt(), x)
    }

    actual fun vertexAttrib1fv(index: GLuint, v: FloatArray) {
        glVertexAttrib1fv(index.toUInt(), v.refTo(0))
    }

    actual fun vertexAttrib2f(index: GLuint, x: GLfloat, y: GLfloat) {
        glVertexAttrib2f(index.toUInt(), x, y)
    }

    actual fun vertexAttrib2fv(index: GLuint, v: FloatArray) {
        glVertexAttrib2fv(index.toUInt(), v.refTo(0))
    }

    actual fun vertexAttrib3f(index: GLuint, x: GLfloat, y: GLfloat, z: GLfloat) {
        glVertexAttrib3f(index.toUInt(), x, y, z)
    }

    actual fun vertexAttrib3fv(index: GLuint, v: FloatArray) {
        glVertexAttrib3fv(index.toUInt(), v.refTo(0))
    }

    actual fun vertexAttrib4f(index: GLuint, x: GLfloat, y: GLfloat, z: GLfloat, w: GLfloat) {
        glVertexAttrib4f(index.toUInt(), x, y, z, w)
    }

    actual fun vertexAttrib4fv(index: GLuint, v: FloatArray) {
        glVertexAttrib4fv(index.toUInt(), v.refTo(0))
    }

    actual fun vertexAttribPointer(index: GLuint, size: GLint, type: GLenum, normalized: GLboolean, stride: GLsizei) {
        glVertexAttribPointer(index.toUInt(), size, type.toUInt(), normalized.toByte().toUByte(), stride, null)
    }

    actual fun vertexAttribPointer(index: GLuint, size: GLint, type: GLenum, normalized: GLboolean, stride: GLsizei, offset: GLsizei) {
        glVertexAttribPointer(index.toUInt(), size, type.toUInt(), normalized.toByte().toUByte(), stride, offset.toLong().toCPointer<ByteVar>())
    }

    actual fun viewport(x: GLint, y: GLint, width: GLsizei, height: GLsizei) {
        glViewport(x, y, width, height)
    }
}
