package io.github.inoutch.kotlin.gl.example.triangle

import android.app.Activity
import android.os.Bundle

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val surfaceView = SurfaceView(applicationContext)
        setContentView(surfaceView)
    }
}
