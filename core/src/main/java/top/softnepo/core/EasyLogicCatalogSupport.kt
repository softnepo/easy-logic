package top.softnepo.core

import org.gradle.api.artifacts.VersionCatalog

internal interface EasyLogicCatalogSupport : EasyLogicContext {
    val versionCatalog: VersionCatalog

    fun EasyLogicCatalogSupport.findCatalogLibrary(library: String): Any {
        return this.versionCatalog.findLibrary(library).get()
    }

    fun EasyLogicCatalogSupport.findCatalogLibrary(library: Any): Any {
        return this.versionCatalog.findLibrary(library as String).get()
    }
}