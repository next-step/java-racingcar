package step02;

import java.util.Arrays;
import java.util.function.BiFunction;

enum OperationManager {
    SUM("+", (first, second) -> first + second),
    NUM("-", (first, second) -> first - second),
    MULTI("*", (first, second) -> first * second),
    DIV("/", (first, second) -> {
        if(second == 0) { throw new ArithmeticException(); }
        return first / second;
    });

    private BiFunction<Integer, Integer, Integer> inputData;
    private String symbol;

    OperationManager(String symbol, BiFunction<Integer, Integer, Integer> inputData) {
        this.symbol = symbol;
        this.inputData = inputData;

        if(inputData == null) {
            throw new IllegalArgumentException();
        }
    }

    public static int calculate(String symbol, int first, int second) {
        return getOperator(symbol).inputData.apply(first, second);
    }

    private static OperationManager getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.symbol.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다"));
    }
}

