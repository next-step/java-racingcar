package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String SEPARATOR = ",|:";
    public static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";

    public static int splitAndAddString(String numbersText) {
        if (isEmptyText(numbersText)) {
            return 0;
        }

        return add(stringArrayToIntArray(split(numbersText)));
    }

    private static String[] split(String numbersText) {
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR).matcher(numbersText);

        if (containCustomSeparator(m)) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return numbersText.split(SEPARATOR);
    }

    private static boolean containCustomSeparator(Matcher m) {
        return m.find();
    }

    public static int[] stringArrayToIntArray (String[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = textToInt(numbers[i]);
        }
        return result;
    }

    private static int add(int[] numbers) {
        int result = 0;

        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int textToInt(String text) {
        int number = Integer.parseInt(text);

        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private static boolean isEmptyText(String numbersText) {
        return numbersText == null || numbersText.isEmpty();
    }
}
