plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.company.myapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.androidcompany.myapp"
        minSdk = 29
        targetSdk = 34
        versionCode = 6
        versionName = "3.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildFeatures {
            buildConfig = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }


    flavorDimensions +=  "version"
    productFlavors {
        create("production") {
            dimension = "version"
            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher"
            manifestPlaceholders["appIconRound"] = "@mipmap/ic_launcher_round"
            manifestPlaceholders["appIconForeground"] = "@mipmap/ic_launcher_foreground"
        }

        create("preproduction") {
            dimension = "version"
            applicationIdSuffix = ".pp"
            versionNameSuffix = "-pp"
            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher_pp"
            manifestPlaceholders["appIconRound"] = "@mipmap/ic_launcher_pp_round"

        }

        create("validation") {
            dimension = "version"
            applicationIdSuffix = ".vl"
            versionNameSuffix = "-vl"
            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher_vl"
            manifestPlaceholders["appIconRound"] = "@mipmap/ic_launcher_vl_round"
        }

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.02.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}