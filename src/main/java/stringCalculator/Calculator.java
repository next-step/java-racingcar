package stringCalculator;

import java.util.Objects;

public class Calculator {
    private static final int DEFAULT_RETURN_VALUE = 0;

    private Calculator() {}

    public static int sumText(String text) {
        if (isBlank(text)) {
            return DEFAULT_RETURN_VALUE;
        }
        return sum(TextParser.parsedText(text));
    }

    private static boolean isBlank(String text) {
        return Objects.isNull(text) || text.isBlank();
    }

    private static int sum(int[] intValues) {
        int sum = DEFAULT_RETURN_VALUE;
        for (int value : intValues) {
            sum += value;
        }
        return sum;
    }
}
