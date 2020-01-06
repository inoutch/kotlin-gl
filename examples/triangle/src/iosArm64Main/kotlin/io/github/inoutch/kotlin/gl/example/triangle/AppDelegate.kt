package io.github.inoutch.kotlin.gl.example.triangle

import platform.UIKit.UIApplicationDelegateProtocol
import platform.UIKit.UIApplicationDelegateProtocolMeta
import platform.UIKit.UIResponder
import platform.UIKit.UIResponderMeta
import platform.UIKit.UIWindow

class AppDelegate : UIResponder, UIApplicationDelegateProtocol {

    @OverrideInit
    @Suppress("ConvertSecondaryConstructorToPrimary")
    constructor() : super()

    companion object : UIResponderMeta(), UIApplicationDelegateProtocolMeta {}

    private var _window: UIWindow? = null

    override fun window() = _window

    override fun setWindow(window: UIWindow?) { _window = window }
}
