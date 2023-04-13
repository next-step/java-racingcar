package step2;

import java.util.Objects;

public class StringSumCalculator {

    public static final int DEFAULT_RESULT_VALUE = 0;

    public static int calculate(String text) {
        if (!isValidText(text)) return DEFAULT_RESULT_VALUE;
        String[] split = TextSeparator.separate(text);
        return new PositiveNumbers(split).toIntegerList()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static boolean isValidText(String text) {
        return !(Objects.isNull(text) || text.isBlank() || text.isEmpty());
    }
}
