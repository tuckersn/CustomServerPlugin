package us.jericho.mc.server.recipes

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.plugin.Plugin
import us.jericho.mc.server.CustomServerPlugin
import us.jericho.mc.server.recipes.tweaks.WoolToString


object RecipeManager {


    fun startup() {
        this.addRecipe(WoolToString)

//        val key = NamespacedKey(CustomServerPlugin.instance!!, "emerald_sword")
//        val sword = ItemStack(Material.DIAMOND_SWORD)
//        val recipe = ShapedRecipe(sword)
//        recipe.shape(" E ", " E ", " S ")
//        recipe.setIngredient('E', Material.EMERALD)
//        recipe.setIngredient('S', Material.STICK)
//        Bukkit.addRecipe(recipe)
    }

    fun addRecipe(recipe: RecipeBase) {
        CustomServerPlugin.logger().info("Creating recipe'" + recipe.namespace + "'")
        Bukkit.addRecipe(recipe.create());
    }
}