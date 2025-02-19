/* Copyright (C) 2018 Charles Muchene
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.charlesmuchene.adb.ui

import android.content.IntentFilter
import android.hardware.usb.UsbManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.charlesmuchene.adb.Adb
import com.charlesmuchene.adb.R
import com.charlesmuchene.adb.receivers.UsbConnectionReceiver

/**
 * Home screen
 */
class HomeActivity : AppCompatActivity() {

    private val usbConnectionReceiver = UsbConnectionReceiver()
    private val usbConnectionIntentFilter = IntentFilter().apply {
        addAction(UsbManager.ACTION_USB_DEVICE_DETACHED)
        addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Adb.addExistingDevices()

        registerReceiver(usbConnectionReceiver, usbConnectionIntentFilter)

    }

    override fun onDestroy() {
        super.onDestroy()
        Adb.disconnect()
        unregisterReceiver(usbConnectionReceiver)
    }
}
