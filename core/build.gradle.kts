plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "top.softnepo.easy.logic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    api("com.android.tools.build:gradle:7.4.0")
    api("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    compileOnly(gradleApi())
}

publishing {
    publications {
        create<MavenPublication>("easyLogic") {
            groupId = "top.softnepo"
            artifactId = "logic"
            version = "0.0.14-experimental"

            from(components["java"])
        }
    }
}