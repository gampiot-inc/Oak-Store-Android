plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "org.gampiot.oak"
    compileSdk = 34

    defaultConfig {
        applicationId = "org.gampiot.oak"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    
    kotlinOptions {
        jvmTarget = "17"
    }

    packagingOptions {
        resources {
            excludes += "../test/database/database.json"
        }
    }

    signingConfigs {
        getByName("debug") {
            storeFile = file(layout.buildDirectory.dir("../testkey.keystore"))
            storePassword = "testkey"
            keyAlias = "testkey"
            keyPassword = "testkey"
        }
    }
}

dependencies {

    val kotlin_version = "2.0.10"
    val coroutines = "1.9.0-RC"
    
    // androidx
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.fragment:fragment-ktx:1.8.2")
    
    
    // google
    implementation("com.google.android.material:material:1.12.0")
    implementation("com.google.code.gson:gson:2.11.0")
    
    // jetbrains
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")
    
    // squareup
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    
    // compose
    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
    implementation("androidx.compose.material3:material3")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.activity:activity-compose:1.9.1")
    implementation("androidx.activity:activity:1.9.1")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    
    implementation("io.coil-kt:coil-compose:2.7.0")
    implementation("io.github.fornewid:material-motion-compose-core:2.0.1")
}