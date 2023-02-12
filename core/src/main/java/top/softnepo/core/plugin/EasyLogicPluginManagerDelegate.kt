package top.softnepo.core.plugin

import org.gradle.api.plugins.PluginManager

abstract class EasyLogicPluginManagerDelegate : EasyLogicPluginManager<String> {

    abstract val pluginManager: PluginManager

    override fun applyPlugin(plugin: String) {
        if (pluginManager.findPlugin(plugin)?.id == plugin) {
            return
        }

        pluginManager.apply(plugin)
        buildLog("plugin $plugin applied")
    }
}