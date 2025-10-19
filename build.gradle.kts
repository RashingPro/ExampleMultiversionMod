tasks.register("buildAll") {
    dependsOn (project(":loaders").subprojects.map { it.tasks.getByName("build") })
}
