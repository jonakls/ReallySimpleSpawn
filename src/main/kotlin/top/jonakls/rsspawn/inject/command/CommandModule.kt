package top.jonakls.rsspawn.inject.command

import dev.triumphteam.cmd.bukkit.BukkitCommandManager
import dev.triumphteam.cmd.core.BaseCommand
import org.bukkit.command.CommandSender
import team.unnamed.inject.AbstractModule
import team.unnamed.inject.Provides
import team.unnamed.inject.Singleton
import top.jonakls.rsspawn.ReallySimpleSpawn
import top.jonakls.rsspawn.command.MainCommand

class CommandModule : AbstractModule() {

    @Singleton
    @Provides
    fun providesCommandManager(plugin: ReallySimpleSpawn): BukkitCommandManager<CommandSender> {
        return BukkitCommandManager.create(plugin)
    }

    override fun configure() {
        this.multibind(BaseCommand::class.java)
            .asSet()
            .to(MainCommand::class.java)
            .singleton()

    }

}