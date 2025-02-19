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

package com.charlesmuchene.adb.interfaces

import com.charlesmuchene.adb.models.AdbDevice
import kotlinx.coroutines.experimental.Job

/**
 * Adb interface.
 *
 * Defines adb 'actions' that an [AdbDevice] can perform
 */
interface AdbProtocol {

    /**
     * Push a file to connect adb device
     *
     * @param localPath Path of the local file
     * @param remotePath Path of the remote file
     * @return A coroutine [Job]
     */
    fun push(localPath: String, remotePath: String): Job

    /**
     * Install an apk to the connected adb device
     *
     * @param apkPath Absolute path for the apk
     * @param launch `true` to launch the apk otherwise just install
     */
    fun install(apkPath: String, launch: Boolean = false)
}