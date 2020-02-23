package io.github.inoutch.kotlin.gl.example.triangle

val vertShaderSource = """
#ifdef GL_ES
precision mediump float;
#endif
attribute vec2 texcoord;
attribute vec4 position;

varying vec2 vTexcoord;

void main() {
    vTexcoord = texcoord;
    gl_Position = position;
}

""".trimIndent()

val fragShaderSource = """
#ifdef GL_ES
precision mediump float;
#endif

varying vec2 vTexcoord;

uniform sampler2D uTexture0;

void main() {
    gl_FragColor = texture2D(uTexture0, vTexcoord);
}

""".trimIndent()

val triangleVertices = floatArrayOf(
        0.0f, 0.5f, 0.0f, 0.5f, 0.0f,
        -0.5f, -0.5f, 0.0f, 0.0f, 1.0f,
        0.5f, -0.5f, 0.0f, 1.0f, 1.0f
)
