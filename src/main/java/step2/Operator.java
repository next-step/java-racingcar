package step2;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public enum Operator {
    PLUS("+", (value1, value2) -> value1 + value2),
    MINUS("-", (value1, value2) -> value1 - value2),
    MULTIPLY("*", (value1, value2) -> value1 * value2),
    DIVIDE("/", (value1, value2) -> value1 / value2);

    private final String name;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String name, BiFunction<Integer, Integer, Integer> expression) {
        this.name = name;
        this.expression = expression;
    }

    public static Operator getOperator(String operatorName) {
        return getOperatorsByName(operatorName).get(0);
    }

    public static void validateOperator(String operatorName) {
        List<Operator> operators = getOperatorsByName(operatorName);
        if (operators.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Operator> getOperatorsByName(String operatorName) {
        return Arrays.stream(Operator.values())
            .filter(op -> op.compareName(operatorName))
            .collect(Collectors.toList());
    }

    public int calculate(int value1, int value2) {
        return expression.apply(value1, value2);
    }

    private boolean compareName(String operatorName) {
        return this.name.compareTo(operatorName) == 0;
    }
}
