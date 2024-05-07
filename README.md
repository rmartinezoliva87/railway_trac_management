
# 🚀 Railway API Track Management

> ⚡ Start your Java projects as fast as possible

## ℹIntroduction

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
  
## 🏁 Test Api

1. Example request

{
    "graph":"AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7"
}

Response

{
    "answers": [
        "Salida #1: 9",
        "Salida #2: 5",
        "Salida #3: 13",
        "Salida #4: 22",
        "Salida #5: NO HAY TAL RUTA",
        "Salida #6: 2",
        "Salida #7: 3",
        "Salida #8: 9",
        "Salida #9: 9",
        "Salida #10: 7"
    ]
}
