rootProject.name = "java-mp-quarkus-example"
// required by quarkus gradle plugin:
pluginManagement {
  repositories {
    mavenCentral()
    gradlePluginPortal()
  }
  resolutionStrategy {
    eachPlugin {
      if (requested.id.id == "io.quarkus.gradle.plugin") {
        useModule("io.quarkus:quarkus-gradle-plugin:${requested.version}")
      }
    }
  }
}
