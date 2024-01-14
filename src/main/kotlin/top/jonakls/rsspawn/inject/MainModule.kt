package top.jonakls.rsspawn.inject

import team.unnamed.inject.AbstractModule
import top.jonakls.rsspawn.ReallySimpleSpawn
import top.jonakls.rsspawn.inject.command.CommandModule

class MainModule(
    private val plugin: ReallySimpleSpawn
) : AbstractModule() {

    override fun configure() {
        this.bind(ReallySimpleSpawn::class.java)
            .toInstance(this.plugin)

        this.install(CommandModule())
    }
}