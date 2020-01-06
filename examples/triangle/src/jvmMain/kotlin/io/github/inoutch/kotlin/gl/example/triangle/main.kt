package io.github.inoutch.kotlin.gl.example.triangle

import org.lwjgl.BufferUtils
import org.lwjgl.glfw.Callbacks.glfwFreeCallbacks
import org.lwjgl.glfw.GLFW.GLFW_FALSE
import org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE
import org.lwjgl.glfw.GLFW.GLFW_RELEASE
import org.lwjgl.glfw.GLFW.GLFW_RESIZABLE
import org.lwjgl.glfw.GLFW.GLFW_TRUE
import org.lwjgl.glfw.GLFW.GLFW_VISIBLE
import org.lwjgl.glfw.GLFW.glfwCreateWindow
import org.lwjgl.glfw.GLFW.glfwDefaultWindowHints
import org.lwjgl.glfw.GLFW.glfwGetFramebufferSize
import org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor
import org.lwjgl.glfw.GLFW.glfwGetVideoMode
import org.lwjgl.glfw.GLFW.glfwGetWindowSize
import org.lwjgl.glfw.GLFW.glfwInit
import org.lwjgl.glfw.GLFW.glfwMakeContextCurrent
import org.lwjgl.glfw.GLFW.glfwPollEvents
import org.lwjgl.glfw.GLFW.glfwSetKeyCallback
import org.lwjgl.glfw.GLFW.glfwSetWindowPos
import org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose
import org.lwjgl.glfw.GLFW.glfwShowWindow
import org.lwjgl.glfw.GLFW.glfwSwapBuffers
import org.lwjgl.glfw.GLFW.glfwSwapInterval
import org.lwjgl.glfw.GLFW.glfwTerminate
import org.lwjgl.glfw.GLFW.glfwWindowHint
import org.lwjgl.glfw.GLFW.glfwWindowShouldClose
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.opengl.GL
import org.lwjgl.system.MemoryStack.stackPush
import org.lwjgl.system.MemoryUtil.NULL

fun main() {
    GLFWErrorCallback.createPrint().set()
    check(glfwInit()) { "Unable to initialize glfw" }

    glfwDefaultWindowHints()
    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
    glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE)

    val windowWidth = 300
    val windowHeight = 300

    val window = glfwCreateWindow(windowWidth, windowHeight, "Kotlin Triangle", NULL, NULL)
    check(window != NULL) { "Failed to create the GLFW window" }

    val viewportWidth = BufferUtils.createIntBuffer(1)
    val viewportHeight = BufferUtils.createIntBuffer(1)
    glfwGetFramebufferSize(window, viewportWidth, viewportHeight)

    glfwSetKeyCallback(window) { windowHnd: Long, key: Int, _, action: Int, _ ->
        if (action == GLFW_RELEASE && key == GLFW_KEY_ESCAPE) {
            glfwSetWindowShouldClose(windowHnd, true)
        }
    }

    stackPush().use {
        val pWidth = it.mallocInt(1)
        val pHeight = it.mallocInt(1)

        glfwGetWindowSize(window, pWidth, pHeight)

        val vidmode = checkNotNull(glfwGetVideoMode(glfwGetPrimaryMonitor()))
        glfwSetWindowPos(
                window,
                (vidmode.width() - pWidth.get(0)) / 2,
                (vidmode.height() - pHeight.get(0)) / 2
        )
    }
    glfwMakeContextCurrent(window)
    glfwSwapInterval(1)

    glfwShowWindow(window)
    GL.createCapabilities()

    try {
        val triangle = Triangle(windowWidth, windowHeight, viewportWidth[0], viewportHeight[0])
        while (!glfwWindowShouldClose(window)) {
            glfwPollEvents()

            triangle.render()
            glfwSwapBuffers(window)
        }

        triangle.destroy()
    } catch (e: Error) {
        e.printStackTrace()
    }
    glfwFreeCallbacks(window)
    glfwTerminate()
}
