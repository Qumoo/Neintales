package at.qumo.neintales.internal.spigot;

import at.qumo.neintales.api.bridges.IPlaceholderBridge;
import at.qumo.neintales.implementation.spigot.NeintalesAPISpigot;
import at.qumo.neintales.implementation.spigot.bridges.PlaceholderBridgeSpigot;
import at.qumo.neintales.internal.api.APIRegistrationUtil;
import at.qumo.neintales.internal.spigot.loaders.PlaceholderAPILoaderSpigot;

public class SpigotMainLoader {

    private static SpigotMainLoader instance;

    private IPlaceholderBridge placeholderService;

    private SpigotMainLoader() {
    }

    public static SpigotMainLoader getInstance() {
        if(instance == null)
            instance = new SpigotMainLoader();
        return instance;
    }

    public void init() {
        APIRegistrationUtil.register(new NeintalesAPISpigot());
        placeholderService = new PlaceholderBridgeSpigot();
        PlaceholderAPILoaderSpigot.loadService();
    }

    public IPlaceholderBridge getPlaceholderService() {
        return placeholderService;
    }
}
