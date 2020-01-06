import io.github.inoutch.kotlin.gl.example.triangle.Triangle
import kotlinx.cinterop.CValue
import kotlinx.cinterop.ExportObjCClass
import kotlinx.cinterop.ObjCAction
import kotlinx.cinterop.useContents
import platform.CoreGraphics.CGRect
import platform.EAGL.EAGLContext
import platform.EAGL.kEAGLRenderingAPIOpenGLES2
import platform.Foundation.NSCoder
import platform.Foundation.NSDefaultRunLoopMode
import platform.Foundation.NSRunLoop
import platform.Foundation.NSSelectorFromString
import platform.GLKit.GLKView
import platform.GLKit.GLKViewController
import platform.QuartzCore.CADisplayLink
import platform.UIKit.UIScreen
import platform.UIKit.contentScaleFactor

@ExperimentalUnsignedTypes
@ExportObjCClass
class ViewController : GLKViewController {

    private lateinit var context: EAGLContext

    private lateinit var displayLink: CADisplayLink

    private lateinit var triangle: Triangle

    @OverrideInit
    @Suppress("ConvertSecondaryConstructorToPrimary")
    constructor(coder: NSCoder) : super(coder)

    override fun viewDidLoad() {
        super.viewDidLoad()
        view.contentScaleFactor = UIScreen.mainScreen.nativeScale

        displayLink = CADisplayLink.displayLinkWithTarget(this, NSSelectorFromString("render:"))
        displayLink.preferredFramesPerSecond = 60
        displayLink.addToRunLoop(NSRunLoop.currentRunLoop, NSDefaultRunLoopMode)

        val windowSize = UIScreen.mainScreen.bounds.useContents {
            size.width.toInt() to size.height.toInt()
        }
        val viewportSize = UIScreen.mainScreen.nativeBounds.useContents {
            size.width.toInt() to size.height.toInt()
        }

        context = EAGLContext(kEAGLRenderingAPIOpenGLES2)
        EAGLContext.setCurrentContext(this.context)

        val glkView = view as GLKView
        glkView.context = context

        triangle = Triangle(windowSize.first, windowSize.second, viewportSize.first, viewportSize.second)
    }

    override fun glkView(view: GLKView, drawInRect: CValue<CGRect>) {
        super.glkView(view, drawInRect)
        triangle.render()
    }

    @Suppress("UNUSED_PARAMETER")
    @ObjCAction
    fun render(sender: CADisplayLink) {
        triangle.render()
    }
}
