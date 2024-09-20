/* Licensed under <LICENSE> */
package joshdev.paperPluginTemplateKotlin.commands

import io.papermc.paper.command.brigadier.CommandSourceStack
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.entity.Player
import org.incendo.cloud.annotations.Command
import org.incendo.cloud.annotations.CommandDescription
import org.incendo.cloud.annotations.Permission

class ExampleCommand {

    @Command("example")
    @CommandDescription("An example command, this is the description.")
    @Permission("plugintemplate.example")
    @Suppress("unused")
    fun exampleCommand(sourceStack: CommandSourceStack) {
        val sender = sourceStack.sender
        if (sender !is Player) {
            sender.sendMessage("Only players can execute this command.")
            return
        }
        val exampleComponent = Component.text(
            "This is an example command!",
            NamedTextColor.GREEN,
            TextDecoration.BOLD,
        )
        sender.sendMessage(exampleComponent)
    }
}
