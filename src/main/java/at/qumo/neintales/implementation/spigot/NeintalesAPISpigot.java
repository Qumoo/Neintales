package at.qumo.neintales.implementation.spigot;

import at.qumo.neintales.api.INeintalesAPI;
import at.qumo.neintales.api.bridges.IEconomyBridge;
import at.qumo.neintales.api.bridges.IPlaceholderBridge;
import at.qumo.neintales.internal.spigot.SpigotMainLoader;

public class NeintalesAPISpigot implements INeintalesAPI {

    @Override
    public IPlaceholderBridge getPlaceholderBridge() {
        return SpigotMainLoader.getInstance().getPlaceholderService();
    }

    @Override
    public IEconomyBridge getEconomyBridge() {
        return null;
    }
}
