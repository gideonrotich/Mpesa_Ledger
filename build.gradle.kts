// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version ("8.1.0-alpha02") apply false
    id ("com.android.library") version ("8.1.0-alpha02") apply false
    id ("org.jetbrains.kotlin.android") version ("1.7.20") apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.20" apply false
    id("com.google.dagger.hilt.android") version ("2.44") apply false
    id("org.jlleitschuh.gradle.ktlint") version ("11.0.0")
}

subprojects {

    repositories {
        mavenCentral()
    }

    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    ktlint {
        android.set(true)
        verbose.set(true)
        debug.set(true)
        outputToConsole.set(true)
        outputColorName.set("RED")
        ignoreFailures.set(true)
        enableExperimentalRules.set(true)
        filter {
            exclude { element -> element.file.path.contains("generated/") }
        }
    }
}
