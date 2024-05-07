
# ☕🚀 Railway API Track Management


> ⚡ Start your Java projects as fast as possible

## ℹ️ Introduction

This Java project, integrated with Gradle, offers an API tailored for railway route management and tracking. It features endpoints enabling users to compute distances between cities, enumerate routes meeting specific criteria, and conduct various other railway-related operations.

## 🏁 How To Start

1. Install Java 17: `brew cask install corretto`
2. Set it as your default JVM: `export JAVA_HOME='/Library/Java/JavaVirtualMachines/amazon-corretto-17.jdk/Contents/Home'`
3. Clone this repository: `git clone https://github.com/rmartinezoliva87/railway_trac_management.git`.
4. Bring up the Docker environment: `make up`.
5. Execute some [Gradle lifecycle tasks](https://docs.gradle.org/current/userguide/java_plugin.html#lifecycle_tasks) in order to check everything is OK:
    1. Create [the project JAR](https://docs.gradle.org/current/userguide/java_plugin.html#sec:jar): `make build`
    2. Run the tests and plugins verification tasks: `make test`
6. Start developing!

## ☝️ How to update dependencies

* Gradle ([releases](https://gradle.org/releases/)): `./gradlew wrapper --gradle-version=WANTED_VERSION --distribution-type=bin`
