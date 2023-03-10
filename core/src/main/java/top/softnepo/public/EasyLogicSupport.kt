package top.softnepo.public

import top.softnepo.core.android.EasyLogicAndroidScope
import com.android.build.gradle.LibraryExtension
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import top.softnepo.core.dependency.EasyLogicDependencyScope
import top.softnepo.core.plugin.EasyLogicPluginManagerScope

fun org.gradle.api.Project.`getLibrary`(onLibraryExtension: LibraryExtension.() -> Unit) = extensions.configure<LibraryExtension> {
    onLibraryExtension(this)
}

fun org.gradle.api.Project.`getCatalogApi`() = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun org.gradle.api.Project.`easyLogicBuild`(settings: EasyLogicAndroidScope.() -> Unit) = getLibrary {
    settings(EasyLogicAndroidScope(this))
}

fun org.gradle.api.Project.`easyLogicDependency`(settings: EasyLogicDependencyScope.() -> Unit) = dependencies {
    settings(EasyLogicDependencyScope(this, getCatalogApi()))
}

fun org.gradle.api.Project.`easyLogicPlugins`(settings: EasyLogicPluginManagerScope.() -> Unit) = settings(EasyLogicPluginManagerScope(pluginManager))
