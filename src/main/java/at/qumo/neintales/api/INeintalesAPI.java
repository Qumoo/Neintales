package at.qumo.neintales.api;

import at.qumo.neintales.api.bridges.IEconomyBridge;
import at.qumo.neintales.api.bridges.IPlaceholderBridge;

public interface INeintalesAPI {

    IPlaceholderBridge getPlaceholderBridge();

    IEconomyBridge getEconomyBridge();

}
