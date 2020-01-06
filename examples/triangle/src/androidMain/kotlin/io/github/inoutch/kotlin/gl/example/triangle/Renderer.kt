package io.github.inoutch.kotlin.gl.example.triangle

import android.opengl.GLSurfaceView
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class Renderer(
    private val windowWidth: Int,
    private val windowHeight: Int,
    private val viewportWidth: Int,
    private val viewportHeight: Int
) : GLSurfaceView.Renderer {
    private lateinit var triangle: Triangle

    override fun onSurfaceCreated(p0: GL10?, p1: EGLConfig?) {
        triangle = Triangle(windowWidth, windowHeight, viewportWidth, viewportHeight)
    }

    override fun onSurfaceChanged(p0: GL10?, p1: Int, p2: Int) {}

    override fun onDrawFrame(p0: GL10?) {
        triangle.render()
    }
}
