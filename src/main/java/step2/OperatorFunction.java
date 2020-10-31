package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorFunction {
    PLUS("+", (first, second) -> first + second),
    MINUS("-", (first, second) -> first - second),
    DIVIDE("/", (first, second) -> {
        if (second == 0) {
            throw new IllegalArgumentException(ErrorMessage.DO_NOT_DIVIDE_ZERO);
        }
        return first / second;
    }),
    MULTIPLY("*", (first, second) -> first * second);

    private final String value;
    private final BiFunction<Integer, Integer, Integer> operate;

    public static OperatorFunction of(String factor) {
        return Arrays.stream(values())
                .filter(v -> factor.equals(v.value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.IS_NOT_OPERATOR));
    }

    OperatorFunction(String value, BiFunction<Integer, Integer, Integer> operate) {
        this.value = value;
        this.operate = operate;
    }

    public int operate(Integer first, Integer second) {
        return this.operate.apply(first, second);
    }
}
