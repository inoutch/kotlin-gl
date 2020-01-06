package io.github.inoutch.kotlin.gl.example.triangle

import kotlinx.cinterop.autoreleasepool
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toCStringArray
import platform.Foundation.NSStringFromClass
import platform.UIKit.UIApplicationMain

fun main(args: Array<String>) {
    memScoped {
        autoreleasepool {
            UIApplicationMain(args.size, args.toCStringArray(this), null, NSStringFromClass(AppDelegate))
        }
    }
}
