plugins {
    id(BuildPlugins.dynamicFeature)
    kotlin(BuildPlugins.android)
    kotlin(BuildPlugins.androidExtensions)
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

    testImplementation(Libraries.junit)

    androidTestImplementation(Libraries.junitExtensions)
    androidTestImplementation(Libraries.espressoCore)
    androidTestImplementation("androidx.annotation:annotation:1.1.0")
}