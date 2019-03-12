package calculator;

import java.util.HashMap;
import java.util.Map;

public class Invoker {

    private static Map<String, Operation> map = null;

    private Invoker() {}

    private static void createMap() {
        map = new HashMap<>();
        map.put( "+", (a, b) -> a + b );
        map.put( "-", (a, b) -> a - b );
        map.put( "*", (a, b) -> a * b );
        map.put( "/", (a, b) -> a / b );
    }

    public static Operation getOperation(String operator) {
        if( map == null ) {
            createMap();
        }
        return map.get(operator);
    }

}
