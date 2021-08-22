package at.qumo.neintales.implementation.sponge;

import at.qumo.neintales.api.INeintalesAPI;
import at.qumo.neintales.api.bridges.IEconomyBridge;
import at.qumo.neintales.api.bridges.IPlaceholderBridge;
import at.qumo.neintales.internal.sponge.SpongeMainLoader;

public class NeintalesAPISponge implements INeintalesAPI {

    @Override
    public IPlaceholderBridge getPlaceholderBridge() {
        return SpongeMainLoader.getInstance().getPlaceholderService();
    }

    @Override
    public IEconomyBridge getEconomyBridge() {
        return SpongeMainLoader.getInstance().getEconomyBridge();
    }

}
