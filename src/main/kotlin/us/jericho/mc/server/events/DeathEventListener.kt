package us.jericho.mc.server.events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import us.jericho.mc.server.drops.DeathDropHandler

object DeathEventListener: Listener {

    @EventHandler
    public fun onEntityDeath(event: EntityDeathEvent) {
        DeathDropHandler(event);
    }
}