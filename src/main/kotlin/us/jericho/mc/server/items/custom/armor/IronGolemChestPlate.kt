package us.jericho.mc.server.items.custom.armor

import org.bukkit.Material
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.inventory.EquipmentSlot
import us.jericho.mc.server.items.ItemCreator
import java.util.*

class IronGolemChestPlate : ItemCreator {

    constructor() : super() {
        this.setMaterial(Material.IRON_CHESTPLATE);
        this.setAmount(1);
    }


    override fun addAttributes() {
        this.meta?.setDisplayName("§eIron Golem Chestplate")
        this.meta?.setCustomModelData(2)
        this.meta?.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, AttributeModifier(UUID.randomUUID(), "Damage", 5.00, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST));
        this.meta?.addAttributeModifier(Attribute.GENERIC_ARMOR, AttributeModifier(UUID.randomUUID(), "Armor", 6.00, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST));
        this.stack?.itemMeta = this.meta;
    }
}