package at.qumo.neintales.internal.api;

import at.qumo.neintales.api.INeintalesAPI;
import at.qumo.neintales.api.NeintalesAPIProvider;

import java.lang.reflect.Method;

public class APIRegistrationUtil {

    private static final Method REGISTER;
    private static final Method UNREGISTER;

    static {
        try {
            REGISTER = NeintalesAPIProvider.class.getDeclaredMethod("register", INeintalesAPI.class);
            REGISTER.setAccessible(true);

            UNREGISTER = NeintalesAPIProvider.class.getDeclaredMethod("unregister");
            UNREGISTER.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void register(INeintalesAPI service) {
        try {
            REGISTER.invoke(null, service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unregister() {
        try {
            UNREGISTER.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
