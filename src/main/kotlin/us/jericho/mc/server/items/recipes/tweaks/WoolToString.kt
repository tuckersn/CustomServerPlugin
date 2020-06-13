package us.jericho.mc.server.items.recipes.tweaks

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.Recipe
import org.bukkit.inventory.ShapelessRecipe
import us.jericho.mc.server.items.recipes.RecipeBase

object WoolToString : RecipeBase("wool_to_string") {


    override fun create(): Recipe {
        this.recipe = ShapelessRecipe(this.namespace, ItemStack(Material.STRING, 4))
                .addIngredient(Material.WHITE_WOOL)

        return this.recipe!!;
    }



}