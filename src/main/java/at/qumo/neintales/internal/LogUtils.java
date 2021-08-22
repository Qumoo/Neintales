package at.qumo.neintales.internal;

import at.qumo.neintales.Neintales;

public class LogUtils {

    private static final String prefix = "[Neintales] ";

    public static void error(String msg) {
        Neintales.INSTANCE.getLogger().error(prefix + msg);
    }

    public static void info(String msg) {
        Neintales.INSTANCE.getLogger().info(prefix + msg);
    }
}
