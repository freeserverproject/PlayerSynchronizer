package pro.freeserver.alphakun.plugin.playersynchronizer.listeners

import io.supabase.postgrest.http.PostgrestHttpException
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent
import pro.freeserver.alphakun.plugin.playersynchronizer.consts.JsonLocation
import pro.freeserver.alphakun.plugin.playersynchronizer.consts.PlayerData
import pro.freeserver.alphakun.plugin.playersynchronizer.utils.DataControlerUtil
import java.util.*

class PlayerQuit: Listener {

    @EventHandler
    fun onPlayerQuit(e: PlayerQuitEvent) {
        val uuid = e.player.uniqueId
        val last_logout_location = JsonLocation(e.player.location)
        try {
            DataControlerUtil.postgrestClient.from<PlayerData>("freeserver_user")
                .update(mapOf("last_logout_location" to last_logout_location))
                .eq("mcuuid", uuid)
                .execute()
        } catch (e: PostgrestHttpException) {
        }
    }
}