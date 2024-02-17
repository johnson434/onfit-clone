plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.hig.ui"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
//        compose = true
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
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
    }

    kotlinOptions {
        jvmTarget = "18"
    }
}

dependencies {
//    implementation("androidx.compose.ui:ui:1.6.1")
//    implementation("androidx.compose.runtime:runtime:1.6.1")
//    implementation("androidx.compose.foundation:foundation:1.6.1")
//    implementation("androidx.compose.animation:animation:1.6.1")
//    implementation("androidx.compose.material:material:1.6.1")
//    implementation("androidx.compose.material3:material3:1.2.0")
}