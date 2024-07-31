package org.gampiot.oak.data

import org.gampiot.oak.R

import org.gampiot.oak.data.models.*

interface AppsCallback {
    fun onReceive(response: List<AppModel>)
    fun onError(message: String)
}