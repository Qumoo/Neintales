package at.qumo.neintales;

import at.qumo.neintales.implementation.NeintalesAPIFallback;
import at.qumo.neintales.internal.api.APIRegistrationUtil;
import at.qumo.neintales.internal.enums.ServerSystems;
import at.qumo.neintales.internal.spigot.SpigotMainLoader;
import at.qumo.neintales.internal.sponge.SpongeMainLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = Neintales.MOD_ID,
        name = Neintales.MOD_NAME,
        version = Neintales.VERSION,
        acceptableRemoteVersions = "*"
)
public class Neintales {

    public static final String MOD_ID = "neintales";
    public static final String MOD_NAME = "Neintales";
    public static final String VERSION = "@VERSION@";

    @Mod.Instance(MOD_ID)
    public static Neintales INSTANCE;

    private Logger logger;
    private ServerSystems serverSystem;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        serverSystem = defineServerSystem();
    }

    @Mod.EventHandler
    public void enable(FMLServerStartingEvent event) {
        logger.info("Detected ServerSystem: " + serverSystem);
        if(serverSystem == ServerSystems.SPONGE) {
            logger.info("Init: SpongeMainLoader");
            SpongeMainLoader.getInstance().init();
        } else if(serverSystem == ServerSystems.MAGMA) {
            SpigotMainLoader.getInstance().init();
        } else if(serverSystem == ServerSystems.UNKNOWN) {
            APIRegistrationUtil.register(new NeintalesAPIFallback());
        }
    }

    @Mod.EventHandler
    public void disable(FMLServerStoppingEvent event) {

    }

    public Logger getLogger() {
        return logger;
    }

    public ServerSystems getServerSystem() {
        return serverSystem;
    }

    private ServerSystems defineServerSystem() {
        try {
            //Check if the server runs sponge
            Class.forName("org.spongepowered.api.Sponge");
            return ServerSystems.SPONGE;
        } catch(Exception ignored1) {
            try {
                //Check if the server runs magma
                Class.forName("org.magmafoundation.magma.Magma");
                return ServerSystems.MAGMA;
            } catch(Exception ignored2) {
                try {
                    //Check if the server runs mohist
                    Class.forName("com.mohistmc.MohistMC");
                    return ServerSystems.MOHIST;
                } catch(Exception ignored3) {
                    return ServerSystems.UNKNOWN;
                }
            }
        }
    }
}
