tasks.register("build") {
    dependsOn (
        subprojects.map { it.tasks.getByName("build") }
    )
}
