package org.kotlin.mpp.mobile

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual fun uiDispatcher() = Dispatchers.Main as CoroutineDispatcher
