/* Copyright 2019 Tusky Contributors
 *
 * This file is a part of Pachli.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 3 of the
 * License, or (at your option) any later version.
 *
 * Pachli is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Tusky; if not,
 * see <http://www.gnu.org/licenses>. */

package app.pachli.service

import android.content.Context
import androidx.core.content.ContextCompat
import javax.inject.Inject

class ServiceClient @Inject constructor(private val context: Context) {
    fun sendToot(tootToSend: StatusToSend) {
        val intent = SendStatusService.sendStatusIntent(context, tootToSend)
        ContextCompat.startForegroundService(context, intent)
    }
}
