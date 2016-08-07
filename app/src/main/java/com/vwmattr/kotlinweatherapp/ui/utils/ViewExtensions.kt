package com.vwmattr.kotlinweatherapp.ui.utils

import android.content.Context
import android.view.View

/**
 * Global extensions on [View]
 */

val View.ctx: Context
    get() = context
