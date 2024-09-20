/* Licensed under <LICENSE> */
package joshdev.paperPluginTemplateKotlin.events

import joshdev.paperPluginTemplateKotlin.PaperPluginTemplateKotlin
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoin : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val joinComponent = Component.text(
            "Welcome to the server, ${player.name}!",
            NamedTextColor.YELLOW,
            TextDecoration.BOLD,
        )
        PaperPluginTemplateKotlin.pluginInstance.server.broadcast(joinComponent)
    }
}
