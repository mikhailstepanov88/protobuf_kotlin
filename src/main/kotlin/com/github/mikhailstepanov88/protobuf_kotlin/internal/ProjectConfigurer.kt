package com.github.mikhailstepanov88.protobuf_kotlin.internal

import org.gradle.api.Project

interface ProjectConfigurer {
    /**
     * Configure project.
     *
     * @param project project for update.
     */
    fun configure(project: Project)
}