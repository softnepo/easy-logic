package top.softnepo.core.android

import com.android.build.api.dsl.CompileOptions
import com.android.build.api.dsl.DefaultConfig
import com.android.build.gradle.LibraryExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import top.softnepo.internal.EasyLogicContext

class EasyLogicAndroidScope(
   override val common: LibraryExtension
) : EasyLogicAndroidDelegate() {

    override fun onDefaultConfig(config: DefaultConfig.() -> Unit) {
        config(common.defaultConfig)
    }

    override fun onCompileOptions(options: CompileOptions.() -> Unit) {
        options(common.compileOptions)
    }

    override fun onAndroidDefaultConfig(config: AndroidDefaultConfig.() -> Unit) {
        config(common.defaultConfig)
    }

    override fun onKotlinOptions(options: KotlinJvmOptions.() -> Unit) {
        common.getExtensionAwareScope(EasyLogicContext.REFERENCE_KOTLIN_OPTIONS, options)
    }

    override fun onLibraryExtension(context: LibraryExtension.() -> Unit) {
        context(common)
    }
}