package pro.freeserver.alphakun.plugin.playersynchronizer.consts

import org.bukkit.Location

class JsonLocation constructor(location: Location?) {
    val x: Double? = location?.x
    val y: Double? = location?.y
    val z: Double? = location?.z
    val yaw: Float? = location?.yaw
    val pitch: Float? = location?.pitch
    val worldUID: String = location?.world?.uid.toString()
}