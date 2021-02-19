plugins {
    java
    kotlin("jvm") version "1.4.30"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
            url = uri("http://130.193.49.249:8082/artifactory/talenttech")
        credentials {
            username = "admin"
            password = "875421QwRt!"
        }
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    testCompile("junit", "junit", "4.12")
    testImplementation(kotlin("script-runtime"))
    implementation ("ru.talenttech.xqa:oknetwork:0.1.1")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation ("org.testng:testng:7.1.0")
    implementation ("org.json:json:20200518")
    implementation ("junit:junit:4.12")
}
