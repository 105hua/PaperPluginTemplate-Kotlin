plugins {
    kotlin("jvm") version "2.0.20"
    id("com.gradleup.shadow") version "8.3.2"
    id("com.diffplug.spotless") version "7.0.0.BETA2"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "joshdev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.incendo:cloud-paper:2.0.0-beta.10")
    implementation("org.incendo:cloud-annotations:2.0.0")
    annotationProcessor("org.incendo:cloud-annotations:2.0.0")
}

val targetJavaVersion = 21
kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks{
    shadowJar{
        isEnableRelocation = true
        relocationPrefix = "${rootProject.property("group")}.${rootProject.property("name").toString().lowercase()}.lib"
        minimize()
        archiveClassifier.set("")
    }
    build{
        dependsOn("shadowJar")
    }
    processResources {
        val props = mapOf("version" to version)
        inputs.properties(props)
        filteringCharset = "UTF-8"
        filesMatching("plugin.yml") {
            expand(props)
        }
    }
    runServer{
        minecraftVersion("1.21.1")
        jvmArgs("-Dcom.mojang.eula.agree=true")
    }
}

spotless{
    format("misc"){
        target(listOf("**/*.gradle.kts", "**/*.md"))
        trimTrailingWhitespace()
        indentWithSpaces(4)
    }
    kotlin{
        ktlint("1.3.1").editorConfigOverride(
            mapOf(
                "max_line_length" to 500
            )
        )
        licenseHeader("/* Licensed under <LICENSE> */")
    }
}