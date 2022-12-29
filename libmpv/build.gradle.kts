plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    namespace = "dev.jdtech.mpv"
    compileSdk = 33
    buildToolsVersion = "33.0.1"

    defaultConfig {
        minSdk = 26
        targetSdk = 33
        consumerProguardFiles("proguard-rules.pro")
    }
}

publishing {
    repositories {
        maven {
            name = "reposilite"
            url = uri("https://reposilite.jdtech.dev/releases")
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = "dev.jdtech.mpv"
            artifactId = "libmpv"
            version = "0.35.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

dependencies {
    implementation("androidx.annotation:annotation:1.5.0")
}