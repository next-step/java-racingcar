package step2;

import java.util.Arrays;

public class StringAddCalculator {

    private static final int ZERO = 0;
    public static final String SEPARATOR = ",";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }
        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        return text.split(SEPARATOR);
    }

    private static int[] toInts(String[] values) {
        return Arrays.stream(values)
            .mapToInt(StringAddCalculator::toInt)
            .toArray();
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
