package at.qumo.neintales.implementation.sponge.bridges;

import at.qumo.neintales.api.bridges.IPlaceholderBridge;
import at.qumo.neintales.internal.LogUtils;
import at.qumo.neintales.internal.sponge.loaders.PlaceholderAPILoaderSponge;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.api.text.Text;

public class PlaceholderBridgeSponge implements IPlaceholderBridge {

    @Override
    public String parsePlaceholder(EntityPlayerMP player, String text) {
        if(PlaceholderAPILoaderSponge.isLoaded()) {
            Text out = PlaceholderAPILoaderSponge.getService().replacePlaceholders(text, player, player);
            return out.toPlain();
        } else {
            LogUtils.error("PlaceholderAPI not loaded/found.");
            return text;
        }
    }

}
