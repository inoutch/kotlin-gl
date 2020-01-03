package io.github.inoutch.kotlin.gl.api

import io.github.inoutch.kotlin.gl.error.UnsupportedGLError
import io.github.inoutch.kotlin.gl.extension.toFloatArray
import io.github.inoutch.kotlin.gl.extension.toIntArray
import io.github.inoutch.kotlin.gl.extension.toUint32Array
import io.github.inoutch.kotlin.gl.utility.WebGLMap
import org.khronos.webgl.Float32Array
import org.khronos.webgl.Int32Array
import org.khronos.webgl.WebGLBuffer
import org.khronos.webgl.WebGLFramebuffer
import org.khronos.webgl.WebGLProgram
import org.khronos.webgl.WebGLRenderbuffer
import org.khronos.webgl.WebGLRenderingContext
import org.khronos.webgl.WebGLShader
import org.khronos.webgl.WebGLTexture
import org.khronos.webgl.WebGLUniformLocation

actual object gl {
    private lateinit var glRenderingContext: WebGLRenderingContext

    private val bufferMap = WebGLMap<WebGLBuffer>()

    private val programMap = WebGLMap<WebGLProgram>()

    private val shaderMap = WebGLMap<WebGLShader>()

    private val framebufferMap = WebGLMap<WebGLFramebuffer>()

    private val renderbufferMap = WebGLMap<WebGLRenderbuffer>()

    private val textureMap = WebGLMap<WebGLTexture>()

    private val uniformMap = WebGLMap<WebGLUniformLocation>()

    actual fun activeTexture(texture: GLenum) {
        glRenderingContext.activeTexture(texture)
    }

    actual fun attachShader(program: GLuint, shader: GLuint) {
        glRenderingContext.attachShader(programMap[program], shaderMap[shader])
    }

    actual fun bindAttribLocation(program: GLuint, index: GLuint, name: String) {
        glRenderingContext.bindAttribLocation(programMap[program], index, name)
    }

    actual fun bindBuffer(target: GLenum, buffer: GLuint) {
        glRenderingContext.bindBuffer(target, bufferMap[buffer])
    }

    actual fun bindFramebuffer(target: GLenum, framebuffer: GLuint) {
        glRenderingContext.bindFramebuffer(target, framebufferMap[framebuffer])
    }

    actual fun bindRenderbuffer(target: GLenum, renderbuffer: GLuint) {
        glRenderingContext.bindRenderbuffer(target, renderbufferMap[renderbuffer])
    }

    actual fun bindTexture(target: GLenum, texture: GLuint) {
        glRenderingContext.bindTexture(target, textureMap[texture])
    }

    actual fun blendColor(red: GLfloat, green: GLfloat, blue: GLfloat, alpha: GLfloat) {
        glRenderingContext.blendColor(red, green, blue, alpha)
    }

    actual fun blendEquation(mode: GLenum) {
        glRenderingContext.blendEquation(mode)
    }

    actual fun blendEquationSeparate(modeRGB: GLenum, modeAlpha: GLenum) {
        glRenderingContext.blendEquationSeparate(modeRGB, modeAlpha)
    }

    actual fun blendFunc(sfactor: GLenum, dfactor: GLenum) {
        glRenderingContext.blendFunc(sfactor, dfactor)
    }

    actual fun blendFuncSeparate(sfactorRGB: GLenum, dfactorRGB: GLenum, sfactorAlpha: GLenum, dfactorAlpha: GLenum) {
        glRenderingContext.blendFuncSeparate(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha)
    }

    actual fun bufferData(target: GLenum, data: IntArray, usage: GLenum) {
        glRenderingContext.bufferData(target, Int32Array(data.toTypedArray()), usage)
    }

    actual fun bufferData(target: GLenum, data: FloatArray, usage: GLenum) {
        glRenderingContext.bufferData(target, Float32Array(data.toTypedArray()), usage)
    }

    actual fun bufferData(target: GLenum, data: ByteArray, usage: GLenum) {
        throw UnsupportedGLError()
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: IntArray) {
        glRenderingContext.bufferSubData(target, offset.toInt(), Int32Array(data.toTypedArray()))
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: FloatArray) {
        glRenderingContext.bufferSubData(target, offset.toInt(), Float32Array(data.toTypedArray()))
    }

    actual fun bufferSubData(target: GLenum, offset: GLintptr, data: ByteArray) {
        throw UnsupportedGLError()
    }

    actual fun checkFramebufferStatus(target: GLenum): GLenum {
        return glRenderingContext.checkFramebufferStatus(target)
    }

    actual fun clear(mask: GLbitfield) {
        glRenderingContext.clear(mask)
    }

    actual fun clearColor(red: GLfloat, green: GLfloat, blue: GLfloat, alpha: GLfloat) {
        glRenderingContext.clearColor(red, green, blue, alpha)
    }

    actual fun clearDepthf(d: GLfloat) {
        glRenderingContext.clearDepth(d)
    }

    actual fun clearStencil(s: GLint) {
        glRenderingContext.clearStencil(s)
    }

    actual fun colorMask(red: GLboolean, green: GLboolean, blue: GLboolean, alpha: GLboolean) {
        glRenderingContext.colorMask(red, green, blue, alpha)
    }

    actual fun compileShader(shader: GLuint) {
        glRenderingContext.compileShader(shaderMap[shader])
    }

    actual fun compressedTexImage2D(target: GLenum, level: GLint, internalformat: GLenum, width: GLsizei, height: GLsizei, border: GLint, data: ByteArray) {
        glRenderingContext.compressedTexImage2D(target, level, internalformat, width, height, border, data.toUint32Array())
    }

    actual fun compressedTexSubImage2D(target: GLenum, level: GLint, xoffset: GLint, yoffset: GLint, width: GLsizei, height: GLsizei, format: GLenum, data: ByteArray) {
        glRenderingContext.compressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, data.toUint32Array())
    }

    actual fun copyTexImage2D(target: GLenum, level: GLint, internalformat: GLenum, x: GLint, y: GLint, width: GLsizei, height: GLsizei, border: GLint) {
        glRenderingContext.copyTexImage2D(target, level, internalformat, x, y, width, height, border)
    }

    actual fun copyTexSubImage2D(target: GLenum, level: GLint, xoffset: GLint, yoffset: GLint, x: GLint, y: GLint, width: GLsizei, height: GLsizei) {
        glRenderingContext.copyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height)
    }

    actual fun createProgram(): GLuint {
        return programMap.create(checkNotNull(glRenderingContext.createProgram()))
    }

    actual fun createShader(type: GLenum): GLuint {
        return shaderMap.create(checkNotNull(glRenderingContext.createShader(type)))
    }

    actual fun cullFace(mode: GLenum) {
        glRenderingContext.cullFace(mode)
    }

    actual fun deleteBuffers(buffers: IntArray) {
        buffers.forEach { glRenderingContext.deleteBuffer(bufferMap.destroy(it)) }
    }

    actual fun deleteFramebuffers(framebuffers: IntArray) {
        framebuffers.forEach { glRenderingContext.deleteFramebuffer(framebufferMap.destroy(it)) }
    }

    actual fun deleteProgram(program: GLuint) {
        glRenderingContext.deleteProgram(programMap.destroy(program))
    }

    actual fun deleteRenderbuffers(renderbuffers: IntArray) {
        renderbuffers.forEach { glRenderingContext.deleteRenderbuffer(renderbufferMap.destroy(it)) }
    }

    actual fun deleteShader(shader: GLuint) {
        glRenderingContext.deleteShader(shaderMap.destroy(shader))
    }

    actual fun deleteTextures(textures: IntArray) {
        textures.forEach { glRenderingContext.deleteTexture(textureMap.destroy(it)) }
    }

    actual fun depthFunc(func: GLenum) {
        glRenderingContext.depthFunc(func)
    }

    actual fun depthMask(flag: GLboolean) {
        glRenderingContext.depthMask(flag)
    }

    actual fun depthRangef(n: GLfloat, f: GLfloat) {
        glRenderingContext.depthRange(n, f)
    }

    actual fun detachShader(program: GLuint, shader: GLuint) {
        glRenderingContext.detachShader(programMap[program], shaderMap[shader])
    }

    actual fun disable(cap: GLenum) {
        glRenderingContext.disable(cap)
    }

    actual fun disableVertexAttribArray(index: GLuint) {
        glRenderingContext.disableVertexAttribArray(index)
    }

    actual fun drawArrays(mode: GLenum, first: GLint, count: GLsizei) {
        glRenderingContext.drawArrays(mode, first, count)
    }

    actual fun drawElements(mode: GLenum, indices: IntArray) {
        // TODO:
        glRenderingContext.drawElements(mode, indices.size, GL_INT, 0)
    }

    actual fun enable(cap: GLenum) {
        glRenderingContext.enable(cap)
    }

    actual fun enableVertexAttribArray(index: GLuint) {
        glRenderingContext.enableVertexAttribArray(index)
    }

    actual fun finish() {
        glRenderingContext.finish()
    }

    actual fun flush() {
        glRenderingContext.flush()
    }

    actual fun framebufferRenderbuffer(target: GLenum, attachment: GLenum, renderbuffertarget: GLenum, renderbuffer: GLuint) {
        glRenderingContext.framebufferRenderbuffer(target, attachment, renderbuffertarget, renderbufferMap[renderbuffer])
    }

    actual fun framebufferTexture2D(target: GLenum, attachment: GLenum, textarget: GLenum, texture: GLuint, level: GLint) {
        glRenderingContext.framebufferTexture2D(target, attachment, textarget, textureMap[texture], level)
    }

    actual fun frontFace(mode: GLenum) {
        glRenderingContext.frontFace(mode)
    }

    actual fun genBuffers(n: GLsizei): IntArray {
        return IntArray(n) { bufferMap.create(checkNotNull(glRenderingContext.createBuffer())) }
    }

    actual fun generateMipmap(target: GLenum) {
        glRenderingContext.generateMipmap(target)
    }

    actual fun genFramebuffers(n: GLsizei): IntArray {
        return IntArray(n) { framebufferMap.create(checkNotNull(glRenderingContext.createFramebuffer())) }
    }

    actual fun genRenderbuffers(n: GLsizei): IntArray {
        return IntArray(n) { renderbufferMap.create(checkNotNull(glRenderingContext.createRenderbuffer())) }
    }

    actual fun genTextures(n: GLsizei): IntArray {
        return IntArray(n) { textureMap.create(checkNotNull(glRenderingContext.createTexture())) }
    }

    actual fun getActiveAttribSize(program: GLuint): GLint {
        return checkNotNull(glRenderingContext.getActiveAttrib(programMap[program], 0)).size
    }

    actual fun getActiveAttrib(program: GLuint, index: GLuint): Pair<String, GLint> {
        val result = checkNotNull(glRenderingContext.getActiveAttrib(programMap[program], index))
        return result.name to result.type
    }

    actual fun getActiveUniformSize(program: GLuint): GLint {
        return checkNotNull(glRenderingContext.getActiveUniform(programMap[program], 0)).size
    }

    actual fun getActiveUniform(program: GLuint, index: GLuint): Pair<String, GLint> {
        val result = checkNotNull(glRenderingContext.getActiveUniform(programMap[program], index))
        return result.name to result.type
    }

    actual fun getAttachedShaders(program: GLuint): IntArray {
        val result = checkNotNull(glRenderingContext.getAttachedShaders(programMap[program]))
        return result.map { shaderMap.search(it) }.toIntArray()
    }

    actual fun getAttribLocation(program: GLuint, name: String): GLint {
        return glRenderingContext.getAttribLocation(programMap[program], name)
    }

    actual fun getBooleanv(pname: GLenum): Boolean {
        throw UnsupportedGLError()
    }

    actual fun getBufferParameteriv(target: GLenum, pname: GLenum): GLint {
        val result = glRenderingContext.getBufferParameter(target, pname)
        if (result is Int) {
            return result
        } else if (result is Long) {
            return result.toInt()
        }
        throw IllegalStateException("Invalid buffer parameter")
    }

    actual fun getError(): GLenum {
        return glRenderingContext.getError()
    }

    actual fun getFloatv(pname: GLenum): Float {
        throw UnsupportedGLError()
    }

    actual fun getFramebufferAttachmentParameteriv(target: GLenum, attachment: GLenum, pname: GLenum): GLint {
        val result = glRenderingContext.getFramebufferAttachmentParameter(target, attachment, pname)
        if (result is Int) {
            return result
        } else if (result is Long) {
            return result.toInt()
        }
        throw IllegalStateException("Invalid framebuffer attachment parameter")
    }

    actual fun getIntegerv(pname: GLenum): GLint {
        throw UnsupportedGLError()
    }

    actual fun getProgramiv(program: GLuint, pname: GLenum): GLint {
        throw UnsupportedGLError()
    }

    actual fun getProgramInfoLog(program: GLuint): String {
        return checkNotNull(glRenderingContext.getProgramInfoLog(programMap[program]))
    }

    actual fun getRenderbufferParameteriv(target: GLenum, pname: GLenum): GLint {
        val result = glRenderingContext.getRenderbufferParameter(target, pname)
        if (result is Int) {
            return result
        } else if (result is Long) {
            return result.toInt()
        }
        throw IllegalStateException("Invalid renderbuffer attachment parameter")
    }

    actual fun getShaderiv(shader: GLuint, pname: GLenum): GLint {
        throw UnsupportedGLError()
    }

    actual fun getShaderInfoLog(shader: GLuint): String {
        return checkNotNull(glRenderingContext.getShaderInfoLog(shaderMap[shader]))
    }

    actual fun getShaderPrecisionFormat(shadertype: GLenum, precisiontype: GLenum): Pair<GLint, GLint> {
        val result = checkNotNull(glRenderingContext.getShaderPrecisionFormat(shadertype, precisiontype))
        return result.rangeMax to result.precision
    }

    actual fun getShaderSource(shader: GLuint): String {
        return checkNotNull(glRenderingContext.getShaderSource(shaderMap[shader]))
    }

    actual fun getString(name: GLenum): String? {
        throw UnsupportedGLError()
    }

    actual fun getTexParameterfv(target: GLenum, pname: GLenum): GLfloat {
        return checkNotNull(glRenderingContext.getTexParameter(target, pname) as? Float)
    }

    actual fun getTexParameteriv(target: GLenum, pname: GLenum): GLint {
        val result = glRenderingContext.getTexParameter(target, pname)
        if (result is Int) {
            return result
        } else if (result is Long) {
            return result.toInt()
        }
        throw IllegalStateException("Invalid renderbuffer attachment parameter")
    }

    actual fun getUniformfv(program: GLuint, location: GLint): GLfloat {
        return checkNotNull(glRenderingContext.getUniform(programMap[program], uniformMap[location]) as? GLfloat)
    }

    actual fun getUniformiv(program: GLuint, location: GLint): GLint {
        return checkNotNull(glRenderingContext.getUniform(programMap[program], uniformMap[location]) as? GLint)
    }

    actual fun getUniformLocation(program: GLuint, name: String): GLint {
        return uniformMap.search(checkNotNull(glRenderingContext.getUniformLocation(programMap[program], name)))
    }

    actual fun getVertexAttribfv(index: GLuint, pname: GLenum): GLfloat {
        return checkNotNull(glRenderingContext.getVertexAttrib(index, pname) as? GLfloat)
    }

    actual fun getVertexAttribiv(index: GLuint, pname: GLenum): GLint {
        return checkNotNull(glRenderingContext.getVertexAttrib(index, pname) as? GLint)
    }

    actual fun hint(target: GLenum, mode: GLenum) {
        glRenderingContext.hint(target, mode)
    }

    actual fun isBuffer(buffer: GLuint): GLboolean {
        return glRenderingContext.isBuffer(bufferMap[buffer])
    }

    actual fun isEnabled(cap: GLenum): GLboolean {
        return glRenderingContext.isEnabled(cap)
    }

    actual fun isFramebuffer(framebuffer: GLuint): GLboolean {
        return glRenderingContext.isFramebuffer(framebufferMap[framebuffer])
    }

    actual fun isProgram(program: GLuint): GLboolean {
        return glRenderingContext.isProgram(programMap[program])
    }

    actual fun isRenderbuffer(renderbuffer: GLuint): GLboolean {
        return glRenderingContext.isRenderbuffer(renderbufferMap[renderbuffer])
    }

    actual fun isShader(shader: GLuint): GLboolean {
        return glRenderingContext.isShader(shaderMap[shader])
    }

    actual fun isTexture(texture: GLuint): GLboolean {
        return glRenderingContext.isTexture(textureMap[texture])
    }

    actual fun lineWidth(width: GLfloat) {
        glRenderingContext.lineWidth(width)
    }

    actual fun linkProgram(program: GLuint) {
        glRenderingContext.linkProgram(programMap[program])
    }

    actual fun pixelStorei(pname: GLenum, param: GLint) {
        glRenderingContext.pixelStorei(pname, param)
    }

    actual fun polygonOffset(factor: GLfloat, units: GLfloat) {
        glRenderingContext.polygonOffset(factor, units)
    }

    actual fun readPixelsi(x: GLint, y: GLint, width: GLsizei, height: GLsizei, format: GLenum, type: GLenum): IntArray {
        val intBuffer = Int32Array(width * height)
        glRenderingContext.readPixels(x, y, width, height, format, type, intBuffer)
        return intBuffer.toIntArray()
    }

    actual fun readPixelsf(x: GLint, y: GLint, width: GLsizei, height: GLsizei, format: GLenum, type: GLenum): FloatArray {
        val floatArray = Float32Array(width * height)
        glRenderingContext.readPixels(x, y, width, height, format, type, floatArray)
        return floatArray.toFloatArray()
    }

    actual fun releaseShaderCompiler() {
        throw UnsupportedGLError()
    }

    actual fun renderbufferStorage(target: GLenum, internalformat: GLenum, width: GLsizei, height: GLsizei) {
        glRenderingContext.renderbufferStorage(target, internalformat, width, height)
    }

    actual fun sampleCoverage(value: GLfloat, invert: GLboolean) {
        glRenderingContext.sampleCoverage(value, invert)
    }

    actual fun scissor(x: GLint, y: GLint, width: GLsizei, height: GLsizei) {
        glRenderingContext.scissor(x, y, width, height)
    }

    actual fun shaderBinary(shaders: IntArray, binaryformat: GLenum, binary: ByteArray) {
        throw UnsupportedGLError()
    }

    actual fun shaderSource(shader: GLuint, string: String) {
        glRenderingContext.shaderSource(shaderMap[shader], string)
    }

    actual fun stencilFunc(func: GLenum, ref: GLint, mask: GLuint) {
        glRenderingContext.stencilFunc(func, ref, mask)
    }

    actual fun stencilFuncSeparate(face: GLenum, func: GLenum, ref: GLint, mask: GLuint) {
        glRenderingContext.stencilFunc(func, ref, mask)
    }

    actual fun stencilMask(mask: GLuint) {
        glRenderingContext.stencilMask(mask)
    }

    actual fun stencilMaskSeparate(face: GLenum, mask: GLuint) {
        glRenderingContext.stencilMaskSeparate(face, mask)
    }

    actual fun stencilOp(fail: GLenum, zfail: GLenum, zpass: GLenum) {
        glRenderingContext.stencilOp(fail, zfail, zpass)
    }

    actual fun stencilOpSeparate(face: GLenum, sfail: GLenum, dpfail: GLenum, dppass: GLenum) {
        glRenderingContext.stencilOpSeparate(face, sfail, dpfail, dppass)
    }

    actual fun texImage2D(target: GLenum, level: GLint, internalformat: GLint, width: GLsizei, height: GLsizei, border: GLint, format: GLenum, type: GLenum, pixels: ByteArray) {
        glRenderingContext.texImage2D(target, level, internalformat, width, height, border, format, type, pixels.toUint32Array())
    }

    actual fun texParameterf(target: GLenum, pname: GLenum, param: GLfloat) {
        glRenderingContext.texParameterf(target, pname, param)
    }

    actual fun texParameterfv(target: GLenum, pname: GLenum, params: FloatArray) {
        throw UnsupportedGLError()
    }

    actual fun texParameteri(target: GLenum, pname: GLenum, param: GLint) {
        glRenderingContext.texParameteri(target, pname, param)
    }

    actual fun texParameteriv(target: GLenum, pname: GLenum, params: IntArray) {
        throw UnsupportedGLError()
    }

    actual fun texSubImage2D(target: GLenum, level: GLint, xoffset: GLint, yoffset: GLint, width: GLsizei, height: GLsizei, format: GLenum, type: GLenum, pixels: ByteArray) {
        glRenderingContext.texSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels.toUint32Array())
    }

    actual fun uniform1f(location: GLint, v0: GLfloat) {
        glRenderingContext.uniform1f(uniformMap[location], v0)
    }

    actual fun uniform1fv(location: GLint, value: FloatArray) {
        glRenderingContext.uniform1fv(uniformMap[location], value.toTypedArray())
    }

    actual fun uniform1i(location: GLint, v0: GLint) {
        glRenderingContext.uniform1i(uniformMap[location], v0)
    }

    actual fun uniform1iv(location: GLint, value: IntArray) {
        glRenderingContext.uniform1iv(uniformMap[location], value.toTypedArray())
    }

    actual fun uniform2f(location: GLint, v0: GLfloat, v1: GLfloat) {
        glRenderingContext.uniform2f(uniformMap[location], v0, v1)
    }

    actual fun uniform2fv(location: GLint, value: FloatArray) {
        glRenderingContext.uniform2fv(uniformMap[location], value.toTypedArray())
    }

    actual fun uniform2i(location: GLint, v0: GLint, v1: GLint) {
        glRenderingContext.uniform2i(uniformMap[location], v0, v1)
    }

    actual fun uniform2iv(location: GLint, value: IntArray) {
        glRenderingContext.uniform2iv(uniformMap[location], value.toTypedArray())
    }

    actual fun uniform3f(location: GLint, v0: GLfloat, v1: GLfloat, v2: GLfloat) {
        glRenderingContext.uniform3f(uniformMap[location], v0, v1, v2)
    }

    actual fun uniform3fv(location: GLint, value: FloatArray) {
        glRenderingContext.uniform3fv(uniformMap[location], value.toTypedArray())
    }

    actual fun uniform3i(location: GLint, v0: GLint, v1: GLint, v2: GLint) {
        glRenderingContext.uniform3i(uniformMap[location], v0, v1, v2)
    }

    actual fun uniform3iv(location: GLint, value: IntArray) {
        glRenderingContext.uniform3iv(uniformMap[location], value.toTypedArray())
    }

    actual fun uniform4f(location: GLint, v0: GLfloat, v1: GLfloat, v2: GLfloat, v3: GLfloat) {
        glRenderingContext.uniform4f(uniformMap[location], v0, v1, v2, v3)
    }

    actual fun uniform4fv(location: GLint, value: FloatArray) {
        glRenderingContext.uniform4fv(uniformMap[location], value.toTypedArray())
    }

    actual fun uniform4i(location: GLint, v0: GLint, v1: GLint, v2: GLint, v3: GLint) {
        glRenderingContext.uniform4i(uniformMap[location], v0, v1, v2, v3)
    }

    actual fun uniform4iv(location: GLint, value: IntArray) {
        glRenderingContext.uniform4iv(uniformMap[location], value.toTypedArray())
    }

    actual fun uniformMatrix2fv(location: GLint, transpose: GLboolean, value: FloatArray) {
        glRenderingContext.uniformMatrix2fv(uniformMap[location], transpose, value.toTypedArray())
    }

    actual fun uniformMatrix3fv(location: GLint, transpose: GLboolean, value: FloatArray) {
        glRenderingContext.uniformMatrix3fv(uniformMap[location], transpose, value.toTypedArray())
    }

    actual fun uniformMatrix4fv(location: GLint, transpose: GLboolean, value: FloatArray) {
        glRenderingContext.uniformMatrix4fv(uniformMap[location], transpose, value.toTypedArray())
    }

    actual fun useProgram(program: GLuint) {
        glRenderingContext.useProgram(programMap[program])
    }

    actual fun validateProgram(program: GLuint) {
        glRenderingContext.validateProgram(programMap[program])
    }

    actual fun vertexAttrib1f(index: GLuint, x: GLfloat) {
        glRenderingContext.vertexAttrib1f(index, x)
    }

    actual fun vertexAttrib1fv(index: GLuint, v: FloatArray) {
        glRenderingContext.vertexAttrib1fv(index, v)
    }

    actual fun vertexAttrib2f(index: GLuint, x: GLfloat, y: GLfloat) {
        glRenderingContext.vertexAttrib2f(index, x, y)
    }

    actual fun vertexAttrib2fv(index: GLuint, v: FloatArray) {
        glRenderingContext.vertexAttrib2fv(index, v)
    }

    actual fun vertexAttrib3f(index: GLuint, x: GLfloat, y: GLfloat, z: GLfloat) {
        glRenderingContext.vertexAttrib3f(index, x, y, z)
    }

    actual fun vertexAttrib3fv(index: GLuint, v: FloatArray) {
        glRenderingContext.vertexAttrib3fv(index, v)
    }

    actual fun vertexAttrib4f(index: GLuint, x: GLfloat, y: GLfloat, z: GLfloat, w: GLfloat) {
        glRenderingContext.vertexAttrib4f(index, x, y, z, w)
    }

    actual fun vertexAttrib4fv(index: GLuint, v: FloatArray) {
        glRenderingContext.vertexAttrib4fv(index, v)
    }

    actual fun vertexAttribPointer(index: GLuint, size: GLint, type: GLenum, normalized: GLboolean, stride: GLsizei) {
        glRenderingContext.vertexAttribPointer(index, size, type, normalized, stride, 0)
    }

    actual fun vertexAttribPointer(index: GLuint, size: GLint, type: GLenum, normalized: GLboolean, stride: GLsizei, pointer: IntArray) {
        throw UnsupportedGLError()
    }

    actual fun vertexAttribPointer(index: GLuint, size: GLint, type: GLenum, normalized: GLboolean, stride: GLsizei, pointer: FloatArray) {
        throw UnsupportedGLError()
    }

    actual fun vertexAttribPointer(index: GLuint, size: GLint, type: GLenum, normalized: GLboolean, stride: GLsizei, pointer: ByteArray) {
        throw UnsupportedGLError()
    }

    actual fun viewport(x: GLint, y: GLint, width: GLsizei, height: GLsizei) {
        glRenderingContext.viewport(x, y, width, height)
    }
}
