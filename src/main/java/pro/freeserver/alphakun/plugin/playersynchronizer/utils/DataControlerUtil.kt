package pro.freeserver.alphakun.plugin.playersynchronizer.utils

import io.supabase.postgrest.PostgrestDefaultClient
import pro.freeserver.alphakun.plugin.playersynchronizer.PlayerSynchronizer.Companion.requestURI
import pro.freeserver.alphakun.plugin.playersynchronizer.PlayerSynchronizer.Companion.serviceKey
import java.net.URI

object DataControlerUtil {
    val postgrestClient = PostgrestDefaultClient(
        uri = URI(requestURI),
        headers = mapOf("Authorization" to "Bearer $serviceKey", "apikey" to serviceKey),
    )
}