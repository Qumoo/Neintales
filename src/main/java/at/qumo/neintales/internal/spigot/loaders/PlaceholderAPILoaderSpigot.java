package at.qumo.neintales.internal.spigot.loaders;

import org.magmafoundation.magma.api.ServerAPI;

public class PlaceholderAPILoaderSpigot {

    private static boolean isLoaded;

    private PlaceholderAPILoaderSpigot() {

    }

    public static void loadService() {
        isLoaded = ServerAPI.getCBServer().getPluginManager().getPlugin("PlaceholderAPI") != null;
    }

    /**
     * @return if the PlaceholderService is loaded or not
     */
    public static boolean isLoaded() {
        return isLoaded;
    }
}
