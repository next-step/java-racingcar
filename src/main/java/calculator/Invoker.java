package calculator;

import calculator.operation.*;

import java.util.HashMap;
import java.util.Map;

public class Invoker {

    private static Map<String, Operation> map = null;

    private Invoker() {}

    private static void createMap() {
        map = new HashMap<>();
        map.put( "+", new Add() );
        map.put( "-", new Subtract() );
        map.put( "*", new Multiply() );
        map.put( "/", new Divide() );
    }

    public static Operation getOperation(String operator) {
        if( map == null ) {
            createMap();
        }
        return map.get(operator);
    }

}
