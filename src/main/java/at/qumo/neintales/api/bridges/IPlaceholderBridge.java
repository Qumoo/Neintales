package at.qumo.neintales.api.bridges;

import net.minecraft.entity.player.EntityPlayerMP;

public interface IPlaceholderBridge {

    /**
     * Parses the placeholders in the text argument for the player player.
     *
     * @param player The player the placeholders should apply to
     * @param text the text with the placeholders
     *
     * @return text with replaced placeholders
     */
    String parsePlaceholder(EntityPlayerMP player, String text);

}
