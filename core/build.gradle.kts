import org.jetbrains.kotlin.konan.file.use
import java.util.*
import java.net.*

plugins {
    `kotlin-dsl`
    `maven-publish`
    signing
    java
}

group = "top.softnepo.easy-logic"
version = "0.0.11-experimental"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    withJavadocJar()
    withSourcesJar()
}

repositories {
    mavenCentral()
    google()
    maven { url = URI("https://oss.sonatype.org/content/repositories/snapshots/") }
}

dependencies {
    api("com.android.tools.build:gradle:7.4.0")
    api("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    compileOnly(gradleApi())
}

val propertiesGradle = Properties()
val gradleDirectory = project.gradle.gradleUserHomeDir.path
val gradlePropertiesDirectory = "$gradleDirectory/gradle.properties"
val gradlePropertiesFile = project.file(gradlePropertiesDirectory)

gradlePropertiesFile.inputStream().use { propertiesGradle.load(it) }

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("libraryMaven") {
                groupId = "top.softnepo"
                artifactId = "easy-logic"
                version = "0.0.12-experimental"

                from(components["java"])

                pom {
                    name.set("easy logic")
                    description.set("Open source library to help android projects with custom gradle plugins internal")
                    url.set("https://github.com/softnepo/easy-logic")
                    inceptionYear.set("2023")

                    licenses {
                        license {
                            name.set("MIT License")
                            url.set("https://opensource.org/licenses/MIT")
                        }
                    }

                    developers {
                        developer {
                            id.set(propertiesGradle.getProperty("publish_softnepo_login"))
                            name.set(propertiesGradle.getProperty("publish_softnepo_name"))
                            email.set(propertiesGradle.getProperty("publish_softnepo_email"))
                        }
                    }

                    scm {
                        connection.set("scm:git:git:github.com/softnepo/easy-logic.git")
                        developerConnection.set("cm:git:ssh://github.com/softnepo/easy-logic.git")
                        url.set("https://github.com/softnepo/easy-logic")
                    }
                }
            }

            repositories {
                maven {
                    name = "OSSRH"
                    setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
                    credentials {
                        username = propertiesGradle.getProperty("publish_softnepo_login")
                        password = propertiesGradle.getProperty("publish_softnepo_pass")
                    }
                }
            }
        }
    }

    signing {
        sign(publishing.publications.getByName("libraryMaven"))
    }
}
