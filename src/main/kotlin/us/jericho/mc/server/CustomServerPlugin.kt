package us.jericho.mc.server

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import us.jericho.mc.server.events.DeathEventListener
import us.jericho.mc.server.events.MobSpawnListener
import us.jericho.mc.server.items.recipes.RecipeManager
import us.jericho.mc.server.worldguard.DemoFlag
import us.jericho.mc.server.worldguard.ZombieHordeFlag
import java.util.logging.Logger

class CustomServerPlugin: JavaPlugin() {

    companion object {
        var instance: CustomServerPlugin? = null;

        fun get(): CustomServerPlugin {
            return instance!!;
        }

        fun logger(): Logger {
            return Bukkit.getLogger();
        }
    }


    /**
     * Runs as soon as possible (other plugin's could be loaded or unloaded at this time)
     */
    override  fun onLoad() {
        StartupText.load();
        DemoFlag.onLoad();
        ZombieHordeFlag.onLoad();
    }

    /**
     * This happens after every plugin has been loaded
     */
    override fun onEnable() {
        StartupText.enable();
        CustomServerPlugin.instance = this;

        // Listeners
        Bukkit.getPluginManager().registerEvents(DeathEventListener, this)
        Bukkit.getPluginManager().registerEvents(MobSpawnListener, this)

        // Startup tasks
        RecipeManager.startup();

        Bukkit.getLogger().info("Config Val: ${config.getString("configVal") ?: "[no val listed]"}")
        Bukkit.getLogger().info("Enabled!")
    }


}