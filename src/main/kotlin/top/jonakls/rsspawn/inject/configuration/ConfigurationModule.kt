package top.jonakls.rsspawn.inject.configuration

import team.unnamed.inject.AbstractModule
import team.unnamed.inject.Provides
import team.unnamed.inject.Singleton
import top.jonakls.rsspawn.ReallySimpleSpawn
import top.jonakls.rsspawn.configurate.Configuration
import top.jonakls.rsspawn.configurate.loader.ConfigurationLoader

class ConfigurationModule : AbstractModule() {

    @Singleton
    @Provides
    fun provideConfiguration(plugin: ReallySimpleSpawn): Configuration {
        val configFiles = ConfigurationLoader()
        configFiles.loadFiles(plugin.dataFolder.toPath())
        configFiles.loadConfig(plugin.dataFolder.toPath())
        return configFiles.get()
    }
}