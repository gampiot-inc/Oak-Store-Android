package org.gampiot.oak.ui.fragments.home

import android.content.*

import androidx.navigation.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.activity.compose.*
import androidx.compose.ui.draw.*
import androidx.compose.runtime.*
import androidx.compose.ui.layout.*
import androidx.compose.material3.*
import androidx.navigation.compose.*
import androidx.compose.material.icons.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*

import org.gampiot.oak.R
import org.gampiot.oak.data.*
import org.gampiot.oak.data.models.*
import org.gampiot.oak.ui.theme.*
import org.gampiot.oak.ui.models.toolbar.*
import org.gampiot.oak.ui.fragments.home.lists.*
import org.gampiot.oak.ui.fragments.details.*

@Composable
fun HomeScreen(context: Context) {
    OakTheme {
        HomeContent(context)
    }
}

@Composable
private fun HomeContent(context: Context) {
    val context = context.applicationContext
    val (apps, setApps) = remember { mutableStateOf<List<AppModel>?>(null) }
    val (error, setError) = remember { mutableStateOf<String?>(null) }
    val dataRepo = AppsRepository(context)
    
    val callbackListener = object : AppsCallback {
         override fun onReceive(response: List<AppModel>) {
              setApps(response)
         }
         override fun onError(message: String) {
              setError(message)
         }
    }

    LaunchedEffect(Unit) {
        dataRepo.getData(context.getString(R.string.key_api_apps_url), "GET", callbackListener)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        topAppBarLarge(title = "Oak Store")

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            if (apps != null) {
                AppsList(apps)
            } else if (error != null) {
                Text (text = error, color = MaterialTheme.colorScheme.error
                )
            } else {
                CircularProgressIndicator()
            }
        }
    }
}