package top.softnepo.core.android

import com.android.build.api.dsl.CompileOptions
import com.android.build.api.dsl.DefaultConfig
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.api.AndroidSourceSet
import com.android.build.gradle.api.LibraryVariant
import com.android.build.gradle.internal.dsl.BuildType
import com.android.build.gradle.internal.dsl.ProductFlavor
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.internal.DefaultDomainObjectSet
import top.softnepo.core.EasyLogicContext
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

typealias AndroidDefaultConfig = com.android.build.gradle.internal.dsl.DefaultConfig

internal interface EasyLogicAndroid : EasyLogicContext {

    var compileSdk: Int?
    var packageName: String?
    var targetSdk: Int?

    val libraryVariants: DefaultDomainObjectSet<LibraryVariant>
    val buildTypes: NamedDomainObjectContainer<BuildType>
    val defaultConfig: com.android.build.gradle.internal.dsl.DefaultConfig
    val productFlavors: NamedDomainObjectContainer<ProductFlavor>
    val sourceSets: NamedDomainObjectContainer<AndroidSourceSet>

    fun onAndroidDefaultConfig(config: AndroidDefaultConfig.() -> Unit)
    fun onDefaultConfig(config: DefaultConfig.() -> Unit)
    fun onCompileOptions(options: CompileOptions.() -> Unit)
    fun onKotlinOptions(options: KotlinJvmOptions.() -> Unit)
    fun onLibraryExtension(context: LibraryExtension.() -> Unit)
}