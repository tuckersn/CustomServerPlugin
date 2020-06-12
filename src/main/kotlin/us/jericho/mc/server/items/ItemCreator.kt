package us.jericho.mc.server.items

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import us.jericho.mc.server.CustomServerPlugin
import java.util.*

open class ItemCreator {

    // Created when make() is called
    var stack: ItemStack? = null;
    var meta: ItemMeta? = null;

    var material: Material? = null
    var amount = 1

    constructor()

    constructor(mat: String?, amount: Int?) {
        if(mat != null)
            this.setMaterial(mat)
        if(amount != null)
            this.setAmount(amount)
    }

    constructor(mat: String?, min: Int, max: Int) {
        if(mat != null)
            this.setMaterial(mat)
        this.randomAmount(min, max)
    }

    fun setMaterial(mat: String): ItemCreator {
        this.material = Material.getMaterial(mat.toUpperCase())
        return this
    }

    fun setMaterial(mat: Material): ItemCreator {
        this.material = mat
        return this
    }

    fun randomAmount(min: Int, max: Int): ItemCreator {
        val rand = Random()
        this.amount = rand.nextInt(max - min + 1) + min
        return this
    }

    fun setAmount(num: Int): ItemCreator {
        this.amount = num
        return this
    }

    fun make(): ItemStack {
        this.stack = ItemStack(this.material!!, this.amount)
        this.meta = this.stack?.itemMeta;

        this.addAttributes();

        return this.stack!!;
    }

    /**
     * To be oreridden
     */
    open fun addAttributes() {
        Bukkit.broadcastMessage("Oh shit")
    }
}