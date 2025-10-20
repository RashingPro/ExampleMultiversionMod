# What is this?
This is PoC project shows project setup for easy mod development for different minecraft versions. It allows you to use shared code between multiply versions, easily build and manage it

# Using
Sync everything up:
```shell
python ./environment/scripts/sync_build_gradle.py
```
Build all:
```shell
./gradlew buildAll
```
Build all versions for specific loader:
```shell
./gradlew :loaders:<loader>:build
```
Build specific version for specific version:
```shell
./gradlew :loaders:<loader>:<version>:build
```

## Adding new version
1. Create new folder `src/<loader>/<version>`.
2. Create `src` folder and `gradle.properties` file. Use already existing versions as an example.
3. Run `sync_build_gradle.py` script.
4. Add new entry to `settings.gradle.kts`. For example:
    ```diff
    -include(":loaders:fabric:1.21.3", ":loaders:fabric:1.21.8")
    +include(":loaders:fabric:1.21.3", ":loaders:fabric:1.21.8", ":loaders:fabric:1.19.1")
    ```
