# Quarkus MicroProfile example [![Build Status](https://travis-ci.org/daggerok/java-mp-quarkus-example.svg?branch=master)](https://travis-ci.org/daggerok/java-mp-quarkus-example)
Simple [quarkus.io](https://quarkus.io/) MicroProfile quickstart example for maven, gradle and docker

## dev mode

### maven

```bash
./mvnw quarkus:list-extensions
./mvnw compile quarkus:dev

http :8080/health
http :8080/openapi
http :8080/api/v1/hello
http :8080/api/v1/hello/world
```

### gradle

```bash
./gradlew listExtensions

http :8080/health
http :8080/openapi
http :8080/api/v1/hello
http :8080/api/v1/hello/world
```

## build and run jar

### maven

```bash
./mvnw compile quarkus:build
# or: ./mvnw package

java -cp ./target/lib -jar ./target/*-runner.jar
```

### gradle

```bash
./gradlew quarkusBuild

java -cp ./build/lib -jar ./build/*-runner.jar
```

## docker-compose

### maven

```bash
./mvnw -P docker docker-compose:up

http :8080/api/v1/hello

./mvnw docker-cpompose:down
```

### gradle

```bash
./gradlew composeUp

http :8080/api/v1/hello

./gradlew composeDown
```

## plain docker-compose

### gradle

```bash
./gradlew
docker-compose -f ./src/main/docker/docker-compose-gradle.yaml up
# ...
docker-compose -f ./src/main/docker/docker-compose-gradle.yaml down
```

### maven

```bash
./mvnw
docker-compose -f ./src/main/docker/docker-compose-maven.yaml up
# ...
docker-compose -f ./src/main/docker/docker-compose-maven.yaml down
```

## getting starting project quicker...

```bash
mvn io.quarkus:quarkus-maven-plugin:0.12.0:create \
  -DprojectGroupId=com.github.daggerok \
  -DprojectArtifactId=java-mp-quarkus-example \
  -DprojectVersion=1.0-SNAPSHOT \
  -DclassName="com.github.daggerok.ApplicationResource" \
  -B
cd java-mp-quarkus-example/
gradle init --type=basic --dsl=kotlin --project-name=java-mp-quarkus-example
# ...
```

links:

* [Quarkus getting started guide from quarkus.io](https://quarkus.io/guides/getting-started-guide.html)
* [Maven docker-compose plugin](https://github.com/dkanejs/docker-compose-maven-plugin)
* [Gradle docker-compose plugin](https://github.com/avast/gradle-docker-compose-plugin)
