package io.github.inoutch.kotlin.gl.example.triangle

import io.github.inoutch.kotlin.gl.api.gl
import org.khronos.webgl.WebGLRenderingContext
import org.w3c.dom.HTMLCanvasElement
import kotlin.browser.document
import kotlin.browser.window

fun main() {
    window.onload = {
        val canvas = checkNotNull(document.getElementById("canvas") as? HTMLCanvasElement) { "Canvas not found" }
        val context = canvas.getContext("webgl") ?: canvas.getContext("experimental-webgl")

        check(context is WebGLRenderingContext)
        gl.setContext(context)

        val fps = 1.0f / 60.0f
        val triangle = Triangle(canvas.clientWidth, canvas.clientHeight, canvas.clientWidth, canvas.clientHeight)
        fun render() {
            triangle.render()
            window.setTimeout({ render() }, (fps * 1000.0f).toInt())
        }
        render()
        Unit
    }
}