package top.jonakls.rsspawn

import io.papermc.paper.plugin.loader.PluginClasspathBuilder
import io.papermc.paper.plugin.loader.PluginLoader
import io.papermc.paper.plugin.loader.library.impl.MavenLibraryResolver
import org.eclipse.aether.artifact.DefaultArtifact
import org.eclipse.aether.graph.Dependency
import org.eclipse.aether.repository.RemoteRepository

@Suppress("UnstableApiUsage", "unused")
class ReallySimpleSpawnLoader : PluginLoader {

    override fun classloader(classpathBuilder: PluginClasspathBuilder) {
        val resolver = MavenLibraryResolver()

        val mavenCentral = RemoteRepository.Builder(
            "central",
            "default",
            "https://repo.maven.apache.org/maven2/"
        ).build()

        val triumph = RemoteRepository.Builder(
            "triumph",
            "default",
            "https://repo.triumphteam.dev/snapshots/"
        ).build()

        val inject = Dependency(
            DefaultArtifact("team.unnamed:inject:2.0.1"), null
        )

        val triumphCmd = Dependency(
            DefaultArtifact("dev.triumphteam:triumph-cmd-bukkit:2.0.0-SNAPSHOT"), null
        )

        val configurateGson = Dependency(
            DefaultArtifact("org.spongepowered:configurate-gson:4.1.2"), null
        )

        val configurateExtraKotlin = Dependency(
            DefaultArtifact("org.spongepowered:configurate-extra-kotlin:4.1.2"), null
        )

        resolver.addRepository(mavenCentral)
        resolver.addRepository(triumph)

        resolver.addDependency(inject)
        resolver.addDependency(triumphCmd)
        resolver.addDependency(configurateGson)
        resolver.addDependency(configurateExtraKotlin)

        classpathBuilder.addLibrary(resolver)
    }
}