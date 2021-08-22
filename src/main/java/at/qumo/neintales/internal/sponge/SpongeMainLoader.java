package at.qumo.neintales.internal.sponge;

import at.qumo.neintales.api.bridges.IEconomyBridge;
import at.qumo.neintales.api.bridges.IPlaceholderBridge;
import at.qumo.neintales.implementation.sponge.NeintalesAPISponge;
import at.qumo.neintales.implementation.sponge.bridges.EconomyBridgeSponge;
import at.qumo.neintales.implementation.sponge.bridges.PlaceholderBridgeSponge;
import at.qumo.neintales.internal.api.APIRegistrationUtil;
import at.qumo.neintales.internal.sponge.loaders.EconomyLoaderSponge;
import at.qumo.neintales.internal.sponge.loaders.PlaceholderAPILoaderSponge;

public class SpongeMainLoader {

    private static SpongeMainLoader instance;
    private IPlaceholderBridge placeholderService;
    private IEconomyBridge economyBridge;

    private SpongeMainLoader() {
    }

    public static SpongeMainLoader getInstance() {
        if(instance == null)
            instance = new SpongeMainLoader();
        return instance;
    }

    public void init() {
        APIRegistrationUtil.register(new NeintalesAPISponge());
        //Loading PlaceholderAPI
        PlaceholderAPILoaderSponge.loadService();
        placeholderService = new PlaceholderBridgeSponge();
        //Loading EconomyService
        EconomyLoaderSponge.loadService();
        economyBridge = new EconomyBridgeSponge();
    }

    public IPlaceholderBridge getPlaceholderService() {
        return placeholderService;
    }

    public IEconomyBridge getEconomyBridge() {
        return economyBridge;
    }
}
