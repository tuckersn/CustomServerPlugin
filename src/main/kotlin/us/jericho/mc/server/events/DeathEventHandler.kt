package us.jericho.mc.server.events

import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.inventory.ItemStack


abstract  class DeathEventHandler {

    protected var event: EntityDeathEvent? = null
    var entityType: String? = null
    var drops: MutableList<ItemStack>? = null


    constructor(event: EntityDeathEvent) {
        this.event = event
        entityType = event.entityType.toString()
        drops = event.drops
    }

}