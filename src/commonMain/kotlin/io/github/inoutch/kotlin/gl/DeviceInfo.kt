package io.github.inoutch.kotlin.gl

expect class DeviceInfo {
    companion object {
        fun isSupported(): Boolean
    }
}
