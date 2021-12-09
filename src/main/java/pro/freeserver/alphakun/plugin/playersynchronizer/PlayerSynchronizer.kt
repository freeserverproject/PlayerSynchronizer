package pro.freeserver.alphakun.plugin.playersynchronizer

import org.bukkit.plugin.java.JavaPlugin
import pro.freeserver.alphakun.plugin.playersynchronizer.listeners.AsyncPlayerPreLogin
import pro.freeserver.alphakun.plugin.playersynchronizer.listeners.PlayerQuit

class PlayerSynchronizer : JavaPlugin() {
    override fun onEnable() {
        saveDefaultConfig()
        loadConfig()
        generateEvents()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    companion object {
        lateinit var serviceKey: String
        lateinit var requestURI: String
    }

    private fun loadConfig() {
        serviceKey = config.getString("keys.service_key")?: "empty"
        requestURI = config.getString("locations.request_uri")?: "empty"
    }

    private fun generateEvents() {
        server.pluginManager.registerEvents(AsyncPlayerPreLogin(), this)
        server.pluginManager.registerEvents(PlayerQuit(), this)
    }
}