package us.jericho.mc.server.recipes.tweaks

import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.Recipe
import org.bukkit.inventory.ShapelessRecipe
import org.bukkit.plugin.Plugin
import us.jericho.mc.server.CustomServerPlugin
import us.jericho.mc.server.recipes.RecipeBase

object WoolToString : RecipeBase("wool_to_string") {


    override fun create(): Recipe {
        this.recipe = ShapelessRecipe(this.namespace, ItemStack(Material.STRING, 4))
                .addIngredient(Material.WHITE_WOOL)

        return this.recipe!!;
    }



}