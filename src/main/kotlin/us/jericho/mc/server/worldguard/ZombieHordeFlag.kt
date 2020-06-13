package us.jericho.mc.server.worldguard

import com.sk89q.worldedit.bukkit.BukkitAdapter
import com.sk89q.worldedit.util.Location
import com.sk89q.worldguard.WorldGuard
import com.sk89q.worldguard.protection.association.RegionAssociable
import com.sk89q.worldguard.protection.flags.Flag
import com.sk89q.worldguard.protection.flags.StateFlag
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException
import com.sk89q.worldguard.protection.regions.RegionContainer
import org.bukkit.Bukkit
import org.bukkit.entity.EntityType
import org.bukkit.entity.Zombie
import org.bukkit.event.entity.CreatureSpawnEvent
import us.jericho.mc.server.CustomServerPlugin


object ZombieHordeFlag {

    var MY_CUSTOM_FLAG: StateFlag? = null

    /**
     * Is called on plugin.onLoad
     */
    fun onLoad() {

        val registry = WorldGuard.getInstance().flagRegistry
        try {
            val flag = StateFlag("custom-zombie-horde", true)
            registry.register(flag)
            MY_CUSTOM_FLAG = flag // only set our field if there was no error
        } catch (e: FlagConflictException) {
            // some other plugin registered a flag by the same name already.
            // you can use the existing flag, but this may cause conflicts - be sure to check type
            val existing: Flag<*>? = registry["custom-zombie-horde"]
            if (existing is StateFlag) {
                MY_CUSTOM_FLAG = existing as StateFlag?
            } else {
                // types don't match - this is bad news! some other plugin conflicts with you
                // hopefully this never actually happens
            }
        }

    }


    fun onMobSpawn(event: CreatureSpawnEvent): Boolean {
        var container = WorldGuard.getInstance().platform.regionContainer;
        var query = container.createQuery().getApplicableRegions(BukkitAdapter.adapt(event.location));


        for( r in query.regions) {
            if(r.flags.isNotEmpty()) {
                if(r.flags[this.MY_CUSTOM_FLAG].toString() == "ALLOW") {
                    when(event.entityType) {
                        EntityType.SPIDER, EntityType.CREEPER, EntityType.SKELETON -> {
                            event.isCancelled = true;
                            var zombie = event.location.world?.spawnEntity(event.location, EntityType.ZOMBIE) as Zombie;
                            if(Math.random() < 0.05) {
                                zombie.isBaby = true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}