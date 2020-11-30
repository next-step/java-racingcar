package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (x, y) -> x - y),
    MULTIPLE("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private static final String IS_NOT_OPERATOR = "계산 부호 오류입니다.";

    private final String sign;
    private final BiFunction<Integer, Integer, Integer> operationFunction;

    private static final Map<String, Operator> valuesMap =
            Collections.unmodifiableMap(Arrays.stream(Operator.values())
                    .collect(Collectors.toMap(operator -> operator.sign, Function.identity())));

    public static Operator getOperator(String symbol) {
        return Optional.ofNullable(valuesMap.get(symbol))
                .orElseThrow(() -> new IllegalArgumentException(IS_NOT_OPERATOR));
    }

    Operator(String sign, BiFunction<Integer, Integer, Integer> operationFunction) {
        this.sign = sign;
        this.operationFunction = operationFunction;
    }

    public int calculate(int num1, int num2) {
        return operationFunction.apply(num1, num2);
    }
}
