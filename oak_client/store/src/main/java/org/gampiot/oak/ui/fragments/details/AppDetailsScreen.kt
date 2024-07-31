package org.gampiot.oak.ui.fragments.details

import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.draw.*
import androidx.compose.runtime.*
import androidx.compose.ui.layout.*
import androidx.compose.material3.*
import androidx.navigation.compose.*
import androidx.compose.material.icons.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*

import coil.compose.*

import org.gampiot.oak.R
import org.gampiot.oak.data.models.*
import org.gampiot.oak.ui.fragments.home.lists.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDetailsScreen(app: AppModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(app.app_name_app) },
            )
        }
    ) {
        AppDetailsContent(app)
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppDetailsContent (app: AppModel) {
     AppItem(app)
}