package top.softnepo.internal

import org.gradle.api.artifacts.VersionCatalog

interface EasyLogicCatalogSupport : EasyLogicContext {
    val versionCatalog: VersionCatalog

    fun EasyLogicCatalogSupport.findCatalogLibrary(library: String): Any {
        return this.versionCatalog.findLibrary(library).get()
    }

    fun EasyLogicCatalogSupport.findCatalogLibrary(library: Any): Any {
        return this.versionCatalog.findLibrary(library as String).get()
    }
}