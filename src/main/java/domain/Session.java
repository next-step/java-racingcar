package domain;

import java.util.HashMap;
import java.util.Map;

public class Session {
    private static Map<String, String> store = new HashMap<>();

    public static void put(String key, String value){
        store.put(key, value);
    }

    public static String get(String key){
        return store.get(key);
    }

    public static void clear(){
        store.clear();
    }
}
