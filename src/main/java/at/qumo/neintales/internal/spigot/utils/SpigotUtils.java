package at.qumo.neintales.internal.spigot.utils;

import net.minecraft.entity.player.EntityPlayerMP;
import org.bukkit.entity.Player;
import org.magmafoundation.magma.api.PlayerAPI;

public class SpigotUtils {

    public static Player forgeToBukkitPlayer(EntityPlayerMP player) {
        return PlayerAPI.getCBPlayer(player);
    }

}
