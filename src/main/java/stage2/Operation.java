package stage2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    ADD("+", ((first, second) -> first + second)),
    MINUS("-", ((first, second) -> first - second)),
    MULTI("*", ((first, second) -> first * second)),
    DIVIDE("/", ((first, second) -> first / second));

    private final String value;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operation(String value, BiFunction<Integer, Integer, Integer> expression) {
        this.value = value;
        this.expression = expression;
    }

    public Integer operate(Integer first, Integer second) {
        return expression.apply(first, second);
    }

    public static Operation findOperation(String input) {
        return Arrays.stream(Operation.values())
                .filter(i -> i.value.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자 입니다. => " + input));
    }

}
