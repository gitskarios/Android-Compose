plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

apply(from = "../build.properties")
val GH_TOKEN = extra["github_token"].toString()

android {
    setCompileSdkVersion(30)

    defaultConfig {
        applicationId = "com.alorma.gitskarios"

        setCompileSdkVersion(30)
        setTargetSdkVersion(30)
        setMinSdkVersion(23)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "GH_TOKEN", "\"$GH_TOKEN\"")

        javaCompileOptions {
            annotationProcessorOptions {
                argument("room.schemaLocation", "$projectDir/schemas")
                argument("room.incremental", "true")
            }
        }
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.0-alpha07"
        kotlinCompilerVersion = "1.4.10"
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7")
    implementation(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.4.1"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android")

    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.compose.ui:ui:1.0.0-alpha07")
    implementation("androidx.compose.material:material:1.0.0-alpha07")
    implementation("androidx.ui:ui-tooling:1.0.0-alpha07")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.0-beta01")

    implementation("com.github.alorma.Compose-Debug-Drawer:drawer-base:0.1.0-beta-04")
    implementation("com.github.alorma.Compose-Debug-Drawer:drawer-modules:0.1.0-beta-04")
    implementation("com.github.alorma.Compose-Debug-Drawer:developer-shortcuts:0.1.0-beta-04")

    testImplementation("junit:junit:4.13.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}