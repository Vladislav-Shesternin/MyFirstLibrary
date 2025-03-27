plugins {
    kotlin("jvm") version "1.9.22"
}

group = "com.github.Vladislav-Shesternin"
version = "1.0.0"

repositories {
    mavenCentral()
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
    maven { url = uri("https://oss.sonatype.org/content/repositories/releases/") }
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    api("com.badlogicgames.gdx:gdx:1.13.1")
}