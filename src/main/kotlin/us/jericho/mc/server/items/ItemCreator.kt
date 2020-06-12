package us.jericho.mc.server.items

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
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
            this.material(mat)
        if(amount != null)
            this.amount(amount)
    }

    constructor(mat: String?, min: Int, max: Int) {
        if(mat != null)
            this.material(mat)
        this.amount(min, max)
    }

    /**
     * Material
     */
    fun material(mat: String): ItemCreator {
        this.material = Material.getMaterial(mat.toUpperCase())
        return this
    }

    fun material(mat: Material): ItemCreator {
        this.material = mat
        return this
    }

    fun amount(min: Int, max: Int): ItemCreator {
        val rand = Random()
        this.amount = rand.nextInt(max - min + 1) + min
        return this
    }

    fun amount(num: Int): ItemCreator {
        this.amount = num
        return this
    }

    open fun make(): ItemStack {
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