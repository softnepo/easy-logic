plugins {
    `kotlin-dsl`
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
}

//tasks.getByName<Test>("test") {
//    useJUnitPlatform()
//}