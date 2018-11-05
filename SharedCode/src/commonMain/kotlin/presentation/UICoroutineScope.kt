package org.kotlin.mpp.mobile.presentation

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import org.kotlin.mpp.mobile.uiDispatcher
import kotlin.coroutines.CoroutineContext

class UICoroutineScope: CoroutineScope {

    private val job = Job()
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        println(throwable.cause)
        println(throwable.message)
    }

    override val coroutineContext: CoroutineContext
        get() = uiDispatcher() + job + exceptionHandler

}