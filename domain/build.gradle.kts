plugins {
    kotlin("kapt")
    id("java-library")
    id("org.jetbrains.kotlin.jvm") version "1.7.20" apply false
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val mockkVersion = "1.13.9"
val coroutineVersion = "1.6.2"
val kotlinTestVersion = "1.9.22"
dependencies {
    implementation(project(":common"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
    testImplementation("org.testng:testng:6.9.6")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion")
    testImplementation("io.mockk:mockk:${mockkVersion}")
    // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-test
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlinTestVersion")
}