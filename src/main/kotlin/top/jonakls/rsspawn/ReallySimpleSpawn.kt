package top.jonakls.rsspawn

import org.bukkit.plugin.java.JavaPlugin
import team.unnamed.inject.Injector
import top.jonakls.rsspawn.inject.MainModule

class ReallySimpleSpawn : JavaPlugin() {

    override fun onEnable() {
        Injector.create(MainModule(this))
            .injectMembers(this)

        logger.info("Hello, world!")
    }

    override fun onDisable() {
        logger.info("Goodbye, world!")
    }
}