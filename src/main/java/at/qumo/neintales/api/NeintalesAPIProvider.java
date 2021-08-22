package at.qumo.neintales.api;

public class NeintalesAPIProvider {

    private static INeintalesAPI instance;

    public static INeintalesAPI get() {
        if(instance == null) {
            throw new IllegalStateException("Neintales API not loaded");
        }
        return instance;
    }

    static void register(INeintalesAPI api) {
        instance = api;
    }

    static void unregister() {
        instance = null;
    }

    private NeintalesAPIProvider() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

}
