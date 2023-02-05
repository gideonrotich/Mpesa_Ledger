import org.gradle.api.JavaVersion

/**
 * A collection of configuration properties for Android modules.
 */
object AndroidConfig {
    const val minSDK = 24
    const val targetSDK = 33
    const val compileSDK = 33
    const val versionCode = 1
    const val versionName = "1"
    const val applicationId = "com.swayy.mpesa"

    val javaVersion = JavaVersion.VERSION_11
}