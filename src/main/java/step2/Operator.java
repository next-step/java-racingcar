package step2;

import java.util.HashMap;
import java.util.Map;

public enum Operator {

    PLUS("+") {
        int operate(int a, int b) {
            return a + b;
        }

    }, MINUS("-") {
        int operate(int a, int b) {
            return a - b;
        }

    }, TIMES("*") {
        int operate(int a, int b) {
            return a * b;
        }

    }, DIVISION("/") {
        int operate(int a, int b) {
            return a / b;
        }

    };

    Operator(String op) {
        this.op = op;
    }

    private final String op;
    private static final Map<String, Operator> map;

    static {
        map = new HashMap<>();
        for (Operator o : Operator.values()) {
            map.put(o.op, o);
        }
    }

    abstract int operate(int a, int b);

    public static Operator from(String op) {
        if (!map.containsKey(op)) throw new IllegalArgumentException();
        return map.get(op);
    }

}
