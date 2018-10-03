package com.github.mikhailstepanov88.protobuf_kotlin.internal.plugin.configurer

import com.google.protobuf.gradle.ExecutableLocator
import com.google.protobuf.gradle.ProtobufConvention
import com.google.protobuf.gradle.ProtobufPlugin
import groovy.lang.Closure
import org.gradle.api.Project
import org.gradle.internal.Cast.uncheckedCast

class ProtobufPluginConfigurer : PluginConfigurer<ProtobufConvention>() {
    /**
     * Get class of plugin for search in project.
     *
     * @return class of plugin for search in project.
     */
    override fun searchPluginClass() = ProtobufPlugin::class.java

    /**
     * Get class of plugin for add to project.
     *
     * @return class of plugin for add to project.
     */
    override fun pluginClass() = ProtobufPlugin::class.java

    /**
     * Is plugin will be added to project if it not exists.
     *
     * @return plugin will be added to project if it not exists or not.
     */
    override fun addPluginIfNotExists() = true

    /**
     * Get configuration of plugin.
     *
     * @param project project.
     * @return configuration of plugin.
     */
    override fun pluginConfig(project: Project) =
            project.convention.getPlugin(ProtobufConvention::class.java)

    /**
     * Update configuration of plugin.
     */
    override fun ProtobufConvention.update() {
        protobuf.protoc(protocConfig())
    }

    /**
     * Get configuration of protoc script.
     *
     * @return configuration of protoc script.
     */
    private fun protocConfig() = lazyConfigureObject<ExecutableLocator> {
        it.artifact = "com.google.protobuf:protoc:3.6.1"
    }

    /**
     * Configure object lazy.
     *
     * @param configure function for configure object.
     * @return Groovy closure with lazy configure operation.
     */
    private fun <TypeOfObject> lazyConfigureObject(configure: (TypeOfObject) -> Unit) = object : Closure<Unit>(this, this) {
        override fun call() = configure(uncheckedCast<TypeOfObject>(delegate))
    }
}