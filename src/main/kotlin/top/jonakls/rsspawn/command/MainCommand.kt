package top.jonakls.rsspawn.command

import dev.triumphteam.cmd.core.BaseCommand
import dev.triumphteam.cmd.core.annotation.Command
import dev.triumphteam.cmd.core.annotation.Default
import dev.triumphteam.cmd.core.annotation.SubCommand
import org.bukkit.entity.Player

@Command(value = "rsspawn", alias = ["rss"])
class MainCommand : BaseCommand() {

    @Default
    fun execute(sender: Player) {
        sender.sendMessage("Hello, world!")
    }

    @SubCommand("reload")
    fun reload(sender: Player) {
        sender.sendMessage("Reloading...")
    }
}