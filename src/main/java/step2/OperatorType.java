package step2;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
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

    private IntBinaryOperator operator;

    OperatorType(String symbol, IntBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static int operate(int first, int second, String operator) {
        OperatorType operatorType = find(operator);
        return operatorType.operator.applyAsInt(first, second);
    }

    static OperatorType find(String operator) {
        return Optional.ofNullable(operatorTypeMap.get(operator))
                .orElseThrow(() -> new IllegalArgumentException("Operator를 찾을 수 없습니다."));
    }

    public String getSymbol() {
        return symbol;
    }
}
