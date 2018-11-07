package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class CalculatorBackup {
    private int calculate(int first, String expression, int second) {
        if (expression.equals("+")) {
            return first + second;
        }

        if (expression.equals("-")) {
            return first - second;
        }

        if (expression.equals("*")) {
            return first * second;
        }

        if (expression.equals("/")) {
            return first / second;
        }

        return 0;
    }

    private static Map<String, BiFunction<Integer, Integer, Integer>> operators = new HashMap<>();
    static {
        operators.put("+", new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer first, Integer second) {
                return first + second;
            }
        });
        operators.put("-", new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer first, Integer second) {
                return first - second;
            }
        });
        operators.put("*", new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer first, Integer second) {
                return first * second;
            }
        });
        operators.put("/", new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer first, Integer second) {
                return first / second;
            }
        });
    }

    static {
        operators.put("+", (first, second) -> first + second);
        operators.put("-", (first, second) -> first - second);
        operators.put("*", (first, second) -> first * second);
        operators.put("/", (first, second) -> first / second);
    }
}
