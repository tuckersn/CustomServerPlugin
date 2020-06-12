package us.jericho.mc.server.events

//import us.jericho.mc.server.EventUtil
import org.bukkit.Material
import org.bukkit.attribute.Attributable
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeInstance
import org.bukkit.block.Biome
import org.bukkit.entity.*
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.inventory.ItemStack
import us.jericho.mc.server.CustomServerPlugin
import us.jericho.mc.server.items.ItemCreator
import us.jericho.mc.server.mobs.unused.ZombieHorseSpawning


object MobSpawnListener : Listener {

    @EventHandler
    public fun onCreatureSpawn(event: CreatureSpawnEvent) {

        if(event.spawnReason == CreatureSpawnEvent.SpawnReason.NATURAL || event.spawnReason == CreatureSpawnEvent.SpawnReason.SPAWNER_EGG) {

            if(event.entityType == EntityType.SKELETON) {
                ZombieHorseSpawning.onSkeletonSpawn(event)
            }

        } else if (event.spawnReason == CreatureSpawnEvent.SpawnReason.BREEDING) {
            /**
             * Chance to get twin Mooshrooms from breeding cows
             */
            if(event.entityType == EntityType.COW) {
                var randn = Math.random();
                if(randn < 0.005) {
                    CustomServerPlugin.logger().info("MOOSHROOM FROM BREEDING: " + randn)
                    event.isCancelled = true;

                    repeat(2) {
                        var mooshroom: MushroomCow = event.location.world?.spawnEntity(event.location, EntityType.MUSHROOM_COW) as MushroomCow;
                        mooshroom.setBaby();
                    }
                }
            }
        }

    }

}