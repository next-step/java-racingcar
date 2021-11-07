package step2;

import java.util.HashMap;
import java.util.Map;

public enum Operation {

    PLUS("+") {
        int apply(int a, int b) {
            return a + b;
        }

    }, MINUS("-") {
        int apply(int a, int b) {
            return a - b;
        }

    }, TIMES("*") {
        int apply(int a, int b) {
            return a * b;
        }

    }, DIVISION("/") {
        int apply(int a, int b) {
            return a / b;
        }

    };
    private final String op;

    Operation(String op) {
        this.op = op;
    }

    private static final Map<String, Operation> map = new HashMap<>();
    static{
        for(Operation o : Operation.values()){
            map.put(o.op, o);
        }
    }

    abstract int apply(int a, int b);

    public static Operation from(String op) {
        if(!map.containsKey(op)) throw new IllegalArgumentException();
        return map.get(op);
    }

}
