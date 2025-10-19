plugins {
    id("java")
    id("fabric-loom") version "1.10-SNAPSHOT"
    id("com.gradleup.shadow") version "9.2.2"
}

dependencies {
    minecraft("com.mojang:minecraft:${project.property("minecraft_version")}")
    mappings("net.fabricmc:yarn:${project.property("yarn_mappings_version")}:v2")
    modImplementation("net.fabricmc:fabric-loader:${project.property("fabric_loader_version")}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${project.property("fabric_api_version")}")

    implementation(project(":shared"))
}

tasks.shadowJar {
    archiveBaseName.set(project.property("mod_name").toString())
    configurations = listOf(project.configurations.compileClasspath.get())
    dependencies {
        include(dependency(":shared"))
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    destinationDirectory.set(layout.buildDirectory.dir("shadowTmp"))
    doNotTrackState("Custom destination directory needs doNotTrackState")
}

tasks.remapJar {
    dependsOn(tasks.shadowJar)
    inputFile.set(tasks.shadowJar.get().archiveFile)
    archiveFileName.set("${project.property("mod_name")} ${project.property("mod_version")} for Fabric ${project.property("minecraft_version").toString()}.jar")
    destinationDirectory.set(rootProject.layout.buildDirectory.dir("lib"))
}

tasks.processResources {
    filesMatching("fabric.mod.json") {
        expand(project.properties)
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(project.property("java_version").toString().toInt()))
    }
}
