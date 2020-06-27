object Versions {
    const val support = "28.0.0"
    const val kotlin = "1.3.72"
    const val sdkVersion = 29
    const val minSdkVersion = 21
    const val targetSdkVersion = 29
    const val versionCode = 1
    const val versionName = "1.0"
    const val buildGradle = "4.0.0"

    const val ktx = "1.3.0"
    const val jetPack = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val dagger = "2.20"

    const val junitExtensions = "1.1.1"
    const val espresso = "3.2.0"
    const val junit = "4.12"
    const val mockitoCore = "2.23.4"
    const val mockitoKotlin = "2.1.0"
}

object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val android = "android"
    const val androidExtensions = "android.extensions"
    const val kapt = "kapt"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val androidBuildGradle = "com.android.tools.build:gradle:${Versions.buildGradle}"

    const val dynamicFeature = "com.android.dynamic-feature"
}

object Libraries {
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetPack}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val junitExtensions = "androidx.test.ext:junit:${Versions.junitExtensions}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val junit = "junit:junit:${Versions.junit}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"

}

object Modules {
    const val app = ":app"
    const val home =":features:home"
}