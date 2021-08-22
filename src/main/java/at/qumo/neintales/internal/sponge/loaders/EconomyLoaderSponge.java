package at.qumo.neintales.internal.sponge.loaders;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.service.economy.EconomyService;

import java.util.Optional;

public class EconomyLoaderSponge {

    private static EconomyService service;
    private static boolean isLoaded;

    private EconomyLoaderSponge() {
    }

    /**
     * Tries loading the EconomyService and returns if it was successful or a failure
     *
     * @return EconomyService loaded successfully or not
     */
    public static void loadService() {
        Optional<EconomyService> optService = Sponge.getServiceManager().provide(EconomyService.class);
        if(optService.isPresent()) {
            service = optService.get();
            isLoaded = true;
        } else {
            isLoaded = false;
        }
    }

    /**
     * @return if the EconomyService is loaded or not
     */
    public static boolean isLoaded() {
        return isLoaded;
    }

    public static EconomyService getService() {
        return service;
    }

}
