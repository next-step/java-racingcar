package caculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int calculate(String text) {

        if (isBlank(text)) {
            return 0;
        }
        return getResult(validateArray(toInt(split(text))));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        if (hasCustomDelimiter(text)) {
            return customSplit(text);
        }
        return text.split(",|:");
    }

    private static boolean hasCustomDelimiter(String text) {
        return CUSTOM_PATTERN.matcher(text).find();
    }

    private static String[] customSplit(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        String delimiter = matcher.group(1);
        return matcher.group(2).split(delimiter);
    }

    private static int[] toInt(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private static int[] validateArray(int[] numbers) {
        for (int number : numbers) {
            IsPositiveInteger(number);
        }
        return numbers;
    }

    private static void IsPositiveInteger(int number) {
        if (number < 0) {
            throw new RuntimeException("Number must be Positive");
        }
    }

    private static int getResult(int[] values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }
}
