package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final int SEPARATOR_GROUP = 1;
    private static final int EXPRESSION_GROUP = 2;

    private Calculator() {}

    public static int calculate(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toUnsignedInts(split(text)));
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
            return matcher.group(EXPRESSION_GROUP);
        }
        return text;
    }

    private static String extractSeparator(String text) {
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(SEPARATOR_GROUP);
        }
        return DEFAULT_SEPARATOR;
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number :numbers) {
            result += number;
        }
        return result;
    }

    private static int[] toUnsignedInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseUnsignedInt(values[i]);
        }
        return numbers;
    }
}
