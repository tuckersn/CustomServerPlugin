package us.jericho.mc.server.worldguard

import com.sk89q.worldguard.WorldGuard
import com.sk89q.worldguard.protection.flags.Flag
import com.sk89q.worldguard.protection.flags.StateFlag
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException


object DemoFlag {

    var MY_CUSTOM_FLAG: StateFlag? = null

    /**
     * Is called on plugin.onLoad
     */
    fun onLoad() {
        val registry = WorldGuard.getInstance().flagRegistry
        try {
            // create a flag with the name "my-custom-flag", defaulting to true
            val flag = StateFlag("my-custom-flag", true)
            registry.register(flag)
            MY_CUSTOM_FLAG = flag // only set our field if there was no error
        } catch (e: FlagConflictException) {
            // some other plugin registered a flag by the same name already.
            // you can use the existing flag, but this may cause conflicts - be sure to check type
            val existing: Flag<*>? = registry["my-custom-flag"]
            if (existing is StateFlag) {
                MY_CUSTOM_FLAG = existing as StateFlag?
            } else {
                // types don't match - this is bad news! some other plugin conflicts with you
                // hopefully this never actually happens
            }
        }
    }
}