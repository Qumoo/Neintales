package at.qumo.neintales.implementation.spigot.bridges;

import at.qumo.neintales.api.bridges.IEconomyBridge;
import net.minecraft.entity.player.EntityPlayerMP;

public class EconomyBridgeSpigot implements IEconomyBridge {
    @Override
    public boolean withdraw(EntityPlayerMP player, double amount) {
        return false;
    }

    @Override
    public boolean deposit(EntityPlayerMP player, double amount) {
        return false;
    }

    @Override
    public boolean has(EntityPlayerMP player, double amount) {
        return false;
    }

    @Override
    public double getBalance(EntityPlayerMP player) {
        return 0;
    }
}
