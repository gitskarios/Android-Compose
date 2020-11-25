plugins {
    id("com.android.application")
    kotlin("android")
}

apply(from = "../build.properties")
val GH_HOST = extra["github_url"].toString()
val GH_TOKEN = extra["github_token"].toString()

android {
    compileSdkVersion(AndroidSdk.compile)

    defaultConfig {
        applicationId = "com.alorma.gitskarios"

        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)

        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "GH_HOST", "\"$GH_HOST\"")
        buildConfigField("String", "GH_TOKEN", "\"$GH_TOKEN\"")
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
        kotlinCompilerVersion = "1.4.0"
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = listOf("-Xallow-jvm-ir-dependencies", "-Xskip-prerelease-check",
            "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
        )
    }
}

dependencies {
    implementation(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.4.1"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.2.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}")

    implementation("org.koin:koin-android:${Versions.koin}")
    implementation("org.koin:koin-androidx-scope:${Versions.koin}")
    implementation("org.koin:koin-androidx-viewmodel:${Versions.koin}")
    implementation("org.koin:koin-androidx-fragment:${Versions.koin}")


    implementation("io.ktor:ktor-client-okhttp:${Versions.ktor}")
    implementation("io.ktor:ktor-client-gson:${Versions.ktor}")
    implementation("io.ktor:ktor-client-logging-jvm:${Versions.ktor}")

    implementation("androidx.compose.ui:ui:${Versions.compose}")
    implementation("androidx.ui:ui-tooling:${Versions.compose}")
    implementation("androidx.compose.foundation:foundation:${Versions.compose}")
    implementation("androidx.compose.material:material:${Versions.compose}")
    implementation("androidx.compose.material:material-icons-core:${Versions.compose}")
    implementation("androidx.compose.material:material-icons-extended:${Versions.compose}")

    implementation("com.squareup.okhttp3:okhttp:${Versions.okHttp}")
    implementation("com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.0-beta01")

    implementation("com.github.alorma.Compose-Debug-Drawer:drawer-base:${Versions.debugDrawer}")
    implementation("com.github.alorma.Compose-Debug-Drawer:drawer-modules:${Versions.debugDrawer}")

    testImplementation("junit:junit:${Versions.junit}")
}