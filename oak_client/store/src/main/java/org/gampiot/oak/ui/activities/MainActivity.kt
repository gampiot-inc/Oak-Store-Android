package org.gampiot.oak.ui.activities

import android.os.Bundle

import androidx.activity.*
import androidx.navigation.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.draw.*
import androidx.activity.compose.*
import androidx.compose.runtime.*
import androidx.compose.ui.layout.*
import androidx.compose.material3.*
import androidx.navigation.compose.*
import androidx.compose.foundation.*
import androidx.compose.ui.graphics.*
import androidx.compose.material.icons.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*

import org.gampiot.oak.ui.theme.*
import org.gampiot.oak.ui.models.*
import org.gampiot.oak.data.models.*
import org.gampiot.oak.ui.fragments.home.*
import org.gampiot.oak.ui.fragments.details.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OakTheme {
                Scaffold(
                    modifier = 
                      Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Content()
                }
            }
        }
    }

    @Composable
    fun Content() {
         val navController = rememberNavController()
         val context = LocalContext.current
         NavHost(
             navController = navController,
             startDestination = "home"
         ) {
            composable("home") {
                 HomeScreen(context)
            }
            composable("appdetails/{appModel}",
                arguments = listOf(navArgument("appModel") { type = NavType.ParcelableType(AppModel::class.java) })
            ) { entry ->
              entry.arguments?.getParcelable<AppModel>("appModel")?.let { appModel ->
                        AppDetailsScreen(appModel)
              }
            }
         }
    }
}