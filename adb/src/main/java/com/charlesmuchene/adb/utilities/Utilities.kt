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
@file:JvmName("Utilities")

package com.charlesmuchene.adb.utilities

import timber.log.Timber
import java.io.File
import java.io.FileInputStream

/**
 * Log a debug message
 *
 * @param message Message to log
 */
fun logd(message: String) = Timber.d(message)

/**
 * Log an error message
 *
 * @param message Message to log
 */
fun loge(message: String) = Timber.e(message)

/**
 * Log a warning with the given message
 *
 * @param message Message to log
 */
fun logw(message: String) = Timber.w(message)

/**
 * Open a input stream to a local file
 *
 * @param file [File] to send
 * @return [Triple] for last modified time, length and stream of the given file
 */
fun openStream(file: File): Triple<Int, Int, FileInputStream>? {
    return try {
        Triple((file.lastModified() / 1000).toInt(), file.length().toInt(), FileInputStream(file))
    } catch (e: Exception) {
        loge(e.localizedMessage)
        null
    }
}