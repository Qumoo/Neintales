package at.qumo.neintales.internal;


public class CommonLoader {

    private static CommonLoader instance;

    public static CommonLoader getInstance() {
        if(instance == null)
            instance = new CommonLoader();
        return instance;
    }

}
