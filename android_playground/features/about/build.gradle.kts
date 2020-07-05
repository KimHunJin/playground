plugins {
    id(BuildPlugins.dynamicFeature)
    kotlin(BuildPlugins.android)
    kotlin(BuildPlugins.androidExtensions)
    id("kotlin-android")
}
android {
    compileSdkVersion(Versions.sdkVersion)

    defaultConfig {
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(Modules.app))

    implementation(Libraries.kotlinStandardLibrary)
    implementation(Libraries.ktxCore)
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")

    testImplementation(Libraries.junit)

    androidTestImplementation(Libraries.junitExtensions)
    androidTestImplementation(Libraries.espressoCore)
    androidTestImplementation("androidx.annotation:annotation:1.1.0")
}
