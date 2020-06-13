package us.jericho.mc.server

object StartupText {


    fun load() {
        CustomServerPlugin.logger().info("\n   __   ____  ___   ___ \n" +
                "  / /  / __ \\/ _ | / _ \\\n" +
                " / /__/ /_/ / __ |/ // /\n" +
                "/____/\\____/_/ |_/____/ \n" +
                "                        ");
    }

    fun enable() {
        CustomServerPlugin.logger().info("\n   _____  _____   ___  __   ____\n" +
                "  / __/ |/ / _ | / _ )/ /  / __/\n" +
                " / _//    / __ |/ _  / /__/ _/  \n" +
                "/___/_/|_/_/ |_/____/____/___/  \n" +
                "                                ")
    }
}