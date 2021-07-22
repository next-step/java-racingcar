package stage2.stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum ArithmeticOperation {
    ADDITION("+", Integer::sum),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private final String label;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    ArithmeticOperation(String label, BiFunction<Integer, Integer, Integer> biFunction) {
        this.label = label;
        this.biFunction = biFunction;
    }

    static public ArithmeticOperation arithmetic(String label) {
        System.out.println("산술연산자 : " + label);
        System.out.println();

        return Arrays.stream(values())
                .filter(operation -> operation.label.equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int calculation(int a, int b) {
        return biFunction.apply(a, b);
    }
}
