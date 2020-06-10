package us.jericho.mc.server;

import org.bukkit.event.Event;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityEvent;

public class EventUtil {

    public static void cancel(CreatureSpawnEvent event) {
        event.setCancelled(true);
    }

    public static void uncancel(CreatureSpawnEvent event) {
        event.setCancelled(false);
    }
}
