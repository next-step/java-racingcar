package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static final String DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int add(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);

        if (!matcher.find()) {
            return text.split(DELIMITER);
        }

        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    private static int[] toInts(String[] strings) {
        int[] numbers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            numbers[i] = parseValidNumber(strings[i]);
        }
        return numbers;
    }

    private static int parseValidNumber(String text) {
        try {
            int number = Integer.parseInt(text);
            validateNegative(number);
            return number;
        } catch (Exception e) {
            if (text == null || text.isBlank()) {
                return 0;
            }
            throw new RuntimeException();
        }
    }

    private static void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}
