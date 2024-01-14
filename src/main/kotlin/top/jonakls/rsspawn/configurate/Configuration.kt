package top.jonakls.rsspawn.configurate

import org.spongepowered.configurate.objectmapping.ConfigSerializable

@ConfigSerializable
class Configuration {

    var options: Options = Options()
    var spawn: Spawn = Spawn()

    @ConfigSerializable
    class Options {
        var spawnOnJoin: Boolean = true
        var spawnOnDeath: Boolean = true
        var spawnOnRespawn: Boolean = true
    }

    @ConfigSerializable
    class Spawn {
        var world: String = "world"
        var x: Double = 0.0
        var y: Double = 0.0
        var z: Double = 0.0
        var yaw: Float = 0.0f
        var pitch: Float = 0.0f
    }

}