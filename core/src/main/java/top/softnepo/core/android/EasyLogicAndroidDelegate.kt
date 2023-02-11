package top.softnepo.core.android

import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.api.AndroidSourceSet
import com.android.build.gradle.api.LibraryVariant
import com.android.build.gradle.internal.dsl.BuildType
import com.android.build.gradle.internal.dsl.ProductFlavor
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.internal.DefaultDomainObjectSet
import com.android.build.gradle.internal.dsl.DefaultConfig

abstract class EasyLogicAndroidDelegate : EasyLogicAndroid {

    abstract val common: LibraryExtension

    override var compileSdk: Int?
        get() = common.compileSdk
        set(value) {
            if (value == compileSdk) {
                buildLog("compileSdk $value already exist")
                return
            }

            common.compileSdk = value
            buildLog("applied new compileSDk to $value")
        }

    override var packageName: String?
        get() = common.namespace
        set(value) {
            if (value == packageName) return
            common.namespace = value
            buildLog("applied new packageName to $value")
        }

    override var targetSdk: Int?
        get() = common.defaultConfig.targetSdk
        set(value) {
            if (value == targetSdk) return
            common.defaultConfig.targetSdk = value
            buildLog("applied new targetSdk to $value")
        }

    override val libraryVariants: DefaultDomainObjectSet<LibraryVariant>
        get() = common.libraryVariants

    override val buildTypes: NamedDomainObjectContainer<BuildType>
        get() = common.buildTypes
    override val defaultConfig: DefaultConfig
        get() = common.defaultConfig
    override val productFlavors: NamedDomainObjectContainer<ProductFlavor>
        get() = common.productFlavors
    override val sourceSets: NamedDomainObjectContainer<AndroidSourceSet>
        get() = common.sourceSets

}