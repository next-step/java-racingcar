package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_SEPARATOR = ",|:";

    public static int calculate(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        return extractExpression(text).split(extractSeparator(text));
    }

    private static String extractExpression(String text) {
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return text;
    }

    private static String extractSeparator(String text) {
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return DEFAULT_SEPARATOR;
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }
}
