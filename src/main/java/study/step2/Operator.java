package study.step2;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public enum Operator {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String symbol;
    private final BinaryOperator<Integer> operator;

    Operator(String symbol, BinaryOperator<Integer> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public String getSymbol() {
        return symbol;
    }

    public int calculate(int a, int b) {
        return operator.apply(a, b);
    }

    public static Map<String, Operator> getOperatorMap() {
        return Arrays.stream(Operator.values())
                .collect(Collectors.toMap(Operator::getSymbol, operator -> operator));
    }
}
