plugins {
    kotlin("jvm") version ("1.9.21")
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
    compileOnly("team.unnamed:inject:2.0.1")
    compileOnly("dev.triumphteam:triumph-cmd-bukkit:2.0.0-SNAPSHOT")
    compileOnly("org.spongepowered:configurate-gson:4.1.2")
    compileOnly("org.spongepowered:configurate-extra-kotlin:4.1.2")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

tasks {
    jar {
        archiveBaseName.set("ReallySimpleSpawn")
    }
}

paper {
    main = "top.jonakls.rsspawn.ReallySimpleSpawn"
    loader = "top.jonakls.rsspawn.ReallySimpleSpawnLoader"
    name = findProperty("plugin.name").toString()
    version = findProperty("plugin.version").toString()
    author = findProperty("plugin.authors").toString()
    description = findProperty("plugin.description").toString()

    apiVersion = "1.20"
    website = ""
}