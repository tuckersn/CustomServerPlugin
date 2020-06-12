package us.jericho.mc.server.recipes

import org.bukkit.NamespacedKey
import org.bukkit.entity.Item
import org.bukkit.inventory.Recipe
import us.jericho.mc.server.CustomServerPlugin


abstract class RecipeBase {

    var namespace: NamespacedKey;
    var recipe: Recipe? = null;

    constructor(name: String) {
        this.namespace = NamespacedKey(CustomServerPlugin.instance!!, name);
    }

    abstract fun create(): Recipe;
}