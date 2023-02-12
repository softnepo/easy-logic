package top.softnepo.core.plugin

import top.softnepo.internal.EasyLogicContext

interface EasyLogicPluginManager<T> : EasyLogicContext {
    fun applyPlugin(plugin: T)
}