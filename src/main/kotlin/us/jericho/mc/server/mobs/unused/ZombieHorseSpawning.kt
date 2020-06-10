package us.jericho.mc.server.mobs.unused

import org.bukkit.Material
import org.bukkit.attribute.Attributable
import org.bukkit.attribute.Attribute
import org.bukkit.block.Biome
import org.bukkit.entity.EntityType
import org.bukkit.entity.ZombieHorse
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.inventory.ItemStack

object ZombieHorseSpawning {

    fun onSkeletonSpawn(event: CreatureSpawnEvent) {
        if( event.location.blockY > 60 && event.location.blockY < 70 && event.location.block.biome == Biome.RIVER) {
            if(Math.random() < 0.0075) {
                event.entity.customName = "Skeleton Rider"
                val skeletonAttributable = event.entity as Attributable
                skeletonAttributable.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue = 40.00;
                event.entity.health = 40.00;

                // TODO: add enchanted apple drop below to an NBT tag from this event?

                var zombieHorse = event.location.world?.spawnEntity(event.location, EntityType.ZOMBIE_HORSE) as ZombieHorse;
                zombieHorse?.addPassenger(event.entity);
                val zombieHorseAttributable = zombieHorse as Attributable;
                zombieHorseAttributable.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)?.baseValue = 0.15;
                zombieHorseAttributable.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue = 40.00;
                zombieHorse.health = 40.00;
                zombieHorse.isTamed = true;
                zombieHorse.inventory.saddle = ItemStack(Material.SADDLE);
//                    if(Math.random() > 0.05) {
//                        zombieHorse.inventory.addItem(ItemStack(Material.ENCHANTED_GOLDEN_APPLE))
//                    } else {
//                        zombieHorse.inventory.addItem(ItemCreator("emerald", 4, 7).make())
//                    }
                // TODO: delete logic when unloaded from chunks unless ridden?
            }
        }
    }
}