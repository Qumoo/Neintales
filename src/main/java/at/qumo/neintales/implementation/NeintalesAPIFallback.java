package at.qumo.neintales.implementation;

import at.qumo.neintales.api.INeintalesAPI;
import at.qumo.neintales.api.bridges.IEconomyBridge;
import at.qumo.neintales.api.bridges.IPlaceholderBridge;

public class NeintalesAPIFallback implements INeintalesAPI {

    @Override
    public IPlaceholderBridge getPlaceholderBridge() {
        return null;
    }

    @Override
    public IEconomyBridge getEconomyBridge() {
        return null;
    }

}
