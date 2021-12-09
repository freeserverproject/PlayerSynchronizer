package pro.freeserver.alphakun.plugin.playersynchronizer.listeners

import io.supabase.postgrest.http.PostgrestHttpException
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import pro.freeserver.alphakun.plugin.playersynchronizer.consts.AccessLog
import pro.freeserver.alphakun.plugin.playersynchronizer.consts.PlayerData
import pro.freeserver.alphakun.plugin.playersynchronizer.utils.DataControlerUtil.postgrestClient
import java.time.LocalDateTime

class AsyncPlayerPreLogin: Listener {

    @EventHandler
    fun onAsyncPlayerPreLogin(e: AsyncPlayerPreLoginEvent) {
        sendUUID(e)
        sendLog(e)
    }

    fun sendUUID(e: AsyncPlayerPreLoginEvent) {
        val uuid = e.uniqueId
        try {
            postgrestClient.from<PlayerData>("freeserver_user").insert(
                value = PlayerData(
                    uuid,
                    null,
                    null)
            ).execute()
        } catch (e: PostgrestHttpException) {
        }
    }

    fun sendLog(e: AsyncPlayerPreLoginEvent) {
        val uuid = e.uniqueId
        val time = LocalDateTime.now()
        val ip_addr = e.address
        try {
            postgrestClient.from<AccessLog>("access_log").insert(
                value = AccessLog(
                    uuid,
                    time,
                    ip_addr
                )
            ).execute()
        } catch (e: PostgrestHttpException) {
        }
    }
}