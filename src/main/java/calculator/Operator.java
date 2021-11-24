package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Number::plus),
    MINUS("-", Number::minus),
    MULTIPLY("*", Number::multiply),
    DIVIDE("/", Number::divide);

    private final String value;
    private final BiFunction<Number, Number, Number> function;
    public static final Map<String, Operator> operatorMap = new HashMap<>();

    Operator(String value, BiFunction<Number, Number, Number> function) {
        this.value = value;
        this.function = function;
    }

    static {
        Operator[] operators = values();

        for (Operator operator : operators) {
            operatorMap.put(operator.value, operator);
        }
    }

    public static boolean contains(String value) {
        return operatorMap.containsKey(value);
    }

    public static Operator of(String value) {
        return operatorMap.get(value);
    }

    public Number execute(Number number1, Number number2) {
        return function.apply(number1, number2);
    }
}
