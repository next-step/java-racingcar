package StringCalculator.Enum;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    ADD("+", (x, y) -> (x + y)),
    SUBTRACT("-", (x, y) -> (x - y)),
    MULTIPLY("*", (x, y) -> (x * y)),
    DIVIDE("/", (x, y) -> (x / y));

    private final String title;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    public static Operation find(String operation) {
        return Arrays.stream(values())
                .filter(value -> value.getTitle().equals(operation))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int apply(int leftTerm, int rightTerm) {
        return this.biFunction.apply(leftTerm, rightTerm);
    }

    Operation(String operation, BiFunction<Integer, Integer, Integer> biFunction) {
        this.title = operation;
        this.biFunction = biFunction;
    }

    public String getTitle() {
        return this.title;
    }

}
