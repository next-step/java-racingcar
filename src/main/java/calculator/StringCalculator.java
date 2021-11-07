package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public class StringCalculator {

    private static final String SCHEME_SEPARATOR = " ";
    private static final Map<String, IntBinaryOperator> REGEX_STRATEGY = new HashMap<>();
    static {
        REGEX_STRATEGY.put("+", (first, second) -> first + second);
        REGEX_STRATEGY.put("-", (first, second) -> first - second);
        REGEX_STRATEGY.put("*", (first, second) -> first * second);
        REGEX_STRATEGY.put("/", (first, second) -> first / second);
    }

    public int execute(String formula) {
        String[] keywords = formula.split(SCHEME_SEPARATOR);
        final int first = Integer.parseInt(keywords[0]);
        final String sign = keywords[1];
        final int second = Integer.parseInt(keywords[2]);

        return REGEX_STRATEGY.get(sign).applyAsInt(first, second);
    }
}
