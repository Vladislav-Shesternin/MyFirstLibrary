
plugins {
    `java-library`
    `kotlin`
    `maven-publish`
}

group = "com.uxo"
version = "1.0.0"

repositories {
    mavenCentral()
    mavenLocal()
    maven { url = uri("https://jitpack.io") }
}

val gdxVersion = "1.12.0"

dependencies {
    api("com.badlogicgames.gdx:gdx:$gdxVersion")
}
