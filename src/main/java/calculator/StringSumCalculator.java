package calculator;

import java.util.List;

public class StringSumCalculator {
    private final static int DEFAULT_RESULT = 0;

    public static int splitAndSum(String input) {
        if (isNullOrBlank(input)) {
            return DEFAULT_RESULT;
        }

        List<String> stringOperands = StringSplitterFactory.resolve(input).split();
        return Operands.fromStringList(stringOperands).sum();
    }

    private static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }
}
