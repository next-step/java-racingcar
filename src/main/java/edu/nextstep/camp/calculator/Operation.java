package edu.nextstep.camp.calculator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

enum Operation {
    ADDITION("+", Number::add),
    SUBTRACTION("-", Number::subtract),
    PRODUCTION("*", Number::product),
    DIVISION("/", Number::divide);

    private final String operator;
    private final BiFunction<Number, Number, Number> operate;

    Operation(final String operator, BiFunction<Number, Number, Number> operate) {
        this.operator = operator;
        this.operate = operate;
    }

    public Number operate(Number first, Number second) {
        return operate.apply(first, second);
    }

    private final static Map<String, Operation> valueMap = new ConcurrentHashMap<>();

    static {
        for (Operation op : Operation.values()) {
            valueMap.put(op.operator, op);
        }
    }

    public static Operation of(String operator) {
        if (operator == null || !valueMap.containsKey(operator))
            throw new IllegalArgumentException("invalid operator:" + operator);

        return valueMap.get(operator);
    }
}
