version = "0.1"
group = "com.github.mikhailstepanov88"

buildscript {
    repositories {
        jcenter()
    }
}

plugins {
    id("java-gradle-plugin")
    id("org.jetbrains.kotlin.jvm").version("1.2.71")
    id("com.gradle.plugin-publish").version("0.10.0")
}

repositories {
    jcenter()
}

dependencies {
    compile(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jdk8")
    compile(group = "org.jetbrains.kotlin", name = "kotlin-gradle-plugin", version = "1.2.71")
    compile(group = "com.google.protobuf", name = "protobuf-gradle-plugin", version = "0.8.6")
}

pluginBundle {
    tags = listOf("kotlin", "protobuf")
    vcsUrl = "https://github.com/mikhailstepanov88/protobuf_kotlin"
    website = "https://github.com/mikhailstepanov88/protobuf_kotlin"
    description = "Plugin for simplify working with protobuf and kotlin"
}

gradlePlugin {
    plugins {
        create("protobufKotlinPlugin") {
            id = "com.github.mikhailstepanov88.protobuf-kotlin"
            displayName = "Protobuf Kotlin Plugin"
            description = "Plugin for simplify working with protobuf and kotlin"
            implementationClass = "com.github.mikhailstepanov88.protobuf_kotlin.ProtobufKotlinPlugin"
        }
    }
}