package us.jericho.mc.server.drops

import org.bukkit.event.entity.EntityDeathEvent
import us.jericho.mc.server.items.ItemCreator
import us.jericho.mc.server.events.DeathEventHandler

class DeathDropHandler: DeathEventHandler {

    constructor(event: EntityDeathEvent) : super(event) {

        if(this.entityType == "COW") {

//            var item = ItemCreator("egg", 2, 5);
//            this.drops?.add(item.make());
        }
    }
}