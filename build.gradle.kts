import com.avast.gradle.dockercompose.RemoveImages

plugins {
  java
  id("io.quarkus.gradle.plugin") version "0.12.0"
  id("com.avast.gradle.docker-compose") version "0.9.1"
  id("io.spring.dependency-management") version "1.0.7.RELEASE"
}

version = "1.0-SNAPSHOT"
group = "com.github.daggerok"
description = "Quarkus Gradle example"

tasks.withType(Wrapper::class.java) {
  gradleVersion = "5.3"
  distributionType = Wrapper.DistributionType.BIN
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
  mavenCentral()
  //// not needed, all dependencies should be in central
  //maven(url = uri("https://repository.jboss.org/nexus/content/groups/public"))
}

dependencyManagement {
  imports {
    mavenBom("io.quarkus:quarkus-bom:0.12.0")
  }
}

dependencies {
  implementation("io.quarkus:quarkus-resteasy")
  implementation("io.quarkus:quarkus-jsonp")
  implementation("io.quarkus:quarkus-jsonb")
  implementation("io.quarkus:quarkus-smallrye-health")
  implementation("io.quarkus:quarkus-smallrye-metrics")
  implementation("io.quarkus:quarkus-smallrye-openapi")
  testImplementation("io.quarkus:quarkus-junit5")
  testImplementation("io.rest-assured:rest-assured")
}

tasks {
  test {
    useJUnitPlatform()
  }
}

defaultTasks("quarkusBuild")
tasks["composeUp"].dependsOn("quarkusBuild")

dockerCompose {
  useComposeFiles = listOf("src/main/docker/docker-compose-gradle.yaml")
  projectName = "quarkus"
  removeImages = RemoveImages.Local
  isRemoveContainers = true
  isRemoveOrphans = true
  isRemoveVolumes = true
  isForceRecreate = true
  isBuildBeforeUp = true
  isIgnorePushFailure = true
}
