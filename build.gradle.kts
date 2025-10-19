tasks.register("buildAll") {
    dependsOn(":loaders:fabric:1.21.3:build")
    dependsOn(":loaders:fabric:1.21.8:build")
}
