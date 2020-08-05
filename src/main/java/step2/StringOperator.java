package step2;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public enum StringOperator {

    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE(("/"), (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by 0.");
        }
        return a / b;
    });

    private String operator;
    private BinaryOperator<Integer> function;

    StringOperator(String operator, BinaryOperator<Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public static StringOperator of(String operator) {
        Optional<StringOperator> so = Arrays.stream(StringOperator.values())
            .filter(stringOperator -> stringOperator.operator.equals(operator))
            .findFirst();
        return so.orElseThrow(() -> new IllegalArgumentException(
            "Possible operators are [" + Arrays.stream(StringOperator.values())
                .map(o -> o.operator)
                .collect(Collectors.toList()) + "]"));
    }

    public int calculate(int a, int b) {
        return this.function.apply(a, b);
    }
}
