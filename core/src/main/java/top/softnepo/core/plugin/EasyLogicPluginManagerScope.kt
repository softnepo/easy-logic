package top.softnepo.core.plugin

import org.gradle.api.plugins.PluginManager

class EasyLogicPluginManagerScope(override val pluginManager: PluginManager) : EasyLogicPluginManagerDelegate()