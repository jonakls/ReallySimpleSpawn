plugins {
    kotlin("jvm") version ("1.9.21")
    id("com.github.johnrengelman.shadow") version ("8.1.1")
    id("net.minecrell.plugin-yml.paper") version ("0.6.0")
}

group = "top.jonakls"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.triumphteam.dev/snapshots/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    implementation("team.unnamed:inject:2.0.1")
    implementation("dev.triumphteam:triumph-cmd-bukkit:2.0.0-SNAPSHOT")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

tasks {
    shadowJar {
        archiveBaseName.set("ReallySimpleSpawn")

        listOf(
            "team.unnamed.inject",
            "dev.triumphteam.triumphcmd",
        ).forEach {
            relocate(it, "top.jonakls.rsspawn.libs.${it}")
        }
    }
}

paper {
    main = "top.jonakls.rsspawn.ReallySimpleSpawn"
    name = findProperty("plugin.name").toString()
    version = findProperty("plugin.version").toString()
    author = findProperty("plugin.authors").toString()
    description = findProperty("plugin.description").toString()

    apiVersion = "1.17"
    website = ""
}