package study.step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum StringOperator {

    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLE("*", (operand1, operand2) -> operand1 * operand2),
    DIVISION("/", (operand1, operand2) -> operand1 / operand2);

    private final String symbol;
    private BiFunction<Long, Long, Long> expression;

    StringOperator(String symbol, BiFunction<Long, Long, Long> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static StringOperator symbol(String symbol) {
        return Arrays.stream(StringOperator.values())
                .filter(o -> o.symbol.equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("처리할 수 없는 연산자입니다. '" + symbol + "'"));
    }

    public long calculate(long operand1, long operand2) {
        return expression.apply(operand1, operand2);
    }

}
