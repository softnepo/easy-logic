package top.softnepo.core.dependency

import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.DependencyHandlerScope
import top.softnepo.internal.EasyLogicCatalogSupport

class EasyLogicDependencyScope constructor(
        override val handlerScope: DependencyHandlerScope,
        override val versionCatalog: VersionCatalog
) : EasyLogicDependencyDelegate(), EasyLogicCatalogSupport {

    fun catalogImplementation(reference: Any) {
        implementation(findCatalogLibrary(reference))
    }

    fun catalogTestImplementation(reference: Any) {
        testImplementation(findCatalogLibrary(reference))
    }

    fun catalogKapt(reference: Any) {
        kapt(findCatalogLibrary(reference))
    }

    fun catalogKaptAndroidTest(reference: Any) {
        kaptAndroidTest(findCatalogLibrary(reference))
    }

    fun catalogAndroidTestImplementation(reference: Any) {
        androidTestImplementation(findCatalogLibrary(reference))
    }
}