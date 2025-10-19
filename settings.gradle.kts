rootProject.name = "ExampleMultiVersionMod"

include("shared")
project(":shared").projectDir = file("/src/shared")

include("loaders")
project(":loaders").projectDir = file("/src/loaders")

include(":loaders:fabric")
include(":loaders:fabric:1.21.3", ":loaders:fabric:1.21.8")

pluginManagement {
    repositories {
        mavenCentral()
        maven("https://maven.fabricmc.net/")
        gradlePluginPortal()
    }
}
