plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    id("kotlin-parcelize")
    id("com.google.devtools.ksp")

    // Add the Google services Gradle plugin
    id("com.google.gms.google-services")

    // Dagger Hilt
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.omarkarimli.intelliflow"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.omarkarimli.intelliflow"
        minSdk = 24
        targetSdk = 35
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

    // Fragment
    implementation(libs.androidx.fragment.ktx)

    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    ksp(libs.androidx.lifecycle.compiler)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Import the Firebase BoM
    implementation(platform(libs.firebase.bom))

    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation(libs.firebase.analytics)

    // Add the dependencies for any other desired Firebase products
    // https://firebase.google.com/docs/android/setup#available-libraries

    // Auth
    implementation(libs.firebase.auth.ktx)

    // Firestore
    implementation(libs.firebase.firestore.ktx)

    // Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    // Okhttp
    implementation(libs.okhttp)

    // Picasso
    implementation (libs.picasso)

    // DotsIndicator
    implementation(libs.dotsindicator)

    // Import the Firebase BoM
    implementation(platform(libs.firebase.bom))

    // Dagger Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    // Room
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.androidx.room.compiler)

    // For web scraping
    implementation(libs.jsoup)

    // Coil Image Loader
    implementation(libs.coil.compose)
}