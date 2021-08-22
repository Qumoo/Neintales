package at.qumo.neintales.internal.sponge.loaders;

import me.rojo8399.placeholderapi.PlaceholderService;
import org.spongepowered.api.Sponge;

import java.util.Optional;

public class PlaceholderAPILoaderSponge {

    private static PlaceholderService service;
    private static boolean isLoaded;

    private PlaceholderAPILoaderSponge() {
    }

    /**
     * Tries loading the PlaceholderService and returns if it was successful or a failure
     *
     * @return PlaceholderService loaded successfully or not
     */
    public static void loadService() {
        Optional<PlaceholderService> optService = Sponge.getServiceManager().provide(PlaceholderService.class);
        if(optService.isPresent()) {
            service = optService.get();
            isLoaded = true;
        } else {
            isLoaded = false;
        }
    }

    /**
     * @return if the PlaceholderService is loaded or not
     */
    public static boolean isLoaded() {
        return isLoaded;
    }

    public static PlaceholderService getService() {
        return service;
    }
}
