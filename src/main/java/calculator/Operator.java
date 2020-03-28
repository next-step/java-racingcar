package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

import static calculator.NumberParser.checkMathOperator;

public enum Operator {

    ADDITION("+", (x, y) -> x + y),
    SUBTRACTION("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) ->   x / y);

    private String value;
    private BiFunction<Long, Long, Long> operator;

    Operator(String value, BiFunction<Long, Long, Long> operator) {
        this.value = value;
        this.operator = operator;
    }

    static Operator findOperator(String input) {
        checkMathOperator(input);

        return Arrays.stream(Operator.values())
                .filter(operator -> operator.value.equals(input))
                .findAny().orElseThrow(() -> new IllegalArgumentException("연산자가 아닙니다."));
    }

    public long calculate(long x, long y) {
        return operator.apply(x, y);
    }
}
