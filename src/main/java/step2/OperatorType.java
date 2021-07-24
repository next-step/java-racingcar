package step2;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum OperatorType {
    PLUS("+", (first, second) -> first + second),
    MINUS("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> {
        if (second == 0) {
            throw new ArithmeticException("divide by zero");
        }
        return first / second;
    });

    private static final Map<String, OperatorType> operatorTypeMap =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(OperatorType::getSymbol, Function.identity())));

    private String symbol;

    private BinaryOperator<Integer> operator;

    OperatorType(String symbol, BinaryOperator<Integer> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static OperatorType find(String operator) {
        return Optional.ofNullable(operatorTypeMap.get(operator))
                .orElseThrow(IllegalArgumentException::new);
    }

    public int operate(int first, int second) {
        return operator.apply(first, second);
    }

    public String getSymbol() {
        return symbol;
    }
}
