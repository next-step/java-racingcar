package step2;

import java.util.Objects;
import java.util.function.BiFunction;

import static java.lang.String.format;
import static java.util.Arrays.stream;

public enum Operator {
    PLUS("+", (leftNum, rightNum) -> leftNum + rightNum),
    MINUS("-", (leftNum, rightNum) -> leftNum - rightNum),
    MULTIPLY("*", (leftNum, rightNum) -> leftNum * rightNum),
    DIVIDE("/", (leftNum, rightNum) -> leftNum / rightNum);

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

    public int operate(int leftNum, int rightNum) {
        return operate.apply(leftNum, rightNum);
    }
}
