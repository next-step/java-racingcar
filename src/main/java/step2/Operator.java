package step2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public enum Operator {

    PLUS("+", Operand::plus),
    MINUS("-", Operand::minus),
    TIMES("*", Operand::times),
    DIVISION("/", Operand::dividedBy);


    Operator(String op, BinaryOperator<Operand> bo) {
        this.op = op;
        this.bo = bo;
    }

    private final String op;
    private final BinaryOperator<Operand> bo;
    private static final Map<String, Operator> map;

    static {
        map = new HashMap<>();
        for (Operator o : Operator.values()) {
            map.put(o.op, o);
        }
    }

    Operand operate(Operand a, Operand b) {
        return bo.apply(a, b);

    }

    public static Operator from(String op) {
        if (!map.containsKey(op)) {
            throw new IllegalArgumentException();
        }
        return map.get(op);
    }

}
