plugins {
    id(BuildPlugins.androidApplication)
    kotlin(BuildPlugins.android)
    kotlin(BuildPlugins.androidExtensions)
    kotlin(BuildPlugins.kapt)
}

android {
    compileSdkVersion(Versions.sdkVersion)

    defaultConfig {
        applicationId = "com.mos.android_playground"
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libraries.kotlinStandardLibrary)
    implementation(Libraries.ktxCore)
    implementation(Libraries.appCompat)
    implementation(Libraries.constraintLayout)

    kapt(Libraries.daggerCompiler)
    implementation(Libraries.dagger)

    androidTestImplementation(Libraries.junitExtensions)
    androidTestImplementation(Libraries.espressoCore)

    testImplementation(Libraries.junit)
    testImplementation(Libraries.mockitoCore)
    testImplementation(Libraries.mockitoKotlin) {
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib")
    }
}