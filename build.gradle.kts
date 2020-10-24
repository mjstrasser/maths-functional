import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}

group = "mjs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val arrowVersion = "0.11.0"
val kotestVersion = "4.2.6"

dependencies {
    implementation(kotlin("stdlib"))

    implementation("io.arrow-kt:arrow-core:$arrowVersion")

    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<Test> {
    useJUnitPlatform()
}
