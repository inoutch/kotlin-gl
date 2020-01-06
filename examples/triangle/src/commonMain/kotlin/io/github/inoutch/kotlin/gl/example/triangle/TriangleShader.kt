package io.github.inoutch.kotlin.gl.example.triangle

val vertShaderSource = """
#ifdef GL_ES
precision mediump float;
#endif
attribute vec4 vPosition;

void main() {
    gl_Position = vPosition;
}

""".trimIndent()

val fragShaderSource = """
#ifdef GL_ES
precision mediump float;
#endif

void main() {
    gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);
}

""".trimIndent()

val triangleVertices = floatArrayOf(
        0.0f, 0.5f, 0.0f,
        -0.5f, -0.5f, 0.0f,
        0.5f, -0.5f, 0.0f
)
