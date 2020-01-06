package io.github.inoutch.kotlin.gl.example.triangle

import android.content.Context
import android.opengl.GLSurfaceView
import android.util.DisplayMetrics
import android.view.WindowManager

class SurfaceView(context: Context) : GLSurfaceView(context) {
    init {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dispMet = DisplayMetrics()
        val display = windowManager.defaultDisplay
        display.getRealMetrics(dispMet)

        setEGLContextClientVersion(2)
        setRenderer(Renderer(dispMet.widthPixels, dispMet.heightPixels, dispMet.widthPixels, dispMet.heightPixels))
    }
}
