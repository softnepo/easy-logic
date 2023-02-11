package top.softnepo.core

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.plugins.ExtensionAware

internal interface EasyLogicContext {
    companion object {
        const val REFERENCE_KOTLIN_OPTIONS : String = "kotlinOptions"
        const val DEPENDENCY_IMPLEMENTATION : String = "implementation"
        const val DEPENDENCY_TEST_IMPLEMENTATION : String = "testImplementation"
        const val DEPENDENCY_KAPT : String = "kapt"
        const val DEPENDENCY_KAPT_ANDROID_TEST : String = "kaptAndroidTest"
        const val DEPENDENCY_ANDROID_TEST_IMPLEMENTATION : String = "androidTestImplementation"
    }

    fun buildLog(description: String) {
        println("> EasyLogicContext : $description")
    }

    fun <T> LibraryExtension.getExtensionAwareScope(
            name: String,
            action: T.() -> Unit
    ) = (this as ExtensionAware).extensions.configure(name, action)

    fun LibraryExtension.getAndroid() = this as CommonExtension<*, *, *, *>
}