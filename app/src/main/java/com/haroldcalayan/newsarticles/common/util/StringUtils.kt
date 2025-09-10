package com.haroldcalayan.newsarticles.common.util

import android.util.Base64

fun String.encodeForRoute(): String {
    return Base64.encodeToString(this.toByteArray(), Base64.URL_SAFE or Base64.NO_WRAP)
}

fun String.decodeForRoute(): String {
    return String(Base64.decode(this, Base64.URL_SAFE or Base64.NO_WRAP))
}