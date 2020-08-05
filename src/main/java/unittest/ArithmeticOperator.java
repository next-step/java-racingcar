package unittest;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum ArithmeticOperator {

    ADD_OPERATOR("+", (a, b) -> a + b),
    SUBSTRACT_OPERATOR("-", (a, b) -> a - b),
    MULTIPLY_OPERATOR("*", ( a, b) -> a * b),
    DIVIDE_OPERATOR("/", (a, b) -> a / b);

    String operator;
    BiFunction<Integer, Integer, Integer> expression;


    ArithmeticOperator(String operater, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operater;
        this.expression = expression;
    }

    public int calculate(int a, int b) {
        return expression.apply(a, b);
    }

    public static ArithmeticOperator getOperator(String inputOperator) {
        return Arrays.stream(ArithmeticOperator.values())
                .filter(value -> value.operator.equals(inputOperator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }


}
