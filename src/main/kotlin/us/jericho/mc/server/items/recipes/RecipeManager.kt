package us.jericho.mc.server.items.recipes

import org.bukkit.Bukkit
import us.jericho.mc.server.CustomServerPlugin
import us.jericho.mc.server.items.recipes.tweaks.WoolToString


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