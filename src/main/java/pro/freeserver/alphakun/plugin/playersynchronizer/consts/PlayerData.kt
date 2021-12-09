package pro.freeserver.alphakun.plugin.playersynchronizer.consts

import org.bukkit.Location
import java.util.*

class PlayerData constructor(mcuuid: UUID, last_logout_location: Location?, discord_id: String?) {
    val mcuuid: UUID
    val last_logout_location: JsonLocation?
    val discord_id: String?

    init {
        this.mcuuid = mcuuid
        this.last_logout_location = JsonLocation(last_logout_location)
        this.discord_id = discord_id
    }
}