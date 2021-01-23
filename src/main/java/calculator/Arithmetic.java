package calculator;

import java.util.Map;
import java.util.HashMap;
import java.util.function.BiFunction;

public class Arithmetic {

    private static final Map<String, BiFunction<Double, Double, Double>> operations = new HashMap<>();

    static {
        operations.put("+", Double::sum);
        operations.put("-", (num1, num2) -> num1 - num2);
        operations.put("*", (num1, num2) -> num1 * num2);
        operations.put("/", (num1, num2) -> {
            if (!isBaseZero(num2)) {
                return num1 / num2;
            }
            throw new IllegalArgumentException("분모가 0이 되면 안됩니다.");
        });
    }

    private static boolean isBaseZero(double num) {
        return num == 0;
    }

    public static double calculate(String operator, double num1, double num2) {
        return operations.get(operator).apply(num1, num2);
    }

}
