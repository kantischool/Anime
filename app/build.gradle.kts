plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.daggerHiltAndroid)
    alias(libs.plugins.kotlinParcelize)
    alias(libs.plugins.devtoolsKsp)
}

android {
    namespace = "com.event.anime"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.event.anime"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)

    // ViewModel
    implementation(libs.lifecycle.viewmodel.ktx)
    // Viewmodel utilities for Compose
    implementation(libs.lifecycle.viewmodel.compose)

    // Retrofit
    implementation(libs.retrofit)

    // OkHttp
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    // Dagger Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Moshi
    implementation(libs.moshi.kotlin)
    implementation(libs.converter.moshi)

    // Coil
    implementation(libs.coil.compose)

    //Gson
    implementation(libs.google.gson)

    // Youtube Video Player
    implementation(libs.youtube.player)
    implementation(libs.youtube.player.core)
}