package step2;

import java.util.Objects;
import java.util.function.BiFunction;

import static java.lang.String.format;
import static java.util.Arrays.stream;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String strOperator;
    private final BiFunction<Integer, Integer, Integer> operate;

    Operator(String strOperator, BiFunction<Integer, Integer, Integer> operate) {
        this.strOperator = strOperator;
        this.operate = operate;
    }

    public static Operator from(String strOperator) {
        return stream(values())
                .filter(op -> Objects.equals(strOperator, op.strOperator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(format("지원하지않는 연산자입니다. input: %s", strOperator)));
    }

    public static boolean isSupport(String source) {
        return stream(values())
                .map(operator -> operator.strOperator)
                .anyMatch(operator -> operator.equals(source));
    }

    public int operate(int a, int b) {
        return operate.apply(a, b);
    }
}
