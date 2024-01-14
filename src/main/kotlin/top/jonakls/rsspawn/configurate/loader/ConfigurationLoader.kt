package top.jonakls.rsspawn.configurate.loader

import org.spongepowered.configurate.gson.GsonConfigurationLoader
import org.spongepowered.configurate.kotlin.extensions.get
import org.spongepowered.configurate.kotlin.objectMapperFactory
import top.jonakls.rsspawn.configurate.Configuration
import java.nio.file.Files
import java.nio.file.Path

class ConfigurationLoader {

    private val config = "config.json"
    private lateinit var configurationNode: Configuration

    fun loadFiles(folder: Path): Boolean {
        if (Files.notExists(folder)) {
            Files.createDirectories(folder)
        }

        val configPath = folder.resolve(config);
        if (Files.notExists(configPath)) {

            this.javaClass.getResourceAsStream(config).use {
                if (it == null) {
                    return false
                }

                Files.copy(it, configPath)
                return true
            }
        }
        return false
    }

    fun loadConfig(folder: Path): Boolean {
        val path = folder.resolve(config)

        val configLoader = GsonConfigurationLoader.builder()
            .path(path)
            .defaultOptions { options ->
                options.shouldCopyDefaults(true)
                options.serializers { builder ->
                    builder.registerAnnotatedObjects(objectMapperFactory())
                }
            }
            .build()

        val node = configLoader.load()
        this.configurationNode = node.get<Configuration>() ?: Configuration()
        return true
    }

    fun get(): Configuration {
        return this.configurationNode
    }
}