package at.qumo.neintales.implementation.spigot.bridges;

import at.qumo.neintales.api.bridges.IPlaceholderBridge;
import at.qumo.neintales.internal.LogUtils;
import at.qumo.neintales.internal.spigot.loaders.PlaceholderAPILoaderSpigot;
import at.qumo.neintales.internal.spigot.utils.SpigotUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import net.minecraft.entity.player.EntityPlayerMP;

public class PlaceholderBridgeSpigot implements IPlaceholderBridge {

    @Override
    public String parsePlaceholder(EntityPlayerMP player, String text) {
        if(PlaceholderAPILoaderSpigot.isLoaded())
            return PlaceholderAPI.setPlaceholders(SpigotUtils.forgeToBukkitPlayer(player), text);
        else {
            LogUtils.error("PlaceholderAPI not loaded/found.");
            return text;
        }
    }

}
