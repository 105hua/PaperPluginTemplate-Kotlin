/* Licensed under <LICENSE> */
package joshdev.paperPluginTemplateKotlin

import io.papermc.paper.command.brigadier.CommandSourceStack
import joshdev.paperPluginTemplateKotlin.commands.ExampleCommand
import joshdev.paperPluginTemplateKotlin.events.PlayerJoin
import org.bukkit.plugin.java.JavaPlugin
import org.incendo.cloud.annotations.AnnotationParser
import org.incendo.cloud.execution.ExecutionCoordinator
import org.incendo.cloud.paper.PaperCommandManager

class PaperPluginTemplateKotlin : JavaPlugin() {

    companion object {
        lateinit var pluginInstance: PaperPluginTemplateKotlin
        lateinit var commandManager: PaperCommandManager<CommandSourceStack>
        lateinit var annotationParser: AnnotationParser<CommandSourceStack>
    }

    override fun onEnable() {
        // Set plugin instance, command manager and annotation parser.
        pluginInstance = this
        commandManager = PaperCommandManager.builder()
            .executionCoordinator(ExecutionCoordinator.simpleCoordinator())
            .buildOnEnable(this)
        annotationParser = AnnotationParser(commandManager, CommandSourceStack::class.java)
        // Parse the example command.
        annotationParser.parse(ExampleCommand())
        // Parse the join event.
        server.pluginManager.registerEvents(PlayerJoin(), this)
        // Log that the plugin has been enabled.
        logger.info("Plugin enabled.")
    }

    override fun onDisable() {
        // Log that the plugin has been disabled.
        logger.info("Plugin disabled.")
    }
}
