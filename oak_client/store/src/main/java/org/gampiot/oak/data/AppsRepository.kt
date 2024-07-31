package org.gampiot.oak.data

import android.app.Activity
import android.content.Context

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import org.gampiot.oak.R
import org.gampiot.oak.data.models.AppModel
import org.gampiot.oak.network.*

class AppsRepository(private val context: Context) : RequestListener {

    private var appsCallback: AppsCallback? = null

    suspend fun getData(url: String, method: String, appsCallback: AppsCallback) {
        this.appsCallback = appsCallback
        
        withContext(Dispatchers.IO) {
            val requestNetwork = RequestNetwork(context)
        
            val headers = HashMap<String, String>()
            headers["Content-Type"] = "application/json"
            requestNetwork.headersSet(headers)
            requestNetwork.startRequestNetwork(method, url, "getAllApps", this@AppsRepository)
        }
    }

    override fun onResponse(tag: String, response: String, responseHeader: HashMap<String, String>) {
        val gson = Gson()
        val type = object : TypeToken<List<AppModel>>() {}.type
        val apps: List<AppModel> = gson.fromJson(response, type)
        appsCallback?.onReceive(apps)
    }

    override fun onErrorResponse(tag: String, response: String) {
        appsCallback?.onError(response)
    }
}