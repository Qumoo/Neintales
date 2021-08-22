package at.qumo.neintales.implementation.sponge.bridges;

import at.qumo.neintales.api.bridges.IEconomyBridge;
import at.qumo.neintales.internal.sponge.loaders.EconomyLoaderSponge;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.service.economy.EconomyService;
import org.spongepowered.api.service.economy.account.UniqueAccount;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public class EconomyBridgeSponge implements IEconomyBridge {

    EconomyService economyService = EconomyLoaderSponge.getService();

    @Override
    public boolean withdraw(EntityPlayerMP player, double amount) {
        Optional<UniqueAccount> accOpt = getAccount(player.func_110124_au());
        if(!(accOpt).isPresent())
            return false;
        if(has(player, amount)) {
            accOpt.get().withdraw(economyService.getDefaultCurrency(), BigDecimal.valueOf(amount), Cause.builder().build(EventContext.empty()));
            return true;
        }
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

    private Optional<UniqueAccount> getAccount(UUID uuid) {
        if(economyService == null)
            return Optional.empty();
        return economyService.getOrCreateAccount(uuid);
    }
}
